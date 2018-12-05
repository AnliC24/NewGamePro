package com.game.ssm.control;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.game.ssm.entiy.Admin;
import com.game.ssm.entiy.AdminInfoPlugin;
import com.game.ssm.service.impl.AdminOpServiceImpl;
import com.game.ssm.utils.Page;
@Service
@RequestMapping("/")
@SessionAttributes
public class AdminManagerControl extends ControlBase{
	 @Autowired
	 private AdminOpServiceImpl adminOpServiceImpl;
	 
	 /**
	  *Admin信息管理  
	  *管理员信息管理模块
	  *@author c.~
	  *@time 2018/11/16
	  *@version 获取全部管理员信息
	  * */

	 @RequestMapping(value="AdminInfo",method=RequestMethod.GET)
	 public ModelAndView AdminManagerInfo(HttpServletRequest request)throws ServletException
	 {    
		 HttpSession session=request.getSession();
		 //获取搜索页
		 int curpage=Integer.valueOf((String)session.getAttribute("AdminAllCurPage"));
		 logger.info("当前页:"+curpage);
		 Map<String, Object> adminAll=new HashMap<String, Object>();
		 Page<AdminInfoPlugin> adminPage=new Page<AdminInfoPlugin>();
		 adminPage.setShowCount(1);
		 adminPage.setCurrentPage(curpage);
		 adminAll.put("page", adminPage);
		 adminPage=adminOpServiceImpl.queryAdminInfoList(adminAll);
		 List<AdminInfoPlugin> queryAdmin=adminPage.getResult();
		 String cur=String.valueOf(curpage);
		// session.setAttribute("AdminAll", queryAdmin);
		 ModelAndView modelAndView = new ModelAndView("ServerP/Manager/AdminInfo");
		 modelAndView.addObject("AdminAll", queryAdmin);
		 logger.info("总页数:"+adminPage.getTotalPage());
		 String totalPage=String.valueOf(adminPage.getTotalPage());
		 session.setAttribute("AdminAllTotalPage",totalPage);
		 modelAndView.addObject("AdminAllTotalResult", adminPage.getTotalResult());
		 modelAndView.addObject("AdminAllTotalPage",adminPage.getTotalPage());
		 modelAndView.addObject("AdminAllCurPage",cur);
		 return modelAndView;
	 }
	 
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 首页
	  * */
	 @RequestMapping(value="indexPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerIndexPage(HttpServletRequest request)throws ServletException
	 {
		 HttpSession session=request.getSession();
		 session.setAttribute("AdminAllCurPage", "1");
		 ModelAndView modelAndView=AdminManagerInfo(request);
		 return modelAndView;
	 }
	 
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 尾页
	  * */
	 @RequestMapping(value="endPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerEndPage(HttpServletRequest request)throws ServletException
	 {
		 HttpSession session=request.getSession();
		 String end=(String)session.getAttribute("AdminAllTotalPage");
		 session.setAttribute("AdminAllCurPage", end);
		 ModelAndView modelAndView=AdminManagerInfo(request);
		 return modelAndView;
	 }
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 前一页
	  * */
	 @RequestMapping(value="preViewPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerPreviewPage(HttpServletRequest request)throws ServletException
	 {
		 HttpSession session=request.getSession();
		 String previewPage=(String)session.getAttribute("AdminAllCurPage");
		 int pre=Integer.valueOf(previewPage)-1;
		 if(pre==0||pre<0)
		 {
			 session.setAttribute("AdminAllCurPage", "1");
			 ModelAndView modelAndView = AdminManagerInfo(request);
			 return modelAndView;
		 }
		 String prePage=String.valueOf(pre);
		 session.setAttribute("AdminAllCurPage", prePage);
		 ModelAndView modelAndView = AdminManagerInfo(request);
		 return modelAndView;
	 }
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 下一页
	  * */
	 @RequestMapping(value="nextPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerNextPage(HttpServletRequest request)throws ServletException
	 {
		HttpSession session=request.getSession();
		String cur=(String)session.getAttribute("AdminAllCurPage");
		int curInt=Integer.valueOf(cur);		
		String end=(String)session.getAttribute("AdminAllTotalPage");
		logger.info("总页数:"+end);
		int endInt=Integer.valueOf(end);
		if((curInt+1)>=endInt)
		{
			session.setAttribute("AdminAllCurPage", end);
			return AdminManagerInfo(request);
		}
		String curPage=String.valueOf(curInt+1);
		session.setAttribute("AdminAllCurPage", curPage);
		return AdminManagerInfo(request);
	 }
}
