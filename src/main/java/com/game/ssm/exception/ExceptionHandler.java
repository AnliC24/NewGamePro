package com.game.ssm.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ExceptionHandler implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		// TODO Auto-generated method stub
		if(exception instanceof IOException)
		{
			return new ModelAndView("Error/index");
		}else if(exception instanceof SQLException)
		{
			return new ModelAndView("Error/index");
		}
		return null;
	}

	

}
