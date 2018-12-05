package com.game.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.game.ssm.dao.AdminOpDAO;
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
import com.game.ssm.service.AdminOpService;
import com.game.ssm.utils.Page;
import com.game.ssm.entiy.uploadArticleInfo;
@Service
public class AdminOpServiceImpl implements AdminOpService{
	@Autowired
    private AdminOpDAO adminOpDAO;
	public Admin getloginAdminInfo(Map<String, String> loginInfo) {
		// TODO Auto-generated method stub
		return adminOpDAO.LoginAdmin(loginInfo);
	}
	public boolean updateManagerInfo(Map<String, String> updateInfo) {
		// TODO Auto-generated method stub
		return adminOpDAO.ManagerInfoUpdate(updateInfo);
	}
	public List<Admin_Authority> getLoginAdminAuthority(String LoginId) {
		// TODO Auto-generated method stub
		return adminOpDAO.getLoginAdminAuthority(LoginId);
	}
	@SuppressWarnings("unchecked")
	public Page<Admin> queryAdminAllInfoList(Map<String, Object> adminInfo) {
		// TODO Auto-generated method stub
		Page<Admin> page=(Page<Admin>)adminInfo.get("page");
		List<Admin> adminAll=adminOpDAO.queryAdminAllInfoListPage(adminInfo);
		page.setResult(adminAll);
		return page;
	}
	public Page<Member> queryMemberAllInfoLits(Map<String, Object> memberInfo) {
		// TODO Auto-generated method stub
		Page<Member> page=(Page<Member>)memberInfo.get("page");
		List<Member> memberAll=adminOpDAO.queryMemberAllInfoListPage(memberInfo);
		page.setResult(memberAll);
		return page;
	}
	public UserRegisterMonthJson queryUserRegisterMonthJson(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return adminOpDAO.queryUserRegisterMonthAnalysis(info);
	}
	public UserGameArticleMonth queryUserArticleMonthJson(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return adminOpDAO.queryUserGameArticleMonth(info);
	}
	//事务
	@Transactional
	public boolean addBigGameType(BigGameType newType) {
		// TODO Auto-generated method stub
		return adminOpDAO.addBigGameType(newType);
	}
	public List<GameConfigure> getGameConfigure()
	{
		return adminOpDAO.getConfigureInfo();
	}
	public List<BigGameType> getBigGameInfo() {
		// TODO Auto-generated method stub
		return adminOpDAO.getBigGameInfo();
	}
	public int bigGameId(String name) {
		// TODO Auto-generated method stub
		return adminOpDAO.queryBigTypeIDByName(name);
	}
	@Transactional
	public boolean addSmallGameType(SmallGameType newGame) {
		// TODO Auto-generated method stub
		return adminOpDAO.addSmallGameType(newGame);
	}
	public List<String> querySmallGameInfo(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return adminOpDAO.queryGameSmallInfo(info);
	}
	public int querySmallGameIdByName(String name) {
		// TODO Auto-generated method stub
		return adminOpDAO.querySmallGameIdByName(name);
	}
	public boolean uploadArticleInfo(uploadArticleInfo article) {
		// TODO Auto-generated method stub
		return adminOpDAO.uploadGameArticleInfo(article);
	}
	public boolean addAdminDutyInfo(GameDuty gameDuty) {
		// TODO Auto-generated method stub
		return adminOpDAO.addAdminPublishDuty(gameDuty);
	}
	public Page<Admin_duty> queryAdminDutyList(Map<String, Object> Info) {
		// TODO Auto-generated method stub
		Page<Admin_duty> page=(Page<Admin_duty>)Info.get("page");
		List<Admin_duty> memberAll=adminOpDAO.getDutyInfoAllByTimeListPage(Info);
		page.setResult(memberAll);
		return page;
	}
	public Page<AdminInfoPlugin> queryAdminInfoList(Map<String, Object> Info) {
		// TODO Auto-generated method stub
		Page<AdminInfoPlugin> page=(Page<AdminInfoPlugin>)Info.get("page");
		List<AdminInfoPlugin> memberAll=adminOpDAO.queryAdminInfoListPage(Info);
		page.setResult(memberAll);
		return page;
	}
	public Page<UserInfoPlugin> queryUserInfoList(Map<String, Object> Info) {
		// TODO Auto-generated method stub
		Page<UserInfoPlugin> page=(Page<UserInfoPlugin>)Info.get("page");
		List<UserInfoPlugin> memberAll=adminOpDAO.queryUserInfoListPage(Info);
		page.setResult(memberAll);
		return page;
	}
}
