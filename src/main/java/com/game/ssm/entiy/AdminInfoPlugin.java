package com.game.ssm.entiy;

import java.io.Serializable;

public class AdminInfoPlugin  implements Serializable{
	
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
    private String au_id;
    private String au_name;
    
    
	public AdminInfoPlugin() {
		super();
	}


	public AdminInfoPlugin(Integer admin_id, String admin_name, String admin_nick_name, String admin_email,
			String admin_password, String admin_gender, String admin_address, String admin_telphone,
			Integer admin_authority, Integer admin_status, String au_id, String au_name) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_nick_name = admin_nick_name;
		this.admin_email = admin_email;
		this.admin_password = admin_password;
		this.admin_gender = admin_gender;
		this.admin_address = admin_address;
		this.admin_telphone = admin_telphone;
		this.admin_authority = admin_authority;
		this.admin_status = admin_status;
		this.au_id = au_id;
		this.au_name = au_name;
	}


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


	public String getAu_id() {
		return au_id;
	}


	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}


	public String getAu_name() {
		return au_name;
	}


	public void setAu_name(String au_name) {
		this.au_name = au_name;
	}
    
    
    
}
