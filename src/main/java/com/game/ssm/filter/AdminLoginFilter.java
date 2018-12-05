package com.game.ssm.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.game.ssm.entiy.Admin;

@Service
public class AdminLoginFilter implements Filter{

	private static Logger logger=LogManager.getLogger(AdminLoginFilter.class);

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		String requestUrl=request.getRequestURI();
		logger.info("用户请求路径:"+requestUrl);
		requestUrl=requestUrl.substring(request.getContextPath().length());
		if(requestUrl.indexOf(";")>=0){ 
			requestUrl=requestUrl.substring(0, requestUrl.indexOf(";"));
 		}
		logger.info("截取的请求:"+requestUrl);
		if(requestUrl.endsWith("/")||requestUrl.endsWith("games.html"))
		{
			//后端只能访问login界面
			chain.doFilter(req, resp);
			return;
		}
		HttpSession session=request.getSession();
		
		Admin loginAdmin=(Admin)session.getAttribute("LoginAdmin");
		if(loginAdmin!=null)
		{
			//说明用户正在登录,可以访问其他页面
			logger.info("用户访问请求:"+requestUrl);
			chain.doFilter(req, resp);
			return;
		}else
		{    
		    //控制浏览器不使用缓存,即注销用户后，无法通过浏览器后退按钮回到注销前页面
			    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.setHeader("Pragma", "no-cache"); 
				response.setDateHeader("Expires", 0);
			//说明用户已退出登录
			logger.error("管理员未登录或长时间未操作,已强制退出!");
			PrintWriter out=((HttpServletResponse)resp).getWriter();
			out.write("<script> window.parent.frames.location.href='Game/ftl/ServerP/Login/index.html';</script>");
		} 
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
