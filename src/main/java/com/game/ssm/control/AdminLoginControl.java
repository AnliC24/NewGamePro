package com.game.ssm.control;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.game.ssm.entiy.Admin;
import com.game.ssm.service.impl.AdminOpServiceImpl;

@Controller
@RequestMapping("/")
public class AdminLoginControl extends ControlBase {
   @Autowired
   private AdminOpServiceImpl adminOpServiceImpl;
   //freemark静态化编写
   @RequestMapping(value="login",method=RequestMethod.POST)
   public String loginAdmin(HttpServletRequest request,ModelMap map)
   {   
       HttpSession session=request.getSession();
       String email=request.getParameter("admin_email");
	   String passwd=request.getParameter("admin_password");
	   logger.info("email="+email);
	   logger.info("passwd="+passwd);
	   Map<String, String> loginInfo=new HashMap<String, String>();
	   loginInfo.put("admin_email", email);
	   loginInfo.put("admin_password", passwd);
	   if(adminOpServiceImpl.getloginAdminInfo(loginInfo)==null)
	   {   
		   map.addAttribute("flag", "fail");
		   return "ServerP/Login/index"; 
	   }
	   else
	   {
		   Admin LoginAdmin=adminOpServiceImpl.getloginAdminInfo(loginInfo);
		   session.setAttribute("LoginAdmin", LoginAdmin);
		   //存入权限菜单
		   session.setAttribute("authority",LoginAdmin.getAuthority());
		   session.setAttribute("AdminAllCurPage", "1");
		   session.setAttribute("DutyAllCurPage", "1");
		   session.setAttribute("UserAllCurPage", "1");
	   }
	   return "ServerP/Manager/user";
   }
   
   @RequestMapping(value="AdminLogin",params="act=logout")
   public String logoutAdmin(HttpServletRequest request,ModelMap map)
   { 
	 HttpSession session=request.getSession();
	 session.invalidate();
	 map.addAttribute("flag", "logout");
	 return "ServerP/Login/index"; 
   }
   @RequestMapping(value="updateInfo",params="ajaxUpdate")
   public void updateManagerInfo(HttpServletRequest request,HttpServletResponse response)
   throws IOException,ServletException
   {
	   //更新序列化内容
	   String name_nick=new String(request.getParameter("Manager_nick").getBytes("ios-8859-1"), "utf-8");
	   String address=new String(request.getParameter("Manager_address").getBytes("ios-8859-1"), "utf-8");
	   String telPhone=request.getParameter("telphone");
	   String sex=new String(request.getParameter("Sex").getBytes("iso-8859-1"), "utf-8");  
   }
   @RequestMapping(value="getLoginUserInfo")
   public ModelAndView getLoginUserInfo(HttpServletRequest request)throws ServletException,IOException
   {
	   HttpSession session=request.getSession();
	   Admin loginAdmin=(Admin)session.getAttribute("LoginAdmin");
	   Map<String, String> loginInfo=new HashMap<String, String>();
	   loginInfo.put("admin_email", loginAdmin.getAdmin_email());
	   loginInfo.put("admin_password", loginAdmin.getAdmin_password());
	   Admin AdminInfo=adminOpServiceImpl.getloginAdminInfo(loginInfo);
	   ModelAndView modelAndView=new ModelAndView("ServerP/Manager/user");  
	   modelAndView.addObject("LoginAdmin", AdminInfo);
	   return modelAndView;
   }
}
