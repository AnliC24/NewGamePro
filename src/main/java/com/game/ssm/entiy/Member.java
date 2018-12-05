package com.game.ssm.entiy;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Member implements Serializable{
    
	private Integer member_id;
	private Integer gamesCategoryadmin_id;
	private String  member_name;
	private String  member_nick_name;
	private String  member_gender;
	private String  member_register_telphone;
	private String  member_register_email;
	private Timestamp gamesCategorycreate_time;
	private Integer member_authority;
	private Integer member_status;
    private List<Member_Authority>  memberMenus;
   

	public Integer getMember_id() {
		return member_id;
	}




	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}


	public Integer getGamesCategoryadmin_id() {
		return gamesCategoryadmin_id;
	}




	public void setGamesCategoryadmin_id(Integer gamesCategoryadmin_id) {
		this.gamesCategoryadmin_id = gamesCategoryadmin_id;
	}




	public String getMember_name() {
		return member_name;
	}




	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}




	public String getMember_nick_name() {
		return member_nick_name;
	}




	public void setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
	}




	public String getMember_gender() {
		return member_gender;
	}




	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}




	public String getMember_register_telphone() {
		return member_register_telphone;
	}




	public void setMember_register_telphone(String member_register_telphone) {
		this.member_register_telphone = member_register_telphone;
	}




	public String getMember_register_email() {
		return member_register_email;
	}




	public void setMember_register_email(String member_register_email) {
		this.member_register_email = member_register_email;
	}




	public Timestamp getGamesCategorycreate_time() {
		return gamesCategorycreate_time;
	}




	public void setGamesCategorycreate_time(Timestamp gamesCategorycreate_time) {
		this.gamesCategorycreate_time = gamesCategorycreate_time;
	}




	public Integer getMember_authority() {
		return member_authority;
	}




	public void setMember_authority(Integer member_authority) {
		this.member_authority = member_authority;
	}




	public Integer getMember_status() {
		return member_status;
	}




	public void setMember_status(Integer member_status) {
		this.member_status = member_status;
	}




	public List<Member_Authority> getMemberMenus() {
		return memberMenus;
	}




	public void setMemberMenus(List<Member_Authority> memberMenus) {
		this.memberMenus = memberMenus;
	}
    
	
	
	
	
}
