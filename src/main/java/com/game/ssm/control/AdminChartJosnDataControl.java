package com.game.ssm.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.ssm.entiy.UserGameArticleMonth;
import com.game.ssm.entiy.UserRegisterMonthJson;
import com.game.ssm.service.impl.AdminOpServiceImpl;

@Service
@RequestMapping("/")
public class AdminChartJosnDataControl extends ControlBase{
	@Autowired
	private AdminOpServiceImpl adminOpServiceImpl; 
	
	/**
	 * @author c.~
	 * @time 2018/11/20 8:31
	 * @version 用户评论管理模块   ----游讯网站数据分析图表设计        
	 **/
	@RequestMapping(value="queryMonthUserRegisterAla",method=RequestMethod.GET)
	@ResponseBody
	public UserRegisterMonthJson  queryJosnDataAnalysis(HttpServletRequest request)throws ServletException
	{
		//ModelAndView modelAndView=new ModelAndView();
		//获取图表所需内容数据，并形成json格式
		/**
		 * 用户注册数量月统计
		 * */  
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("gamesCategorycreate_time", "2018");
		UserRegisterMonthJson userRegister=adminOpServiceImpl.queryUserRegisterMonthJson(map);
		return userRegister;	
	}	
	@RequestMapping(value="queryMonthArticleAla",method=RequestMethod.GET)
	@ResponseBody
	public UserGameArticleMonth queryJsonArticleAnalysis(HttpServletRequest request)
	{
		/**
		 * 游讯文章上传数量月统计模块
		 * */
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("upload_time", "2018");
		UserGameArticleMonth userGameArticleMonth=adminOpServiceImpl.queryUserArticleMonthJson(map);
		return userGameArticleMonth;	
	}
	/**
	 * 用户热评论统计分布图
	 * */
    
}
