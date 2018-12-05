package com.game.ssm.control;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.game.ssm.entiy.GameDuty;
import com.game.ssm.service.impl.AdminOpServiceImpl;
import com.game.ssm.utils.DateUtil;

@Controller
@RequestMapping("/")
public class AdminDutyPublishControl extends ControlBase{
	 @Autowired
	 private AdminOpServiceImpl adminOpServiceImpl;
	
	 /**
	  * @author c.~
	  * @time   2018/12/1 11:05
	  * @version 管理员任务发布模块,任务发布消息处理
	  * */
	 @RequestMapping(value="ManagerDutyPublish",method=RequestMethod.POST)
	 public String dutyPublish(@RequestParam("dutyGrade") String dutyGrade
	 ,@RequestParam("managerGrade") String managerGrade,@RequestParam("publishTime") String publishTime,@RequestParam("dutyInfo")String dutyInfo)
	 {  
		 //转换管理员级别
		int admin_authority=0;
	    if("二级管理员".equals(managerGrade))
	    {
	    	admin_authority=2;
	    }
	    else if("三级管理员".equals(managerGrade))
	    {
	    	admin_authority=3;
	    }
	    //对发布时间进行格式转换
	    logger.info("上传时间:"+publishTime);
	    Timestamp date=DateUtil.StringtoTimestamp(publishTime,"yyyy-MM-dd HH-mm-ss");
	    //保存发布的任务
	    GameDuty gameDuty=new GameDuty(admin_authority,dutyGrade,date,dutyInfo,false);
	   if(adminOpServiceImpl.addAdminDutyInfo(gameDuty))
	   {
		   return "ServerP/Message/instationMessage";
	   }
	   return "ServerP/Message/instationMessage";
	 }
}
