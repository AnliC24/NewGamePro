package com.game.ssm.junit4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.game.ssm.entiy.Admin;
import com.game.ssm.entiy.Admin_Authority;
import com.game.ssm.entiy.Admin_duty;
import com.game.ssm.entiy.BigGameType;
import com.game.ssm.entiy.Member;
import com.game.ssm.entiy.Member_Authority;
import com.game.ssm.entiy.UserRegisterMonthJson;
import com.game.ssm.service.AdminOpService;
import com.game.ssm.utils.Page;



public class TestService {
	private static AdminOpService  adminOpservice;
	@BeforeClass
    public static void init()
    {  
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		adminOpservice=(AdminOpService)context.getBean("adminOpServiceImpl");
    }
	
	@Test
	public void testAdminAllInfo()
	{
		   Map<String, Object> login=new HashMap<String, Object>();
		   Page<Admin> admin=new Page<Admin>();
		   admin.setShowCount(12);
		   admin.setCurrentPage(1);
		   login.put("page", admin);
		   admin=adminOpservice.queryAdminAllInfoList(login);
		   
		   System.out.println("共:"+admin.getTotalResult()+"条数据");
		   System.out.println("共"+admin.getTotalPage()+"页");
		   System.out.println("管理员信息条数:"+admin.getResult().size());
		   for(Admin ad:admin.getResult())
		   {
			   System.out.println("查询到的信息:"+ad.getAdmin_name());
			   for(Admin_Authority ac:ad.getAuthority())
			   {
				   System.out.println("查询到的权限菜单:"+ac.getAu_name());
			   }
		   }
		   
	}
	@Test
	public void testMemberAllInfo()
	{
		   Map<String, Object> login=new HashMap<String, Object>();
		   Page<Member> member=new Page<Member>();
		   member.setShowCount(1);
		   member.setCurrentPage(1);
		   login.put("page", member);
		   member=adminOpservice.queryMemberAllInfoLits(login);
		   
		   System.out.println("共:"+member.getTotalResult()+"条数据");
		   System.out.println("共"+member.getTotalPage()+"页");
		   System.out.println("用户信息条数:"+member.getResult().size());
		   for(Member ad:member.getResult())
		   {
			   System.out.println("查询到的信息:"+ad.getMember_name());
			   for(Member_Authority ac:ad.getMemberMenus())
			   {
				   System.out.println("查询到的权限菜单:"+ac.getMau_name());
			   }
		   }  
	}
	
	@Test
	public void testUserAnalysis()
	{
		Map<String, Object> queryMonthRegisterCount=new HashMap<String, Object>();
		queryMonthRegisterCount.put("gamesCategorycreate_time", "2018");
		UserRegisterMonthJson test=adminOpservice.queryUserRegisterMonthJson(queryMonthRegisterCount);
	    System.out.println("统计信息"+test.toString());
	}
	
	@Test
	public void testAddGameType()
	{
		BigGameType newGameType=new BigGameType("LOL","最火的MOBA游戏",  ".....",1, 1);
		boolean flag=adminOpservice.addBigGameType(newGameType);
		System.out.println("Service是否添加成功:"+flag);
	}
	@Test
	public void testquerySmallInfo()
	{   
		Map<String, Object> test= new HashMap<String, Object>();
		List<String> teStrings=adminOpservice.querySmallGameInfo(test);
		System.out.println(teStrings.get(1));
	}
	@Test
	public void testduty()
	{
		 Map<String, Object> adminAll=new HashMap<String, Object>();
		 Page<Admin_duty> adminPage=new Page<Admin_duty>();
		 adminPage.setShowCount(1);
		 adminPage.setCurrentPage(1);
		 adminAll.put("page", adminPage);
		 adminPage=adminOpservice.queryAdminDutyList(adminAll);
		// List<Admin_duty> list=adminPage.getResult();
		 System.out.println("共:"+adminPage.getTotalResult()+"条数据");
		   System.out.println("共"+adminPage.getTotalPage()+"页");
		   System.out.println("用户信息条数:"+adminPage.getResult().size());
		   for(Admin_duty ad:adminPage.getResult())
		   {
			   System.out.println("查询到的信息:"+ad.getDuty_publish_info());
		   }  
		 
	}
}
