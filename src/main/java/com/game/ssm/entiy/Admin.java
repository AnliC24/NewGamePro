package com.game.ssm.entiy;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable{

	   private Integer admin_id;
       private String admin_name;
       private String admin_nick_name;
       private String admin_email;
       private String admin_password;
       private String admin_gender;
       private String admin_address;
       private String admin_telphone;
       private Integer admin_authority;
       private Integer admin_status;
       private List<Admin_Authority> authority;
       
	
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_nick_name() {
		return admin_nick_name;
	}
	public void setAdmin_nick_name(String admin_nick_name) {
		this.admin_nick_name = admin_nick_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_gender() {
		return admin_gender;
	}
	public void setAdmin_gender(String admin_gender) {
		this.admin_gender = admin_gender;
	}
	public String getAdmin_address() {
		return admin_address;
	}
	public void setAdmin_address(String admin_address) {
		this.admin_address = admin_address;
	}
	public String getAdmin_telphone() {
		return admin_telphone;
	}
	public void setAdmin_telphone(String admin_telphone) {
		this.admin_telphone = admin_telphone;
	}
	public Integer getAdmin_authority() {
		return admin_authority;
	}
	public void setAdmin_authority(Integer admin_authority) {
		this.admin_authority = admin_authority;
	}
	public Integer getAdmin_status() {
		return admin_status;
	}
	public void setAdmin_status(Integer admin_status) {
		this.admin_status = admin_status;
	}
	public List<Admin_Authority> getAuthority() {
		return authority;
	}
	public void setAuthority(List<Admin_Authority> authority) {
		this.authority = authority;
	}
   
}
