package com.game.ssm.service;

import java.util.List;
import java.util.Map;

import com.game.ssm.entiy.Admin;
import com.game.ssm.entiy.AdminInfoPlugin;
import com.game.ssm.entiy.Admin_Authority;
import com.game.ssm.entiy.Admin_duty;
import com.game.ssm.entiy.BigGameType;
import com.game.ssm.entiy.GameConfigure;
import com.game.ssm.entiy.GameDuty;
import com.game.ssm.entiy.Member;
import com.game.ssm.entiy.SmallGameType;
import com.game.ssm.entiy.UserGameArticleMonth;
import com.game.ssm.entiy.UserInfoPlugin;
import com.game.ssm.entiy.UserRegisterMonthJson;
import com.game.ssm.entiy.uploadArticleInfo;
import com.game.ssm.utils.Page;

public interface AdminOpService {
    //获取登录管理员的信息
	public Admin getloginAdminInfo(Map<String, String> loginInfo);
	//管理员菜单权限管理
	public List<Admin_Authority> getLoginAdminAuthority(String LoginId);
	//管理员信息的修改
	public boolean updateManagerInfo(Map<String, String> updateInfo);
	//获取所有Admin的信息，并分页--Mybatis Plugins
	public Page<Admin>  queryAdminAllInfoList(Map<String, Object> adminInfo);
	//获取所有Member的信息,并分页--Mybatis Plugins
	public Page<Member> queryMemberAllInfoLits(Map<String, Object> memberInfo);
	//获取月注册用户数量
	public UserRegisterMonthJson queryUserRegisterMonthJson(Map<String, Object> info);
	//获取月上传文章统计数量
	public UserGameArticleMonth queryUserArticleMonthJson(Map<String, Object> info);
	
	//新增游戏种类
	public boolean addBigGameType(BigGameType newType);
	
	//搜索游戏配置
	public List<GameConfigure> getGameConfigure();
	
	//搜索游戏大类信息
	public List<BigGameType> getBigGameInfo();
	
	//搜索大类的name根据其id
	public int bigGameId(String name);
	
	//添加小类信息
	public boolean addSmallGameType(SmallGameType newGame);
	
	//获取游戏小类的名称信息
	public List<String> querySmallGameInfo(Map<String, Object> info);
	
	//根据游戏小类的name获取id
	public int querySmallGameIdByName(String name);
	
	//上传游讯文章信息
	public boolean uploadArticleInfo(uploadArticleInfo article);
	
	//保存发布任务
	public boolean addAdminDutyInfo(GameDuty gameDuty);
	
	//获取最新任务信息,并分页--Mybatis Plugins
	public Page<Admin_duty> queryAdminDutyList(Map<String, Object> Info);
	
	
	//获取管理管信息并分页 -- adminInfo新实体
	public Page<AdminInfoPlugin> queryAdminInfoList(Map<String, Object> Info);
	
	//获取用户信息并分页 -- userInfo新实体
	public Page<UserInfoPlugin> queryUserInfoList(Map<String, Object> Info);
    
}
