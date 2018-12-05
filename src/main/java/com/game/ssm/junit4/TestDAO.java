package com.game.ssm.junit4;


import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.game.ssm.dao.AdminOpDAO;
import com.game.ssm.entiy.Admin;
import com.game.ssm.entiy.Admin_Authority;
import com.game.ssm.entiy.Admin_duty;
import com.game.ssm.entiy.BigGameType;
import com.game.ssm.entiy.Member;
import com.game.ssm.entiy.Member_Authority;
import com.game.ssm.entiy.UserRegisterMonthJson;
import com.game.ssm.entiy.uploadArticleInfo;
import com.game.ssm.utils.Page;


public class TestDAO {
	
	SqlSessionFactory sqlSessionFactory=null;
	Reader reader;
	SqlSession session=null;
	AdminOpDAO admindao;
	public void Init()
	{
		try {
			reader = Resources.getResourceAsReader("test_myBatis_config.xml");
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 session = sqlSessionFactory.openSession();
    	 admindao=session.getMapper(AdminOpDAO.class);
	}
	
   @Test
   public void testDAO()
   {   
	   Init();
	   String admin_email="13808547353@142.com";
	   String admin_password="123456";
	   Map<String, String> map=new HashMap<String, String>();
	   map.put("admin_email", admin_email);
	   map.put("admin_password", admin_password);
	   Admin login=admindao.LoginAdmin(map);
	   System.out.println("管理员:"+login.getAdmin_name()+"\n权限菜单长度:"+login.getAuthority().size());
   }
   
   @Test
   public void testPluginAdminAll()
   {
	   Init();
	   Map<String, Object> login=new HashMap<String, Object>();
	   Page<Admin> admin=new Page<Admin>();
	   admin.setShowCount(1);
	   admin.setCurrentPage(1);
	   login.put("page", admin);
	   List<Admin> list=admindao.queryAdminAllInfoListPage(login);
	   System.out.println("查询到的管理员信息条数"+list.size());
	   for(Admin ad:list)
	   {
		  System.out.println("查询到的管理员姓名:"+ad.getAdmin_name());
		  for(Admin_Authority ac:ad.getAuthority())
		  {
			  System.out.println("查询到的权限菜单:"+ac.getAu_name());
		  }
	   }
   }
   @Test
   public void testPluginMemberAll()
   {
	   Init();
	   Map<String, Object> login=new HashMap<String, Object>();
	   Page<Member> member=new Page<Member>();
	   member.setShowCount(1);
	   member.setCurrentPage(1);
	   login.put("page", member);
	   List<Member> list=admindao.queryMemberAllInfoListPage(login);
	   System.out.println("查询到的用户信息条数"+list.size());
	   for(Member ad:list)
	   {
		  System.out.println("查询到的用户姓名:"+ad.getMember_name());
		  for(Member_Authority ac:ad.getMemberMenus())
		  {
			  System.out.println("查询到的权限菜单:"+ac.getMau_name());
		  }
	   }
   }
   
   @Test
   public void testUserAnalysis()
   {
	   Init(); 
	   Map<String, Object> queryMonthRegisterCount=new HashMap<String, Object>();
	   queryMonthRegisterCount.put("gamesCategorycreate_time", "2018");
	   UserRegisterMonthJson test=admindao.queryUserRegisterMonthAnalysis(queryMonthRegisterCount);
	   System.out.println("查询的数据条数:"+test.getApril());
   }
   
   @Test
   public void testAddGameType()
   {
	   Init(); 
	   BigGameType newGameType=new BigGameType("LOL","最火的MOBA游戏",  ".....",1, 1);
	   boolean flag=admindao.addBigGameType(newGameType);
	   System.out.println("添加是否成功:"+flag);
   }
   
   @Test
   public void testquerySmallInfo()
   {
	   Init();
	   Map<String, Object> test= new HashMap<String, Object>();
	   
	   List<String> info=admindao.queryGameSmallInfo(test);
	   System.out.println(info.get(1));
   }
   @Test
   public void testAddArticle()
   {
	   Init();
	   
	   //uploadArticleInfo articleInfo=new uploadArticleInfo(6,"IG夺冠","155515","windc",1,"2018-11-29 16-23-57");
   
   }
   @Test
   public void  testDuty()
   {
	     Init();
	     Map<String, Object> adminAll=new HashMap<String, Object>();
		 Page<Admin_duty> adminPage=new Page<Admin_duty>();
		 adminPage.setShowCount(1);
		 adminPage.setCurrentPage(1);
		 adminAll.put("page", adminPage);
		 List<Admin_duty> list=admindao.getDutyInfoAllByTimeListPage(adminAll);
		 System.out.println("查询到的任务条数:"+list.size());
		   for(Admin_duty ad:list)
		   {
			  System.out.println("查询到的任务信息:"+ad.getDuty_publish_info());		 
		   }
   }
}
