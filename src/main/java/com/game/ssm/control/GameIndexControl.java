package com.game.ssm.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class GameIndexControl extends ControlBase{
	
	/**
	 * 跳转首页
	 * */
	@RequestMapping("/")
	public ModelAndView GameIndex()
	{    
		
		ModelAndView modelAndView=new ModelAndView("GameP/index/index");
		return modelAndView;
	}

}
