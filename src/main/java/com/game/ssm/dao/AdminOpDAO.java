package com.game.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

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

public interface AdminOpDAO {
    //Admin操作
	
	/**
	 * 管理员登录
	 * */
	public Admin LoginAdmin(Map<String, String> loginInfo);
	
	/**
	 * 更新管理员信息
	 * */
	public boolean ManagerInfoUpdate(Map<String, String> updateInfo);
	
	/**
	 * 获取管理员菜单管理权限
	 * */
	public List<Admin_Authority> getLoginAdminAuthority(String loginId);
	
	/**
	 * 获取所有Admin的信息,并分页
	 * */
	public List<Admin> queryAdminAllInfoListPage(Map<String, Object> adminInfo);
	
	/**
	 * 获取所有ComUser的信息,并分页
	 * */
	public List<Member> queryMemberAllInfoListPage(Map<String, Object> memberInfo);
	
	/**
	 * 用户注册月统计表
	 * */
	public UserRegisterMonthJson queryUserRegisterMonthAnalysis(Map<String, Object> info);
	
	/**
	 * 游讯文章上传月统计表
	 * */
	public UserGameArticleMonth queryUserGameArticleMonth(Map<String, Object> info);
	
	/**
	 * 用户热评统计表
	 * 搜索所有评论信息,并根据游戏种类进行分类，查到最多评论的热评文章name
	 * */ 

	/**
	 * 新增游戏种类
	 * */
    public boolean addBigGameType(BigGameType newType);
    
    /**
     * 获取游戏大类名称
     * */
    public List<BigGameType> getBigGameInfo();
    
    /**
     * 获取游戏配置的信息
     * */
    public List<GameConfigure> getConfigureInfo();
    
    /**
     * 根据大类名称获取其id值
     * */
    public int queryBigTypeIDByName(String name);
    
    /**
     * 添加游戏小类信息
     * */
    public boolean addSmallGameType(SmallGameType newGame);
    
    /**
     * 获取游戏小类的名称
     * */
    public List<String> queryGameSmallInfo(Map<String, Object> info);
    
    /**
     * 上传游讯文章信息
     * */
    public boolean uploadGameArticleInfo(uploadArticleInfo uploadArticleInfo);
    
    /**
     * 根据游戏小类的名称查询游戏id
     * */
    public int querySmallGameIdByName(String name);
    
    /**
     * 保存管理员发布的游讯任务
     * */
    public boolean addAdminPublishDuty(GameDuty duty);
    
    
    /**
     * 搜索管理员的最新任务信息
     * */
    public List<Admin_duty> getDutyInfoAllByTimeListPage(Map<String, Object> Info);
 
    /**
     * 搜索管理员信息-并分页，新设计
     * */
    public List<AdminInfoPlugin> queryAdminInfoListPage(Map<String, Object> adminInfo);
    
    /**
     * 搜索用户信息-并分页，新设计
     * */
    public List<UserInfoPlugin> queryUserInfoListPage(Map<String, Object> UserInfo);
    
}
