package com.game.ssm.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.game.ssm.entiy.Admin_duty;
import com.game.ssm.service.impl.AdminOpServiceImpl;
import com.game.ssm.utils.Page;

@Controller
@RequestMapping("/")
public class AdminInstationMessageControl extends ControlBase{
	@Autowired
	private AdminOpServiceImpl adminOpServiceImpl;
	
	/**
	  * @author c.~
	  * @time 2018/11/30 20:48
	  * @version 站内消息模块
	  * */
	@RequestMapping(value="instationMessage",method=RequestMethod.GET)
	public ModelAndView instationMessageInfo(HttpServletRequest request) throws ServletException
	{   
		 //搜索2.3级管理员的最新任务信息
		 HttpSession session=request.getSession();
		 int curpage=Integer.valueOf((String)session.getAttribute("DutyAllCurPage"));
		 logger.info("当前页:"+curpage);
		 ModelAndView modelAndView=new ModelAndView("ServerP/Message/instationMessage");		
		 Map<String, Object> adminAll=new HashMap<String, Object>();
		 Page<Admin_duty> adminPage=new Page<Admin_duty>();
		 adminPage.setShowCount(10);
		 adminPage.setCurrentPage(curpage);
		 adminAll.put("page", adminPage);
		 adminPage=adminOpServiceImpl.queryAdminDutyList(adminAll);
		 List<Admin_duty> queryAdmin=adminPage.getResult();
		 String cur=String.valueOf(curpage);			
	     modelAndView.addObject("adminDuty", queryAdmin);
	     //logger.info("总页数:"+adminPage.getTotalPage());
	     String totalPage=String.valueOf(adminPage.getTotalPage());
		 session.setAttribute("AdminDutyTotalPage",totalPage);
		 modelAndView.addObject("AdminDutyTotalResult", adminPage.getTotalResult());
		 //modelAndView.addObject("AdminDutyTotalPage",adminPage.getTotalPage());
		 modelAndView.addObject("DutyAllCurPage",cur);	 	
		 return modelAndView;
	}
	/**
	 * 异步刷新分页任务榜
	 * */

	
	public Object queryDutyInfo(HttpServletRequest request)
	{
		 HttpSession session=request.getSession();
		 int curpage=Integer.valueOf((String)session.getAttribute("DutyAllCurPage"));
    	 Map<String, Object> adminAll=new HashMap<String, Object>();
		 Page<Admin_duty> adminPage=new Page<Admin_duty>();
		 adminPage.setShowCount(10);
		 adminPage.setCurrentPage(curpage);
		 adminAll.put("page", adminPage);
		 adminPage=adminOpServiceImpl.queryAdminDutyList(adminAll);
		 List<Admin_duty> queryAdmin=adminPage.getResult();
		 String cur=String.valueOf(curpage);			
    	 return queryAdmin;
	}
	/**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 首页
	  * */
	 @RequestMapping(value="MessagaindexPage",method=RequestMethod.POST)
	 @ResponseBody
	 public Object AdminManagerIndexPage(HttpServletRequest request)throws ServletException
	 {   
		 ModelAndView modelAndView=new ModelAndView("ServerP/GameSourceUpload/gameSourceUpload");
		 HttpSession session=request.getSession();
		 session.setAttribute("DutyAllCurPage", "1");
		 List<Admin_duty> queryAdmin=(List<Admin_duty>) queryDutyInfo(request);
		 modelAndView.addObject("adminDuty", queryAdmin);
		 return queryAdmin;
	 }
	 
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 尾页
	  * */
	 @RequestMapping(value="MessageendPage",method=RequestMethod.POST)
	 @ResponseBody
	 public Object AdminManagerEndPage(HttpServletRequest request)throws ServletException
	 {   
		 ModelAndView modelAndView=new ModelAndView("ServerP/GameSourceUpload/gameSourceUpload");
		 HttpSession session=request.getSession();
		 String end=(String)session.getAttribute("AdminDutyTotalPage");
		 session.setAttribute("DutyAllCurPage", end);
		 List<Admin_duty> queryAdmin=(List<Admin_duty>) queryDutyInfo(request);
		 modelAndView.addObject("adminDuty", queryAdmin);
		 return queryAdmin;
	 }
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 前一页
	  * */
	 @RequestMapping(value="MessagepreViewPage",method=RequestMethod.POST)
	 @ResponseBody
	 public Object AdminManagerPreviewPage(HttpServletRequest request)throws ServletException
	 {    
		 ModelAndView modelAndView=new ModelAndView("ServerP/GameSourceUpload/gameSourceUpload");
		 HttpSession session=request.getSession();
		 String previewPage=(String)session.getAttribute("DutyAllCurPage");
		 int pre=Integer.valueOf(previewPage)-1;
		 if(pre==0||pre<0)
		 {   
			 session.setAttribute("DutyAllCurPage", "1");
			 List<Admin_duty> queryAdmin=(List<Admin_duty>) queryDutyInfo(request);
			 modelAndView.addObject("adminDuty", queryAdmin);
			 return queryAdmin;
		 }
		 String prePage=String.valueOf(pre);
		 session.setAttribute("DutyAllCurPage", prePage);
		 List<Admin_duty> queryAdmin=(List<Admin_duty>) queryDutyInfo(request);
		 modelAndView.addObject("adminDuty", queryAdmin);
		 return queryAdmin;
	 }
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 下一页
	  * */
	 @RequestMapping(value="MessagenextPage",method=RequestMethod.POST)
	 @ResponseBody
	 public Object AdminManagerNextPage(HttpServletRequest request)throws ServletException
	 {   
		ModelAndView modelAndView=new ModelAndView("ServerP/GameSourceUpload/gameSourceUpload");
		HttpSession session=request.getSession();
		String cur=(String)session.getAttribute("DutyAllCurPage");
		int curInt=Integer.valueOf(cur);		
		String end=(String)session.getAttribute("AdminDutyTotalPage");
		logger.info("总页数:"+end);
		int endInt=Integer.valueOf(end);
		if((curInt+1)>=endInt)
		{
			session.setAttribute("DutyAllCurPage", end);
			List<Admin_duty> queryAdmin=(List<Admin_duty>) queryDutyInfo(request);
			modelAndView.addObject("adminDuty", queryAdmin);
			return queryAdmin;
		}
		String curPage=String.valueOf(curInt+1);
		session.setAttribute("DutyAllCurPage", curPage);
		List<Admin_duty> queryAdmin=(List<Admin_duty>) queryDutyInfo(request);
		modelAndView.addObject("adminDuty", queryAdmin);
		return queryAdmin;
	 }
	
}
