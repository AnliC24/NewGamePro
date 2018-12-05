package com.game.ssm.entiy;

import java.io.Serializable;

public class SmallGameType implements Serializable{
    private int gamesType_id;
    private int games_category_id;
    private String gamesType_name;
    private String gamesType_images;
    private String gamesType_describe;
	public SmallGameType() {
		super();
	}
	
	public SmallGameType(int games_category_id, String gamesType_name, String gamesType_images,
			String gamesType_describe) {
		super();
		this.games_category_id = games_category_id;
		this.gamesType_name = gamesType_name;
		this.gamesType_images = gamesType_images;
		this.gamesType_describe = gamesType_describe;
	}

	public SmallGameType(int gamesType_id, int games_category_id, String gamesType_name, String gamesType_images,
			String gamesType_describe) {
		super();
		this.gamesType_id = gamesType_id;
		this.games_category_id = games_category_id;
		this.gamesType_name = gamesType_name;
		this.gamesType_images = gamesType_images;
		this.gamesType_describe = gamesType_describe;
	}
	public int getGamesType_id() {
		return gamesType_id;
	}
	public void setGamesType_id(int gamesType_id) {
		this.gamesType_id = gamesType_id;
	}
	public int getGames_category_id() {
		return games_category_id;
	}
	public void setGames_category_id(int games_category_id) {
		this.games_category_id = games_category_id;
	}
	public String getGamesType_name() {
		return gamesType_name;
	}
	public void setGamesType_name(String gamesType_name) {
		this.gamesType_name = gamesType_name;
	}
	public String getGamesType_images() {
		return gamesType_images;
	}
	public void setGamesType_images(String gamesType_images) {
		this.gamesType_images = gamesType_images;
	}
	public String getGamesType_describe() {
		return gamesType_describe;
	}
	public void setGamesType_describe(String gamesType_describe) {
		this.gamesType_describe = gamesType_describe;
	}
    
    
}
