package com.game.ssm.control;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControl extends ControlBase{
    
	@RequestMapping("toGame")
	public ModelAndView test()
	{   
		ModelAndView modelAndView=new ModelAndView("GameP/games/games");
		return modelAndView;
	}
	@RequestMapping("toIndex")
	public ModelAndView testIndex()
	{   
		ModelAndView modelAndView=new ModelAndView("GameP/index/index");
		return modelAndView;
	}
	@RequestMapping("toNew")
	public ModelAndView testNew()
	{   
		ModelAndView modelAndView=new ModelAndView("GameP/new/news");
		return modelAndView;
	}
	@RequestMapping("toContact")
	public ModelAndView testContact()
	{   
		ModelAndView modelAndView=new ModelAndView("GameP/contact/contact");
		return modelAndView;
	}
	@RequestMapping("toAbout")
	public ModelAndView testAbout()
	{   
		ModelAndView modelAndView=new ModelAndView("GameP/about/about");
		return modelAndView;
	}
	@RequestMapping("toRegister")
	public ModelAndView testRegister()
	{   
		ModelAndView modelAndView=new ModelAndView("GameP/register/register");
		return modelAndView;
	}
}
