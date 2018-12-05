package com.game.ssm.entiy;

import java.io.Serializable;

public class Admin_Authority implements Serializable{
	private Integer au_id;
    private String au_name;
    private String au_i_id;
    private String au_href;
    private String au_i_class;
    
	public Admin_Authority() {
		super();
	}

	public Admin_Authority(Integer au_id, String au_name, String au_i_id, String au_href, String au_i_class) {
		super();
		this.au_id = au_id;
		this.au_name = au_name;
		this.au_i_id = au_i_id;
		this.au_href = au_href;
		this.au_i_class = au_i_class;
	}

	public Integer getAu_id() {
		return au_id;
	}

	public void setAu_id(Integer au_id) {
		this.au_id = au_id;
	}

	public String getAu_name() {
		return au_name;
	}

	public void setAu_name(String au_name) {
		this.au_name = au_name;
	}

	public String getAu_i_id() {
		return au_i_id;
	}

	public void setAu_i_id(String au_i_id) {
		this.au_i_id = au_i_id;
	}

	public String getAu_href() {
		return au_href;
	}

	public void setAu_href(String au_href) {
		this.au_href = au_href;
	}

	public String getAu_i_class() {
		return au_i_class;
	}

	public void setAu_i_class(String au_i_class) {
		this.au_i_class = au_i_class;
	}

	
}
