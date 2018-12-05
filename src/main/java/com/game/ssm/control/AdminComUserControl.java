package com.game.ssm.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.game.ssm.entiy.Admin;
import com.game.ssm.entiy.Member;
import com.game.ssm.entiy.UserInfoPlugin;
import com.game.ssm.service.impl.AdminOpServiceImpl;
import com.game.ssm.utils.Page;
@Service
@RequestMapping("/")
public class AdminComUserControl extends ControlBase{
   
	 @Autowired
	 private AdminOpServiceImpl adminOpServiceImpl;
	 
	 
	/**
	  * @author c.~
	  * @time 2018/11/19 8:45
	  * @version 获取所有用户信息
	  * */
	 @RequestMapping(value="ComUserInfo",method=RequestMethod.GET)
	 public ModelAndView queryAllComUserInfo(HttpServletRequest request)throws ServletException,IOException
	 {     
		   HttpSession session=request.getSession();
		   int curpage=Integer.valueOf((String)session.getAttribute("UserAllCurPage"));
		   logger.info("当前页:"+curpage);
		   ModelAndView modelAndView=new ModelAndView("ServerP/ComUser/UserInfo");
		   Admin loginadmin=(Admin)session.getAttribute("LoginAdmin");
		   //获取用户信息,并分页
		   Map<String, Object> MemberInfoMap=new HashMap<String, Object>();
		   Page<UserInfoPlugin> member=new Page<UserInfoPlugin>();
		   member.setShowCount(1);
		   member.setCurrentPage(curpage);
		   MemberInfoMap.put("page", member);
		   MemberInfoMap.put("gamesCategoryadmin_id",loginadmin.getAdmin_id());
		   member=adminOpServiceImpl.queryUserInfoList(MemberInfoMap);
		   modelAndView.addObject("ComUserAllInfo", member.getResult());
		   String cur=String.valueOf(curpage);
		   String totalPage=String.valueOf(member.getTotalPage());
		   session.setAttribute("ComUserAllInfoTotalPage",totalPage);
		   modelAndView.addObject("ComUserAllInfoTotalResult",member.getTotalResult());
		   modelAndView.addObject("ComUserAllInfoTotalPage", totalPage);
		   modelAndView.addObject("UserAllCurPage",cur);
		   return modelAndView;
	 }
	 
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 首页
	 * @throws IOException 
	  * */
	 @RequestMapping(value="UserindexPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerIndexPage(HttpServletRequest request)throws ServletException, IOException
	 {
		 HttpSession session=request.getSession();
		 session.setAttribute("UserAllCurPage", "1");
		 ModelAndView modelAndView=queryAllComUserInfo(request);
		 return modelAndView;
	 }
	 
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 尾页
	 * @throws IOException 
	  * */
	 @RequestMapping(value="UserendPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerEndPage(HttpServletRequest request)throws ServletException, IOException
	 {
		 HttpSession session=request.getSession();
		 String end=(String)session.getAttribute("ComUserAllInfoTotalPage");
		 session.setAttribute("UserAllCurPage", end);
		 ModelAndView modelAndView=queryAllComUserInfo(request);
		 return modelAndView;
	 }
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 前一页
	 * @throws IOException 
	  * */
	 @RequestMapping(value="UserpreViewPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerPreviewPage(HttpServletRequest request)throws ServletException, IOException
	 {
		 HttpSession session=request.getSession();
		 String previewPage=(String)session.getAttribute("UserAllCurPage");
		 int pre=Integer.valueOf(previewPage)-1;
		 if(pre==0||pre<0)
		 {
			 session.setAttribute("UserAllCurPage", "1");
			 ModelAndView modelAndView = queryAllComUserInfo(request);
			 return modelAndView;
		 }
		 String prePage=String.valueOf(pre);
		 session.setAttribute("UserAllCurPage", prePage);
		 ModelAndView modelAndView = queryAllComUserInfo(request);
		 return modelAndView;
	 }
	 /**
	  * @author c.~
	  * @time 2018/11/23 10:52
	  * @version 下一页
	  * @throws IOException 
	  * */
	 @RequestMapping(value="UsernextPage",method=RequestMethod.GET)
	 public ModelAndView AdminManagerNextPage(HttpServletRequest request)throws ServletException, IOException
	 {
		HttpSession session=request.getSession();
		String cur=(String)session.getAttribute("UserAllCurPage");
		int curInt=Integer.valueOf(cur);		
		String end=(String)session.getAttribute("ComUserAllInfoTotalPage");
		logger.info("总页数:"+end);
		int endInt=Integer.valueOf(end);
		if((curInt+1)>=endInt)
		{
			session.setAttribute("UserAllCurPage", end);
			return queryAllComUserInfo(request);
		}
		String curPage=String.valueOf(curInt+1);
		session.setAttribute("UserAllCurPage", curPage);
		return queryAllComUserInfo(request);
	 }
	 
	 
	 
	 
}
