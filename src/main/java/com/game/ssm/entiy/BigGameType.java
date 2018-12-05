package com.game.ssm.entiy;

import java.io.Serializable;

public class BigGameType implements Serializable{
	
   private String games_name;
   private String  games_describe;
   private String games_images;
   private int games_upload_admin_id;
   private int games_configure_id;
   
public BigGameType() {
	super();
}

public String getGames_name() {
	return games_name;
}

public void setGames_name(String games_name) {
	this.games_name = games_name;
}

public String getGames_describe() {
	return games_describe;
}

public void setGames_describe(String games_describe) {
	this.games_describe = games_describe;
}

public String getGames_images() {
	return games_images;
}

public void setGames_images(String games_images) {
	this.games_images = games_images;
}

public int getGames_upload_admin_id() {
	return games_upload_admin_id;
}

public void setGames_upload_admin_id(int games_upload_admin_id) {
	this.games_upload_admin_id = games_upload_admin_id;
}

public int getGames_configure_id() {
	return games_configure_id;
}

public void setGames_configure_id(int games_configure_id) {
	this.games_configure_id = games_configure_id;
}

public BigGameType(String games_name, String games_describe, String games_images, int games_upload_admin_id,
		int games_configure_id) {
	super();
	this.games_name = games_name;
	this.games_describe = games_describe;
	this.games_images = games_images;
	this.games_upload_admin_id = games_upload_admin_id;
	this.games_configure_id = games_configure_id;
}

}
