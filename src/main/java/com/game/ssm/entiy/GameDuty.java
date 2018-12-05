package com.game.ssm.entiy;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class GameDuty implements Serializable{
   private int admin_duty_id;
   private int admin_authority;
   private String duty_publish_grade;
   private Timestamp duty_publish_time;
   private String duty_publish_info;
   private boolean duty_publish_state;
   
     
public GameDuty() {
	super();
}



public boolean isDuty_publish_state() {
	return duty_publish_state;
}



public void setDuty_publish_state(boolean duty_publish_state) {
	this.duty_publish_state = duty_publish_state;
}


public GameDuty(int admin_authority, String duty_publish_grade, Timestamp duty_publish_time, String duty_publish_info,
		boolean duty_publish_state) {
	super();
	this.admin_authority = admin_authority;
	this.duty_publish_grade = duty_publish_grade;
	this.duty_publish_time = duty_publish_time;
	this.duty_publish_info = duty_publish_info;
	this.duty_publish_state = duty_publish_state;
}





public int getAdmin_duty_id() {
	return admin_duty_id;
}
public void setAdmin_duty_id(int admin_duty_id) {
	this.admin_duty_id = admin_duty_id;
}
public int getAdmin_authority() {
	return admin_authority;
}
public void setAdmin_authority(int admin_authority) {
	this.admin_authority = admin_authority;
}
public String getDuty_publish_grade() {
	return duty_publish_grade;
}
public void setDuty_publish_grade(String duty_publish_grade) {
	this.duty_publish_grade = duty_publish_grade;
}

public String getDuty_publish_info() {
	return duty_publish_info;
}
public void setDuty_publish_info(String duty_publish_info) {
	this.duty_publish_info = duty_publish_info;
}





public Timestamp getDuty_publish_time() {
	return duty_publish_time;
}





public void setDuty_publish_time(Timestamp duty_publish_time) {
	this.duty_publish_time = duty_publish_time;
}
   
   
}
