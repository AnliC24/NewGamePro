package com.game.ssm.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * 分页插件
 * MyBatis3.4.0之前版本，StatementHandler的prepar方法只有一个参数，要按下面配置
 * @Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
 * @author 
 */
@Intercepts({
	@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})
})
public class PagePlugin implements Interceptor, Serializable {

	private static String dialect = ""; //方言：指定是哪种类型的数据库
	private static String pageSqlId = "";

	@SuppressWarnings("unchecked")
	public Object intercept(Invocation ivk) throws Throwable {

		if (ivk.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk
					.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper
					.getValueByFieldName(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper
					.getValueByFieldName(delegate, "mappedStatement");

			if (mappedStatement.getId().matches(pageSqlId)) {
				BoundSql boundSql = delegate.getBoundSql();
				Object parameterObject = boundSql.getParameterObject();
				if (parameterObject == null) {
					throw new NullPointerException("parameterObject error");
				} else {
				

					Page<Object> page = null;  //封装成Page对象
					if (parameterObject instanceof Page) {
						page = (Page<Object>) parameterObject;
//						page.setTotalResult(count);
					} else if (parameterObject instanceof Map) {
						Map<String, Object> map = (Map<String, Object>) parameterObject;
						page = (Page<Object>) map.get("page");
						if (page == null){
//							page = new Page();
							return ivk.proceed();//无Page则不拦截，不做分页
						}
//						page.setTotalResult(count);
					} else {
						Field pageField = ReflectHelper.getFieldByFieldName(
								parameterObject, "page");
						if (pageField != null) {
							page = (Page<Object>) ReflectHelper.getValueByFieldName(
									parameterObject, "page");
							if (page == null){
//								page = new Page();
								return ivk.proceed();//无Page则不拦截，不做分页
							}
//							page.setTotalResult(count);
							ReflectHelper.setValueByFieldName(parameterObject,"page", page);
						} else {
//							throw new NoSuchFieldException(parameterObject
//									.getClass().getName());							
							return ivk.proceed();//无Page则不拦截，不做分页
						}
					}
					
					Connection connection = (Connection) ivk.getArgs()[0];
					String sql = boundSql.getSql();
					String countSql = "select count(distinct admin_id) from (" + sql
							+ ") myCount";
					System.out.println("总数sql 语句:" + countSql);
					PreparedStatement countStmt = connection
							.prepareStatement(countSql);
					BoundSql countBS = new BoundSql(mappedStatement
							.getConfiguration(), countSql, boundSql
							.getParameterMappings(), parameterObject);
					setParameters(countStmt, mappedStatement, countBS,
							parameterObject);
					ResultSet rs = countStmt.executeQuery();
					int count = 0;
					if (rs.next()) {
						count = rs.getInt(1);
					}
					rs.close();
					countStmt.close();
					System.out.println("总记录数:"+count);
					page.setTotalResult(count);  //保存总记录数到page对象中
					
					String pageSql = generatePageSql(sql, page);
					System.out.println("page sql:" + pageSql);
					ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql);
				}
			}
		}
		return ivk.proceed();
	}

	private void setParameters(PreparedStatement ps,
			MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(
				mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration
					.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null
					: configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry
							.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName
							.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value)
									.getValue(
											propertyName.substring(prop
													.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject
								.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException(
								"There was no TypeHandler found for parameter "
										+ propertyName + " of statement "
										+ mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value, parameterMapping
							.getJdbcType());
				}
			}
		}
	}

	private String generatePageSql(String sql, Page page) {
		if (page != null && (dialect != null || !dialect.equals(""))) {
			StringBuffer pageSql = new StringBuffer();
			if ("mysql".equals(dialect)) {
				pageSql.append(sql);
				pageSql.append(" limit " + (page.getCurrentPage()-1) + ","
						+ page.getShowCount());
			} else if ("oracle".equals(dialect)) {
				pageSql
						.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
				pageSql.append(sql);
				pageSql.append(")  tmp_tb where ROWNUM<=");
				pageSql.append(page.getCurrentResult() + page.getShowCount());
				pageSql.append(") where row_id>");
				pageSql.append(page.getCurrentResult());
			}//扩展：支持其他的数据库分页
			return pageSql.toString();
		} else {
			return sql;
		}
	}

	public Object plugin(Object arg0) {
		// TODO Auto-generated method stub
		return Plugin.wrap(arg0, this);
	}

	public void setProperties(Properties p) {
		dialect = p.getProperty("dialect");
		if (dialect == null || dialect.equals("")) {
			try {
				throw new PropertyException("dialect property is not found!");
			} catch (PropertyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pageSqlId = p.getProperty("pageSqlId");
		if (dialect == null || dialect.equals("")) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}