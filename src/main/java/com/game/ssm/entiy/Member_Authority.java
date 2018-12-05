package com.game.ssm.entiy;

import java.io.Serializable;

public class Member_Authority implements Serializable{
   
	private Integer Mau_id;
	private String Mau_name;
	private boolean Mau_authority;
	

	public Member_Authority() {
		super();
	}

	public Member_Authority(Integer mau_id, String mau_name, boolean mau_authority) {
		super();
		Mau_id = mau_id;
		Mau_name = mau_name;
		Mau_authority = mau_authority;
	}

	public Integer getMau_id() {
		return Mau_id;
	}

	public void setMau_id(Integer mau_id) {
		Mau_id = mau_id;
	}

	public String getMau_name() {
		return Mau_name;
	}

	public void setMau_name(String mau_name) {
		Mau_name = mau_name;
	}

	public boolean isMau_authority() {
		return Mau_authority;
	}

	public void setMau_authority(boolean mau_authority) {
		Mau_authority = mau_authority;
	}
		
}
