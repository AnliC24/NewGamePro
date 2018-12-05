package com.game.ssm.entiy;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class uploadArticleInfo implements Serializable{
   private int game_travel_article_id;
   private int gamesType_id;
   private String game_travel_article_name;
   private String game_travel_article_info;
   private String game_travel_article_author;
   private int upload_admin_id;
   private Timestamp upload_time;
   
   
public uploadArticleInfo() {
	super();
}


public uploadArticleInfo(int game_travel_article_id, int gamesType_id, String game_travel_article_name,
		String game_travel_article_info, String game_travel_article_author, int upload_admin_id,
		Timestamp upload_time) {
	super();
	this.game_travel_article_id = game_travel_article_id;
	this.gamesType_id = gamesType_id;
	this.game_travel_article_name = game_travel_article_name;
	this.game_travel_article_info = game_travel_article_info;
	this.game_travel_article_author = game_travel_article_author;
	this.upload_admin_id = upload_admin_id;
	this.upload_time = upload_time;
}


public uploadArticleInfo(int gamesType_id, String game_travel_article_name, String game_travel_article_info,
		String game_travel_article_author, int upload_admin_id, Timestamp upload_time) {
	super();
	this.gamesType_id = gamesType_id;
	this.game_travel_article_name = game_travel_article_name;
	this.game_travel_article_info = game_travel_article_info;
	this.game_travel_article_author = game_travel_article_author;
	this.upload_admin_id = upload_admin_id;
	this.upload_time = upload_time;
}


public int getGame_travel_article_id() {
	return game_travel_article_id;
}


public void setGame_travel_article_id(int game_travel_article_id) {
	this.game_travel_article_id = game_travel_article_id;
}


public int getGamesType_id() {
	return gamesType_id;
}


public void setGamesType_id(int gamesType_id) {
	this.gamesType_id = gamesType_id;
}


public String getGame_travel_article_name() {
	return game_travel_article_name;
}


public void setGame_travel_article_name(String game_travel_article_name) {
	this.game_travel_article_name = game_travel_article_name;
}


public String getGame_travel_article_info() {
	return game_travel_article_info;
}


public void setGame_travel_article_info(String game_travel_article_info) {
	this.game_travel_article_info = game_travel_article_info;
}


public String getGame_travel_article_author() {
	return game_travel_article_author;
}


public void setGame_travel_article_author(String game_travel_article_author) {
	this.game_travel_article_author = game_travel_article_author;
}


public int getUpload_admin_id() {
	return upload_admin_id;
}


public void setUpload_admin_id(int upload_admin_id) {
	this.upload_admin_id = upload_admin_id;
}


public Timestamp getUpload_time() {
	return upload_time;
}


public void setUpload_time(Timestamp upload_time) {
	this.upload_time = upload_time;
}





}
