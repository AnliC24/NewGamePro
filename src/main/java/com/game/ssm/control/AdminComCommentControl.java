package com.game.ssm.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.game.ssm.service.impl.AdminOpServiceImpl;

@Service
@RequestMapping("/")
public class AdminComCommentControl extends ControlBase{
	 @Autowired
	 private AdminOpServiceImpl adminOpServiceImpl;
	 
	 /**
	  * @author c.~
	  * @time 2018/11/19 15:54
	  * @version 分析用户模块，画出数据分析图
	  * */
	 @RequestMapping(value="ComUserCommentInfo",method=RequestMethod.GET)
	 @ResponseBody
	 public ModelAndView analysisComUserData()
	 {
		 ModelAndView modelAndView=new ModelAndView("ServerP/Comment/Comment");
		 return modelAndView;		 
	 }
}
