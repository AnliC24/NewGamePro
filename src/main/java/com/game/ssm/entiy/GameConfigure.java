package com.game.ssm.entiy;

import java.io.Serializable;

public class GameConfigure implements Serializable{
     private int games_configure_id;
     private String games_cpu;
     private String games_memory;
     private String games_disk;
     private String games_graphics;
     private String games_operating_system;
     private String games_driver;
     
   
	public GameConfigure() {
		super();
	}
	public GameConfigure(int games_configure_id, String games_cpu, String games_memory, String games_disk,
			String games_graphics, String games_operating_system, String games_driver) {
		super();
		this.games_configure_id = games_configure_id;
		this.games_cpu = games_cpu;
		this.games_memory = games_memory;
		this.games_disk = games_disk;
		this.games_graphics = games_graphics;
		this.games_operating_system = games_operating_system;
		this.games_driver = games_driver;
	}
	public int getGames_configure_id() {
		return games_configure_id;
	}
	public void setGames_configure_id(int games_configure_id) {
		this.games_configure_id = games_configure_id;
	}
	public String getGames_cpu() {
		return games_cpu;
	}
	public void setGames_cpu(String games_cpu) {
		this.games_cpu = games_cpu;
	}
	public String getGames_memory() {
		return games_memory;
	}
	public void setGames_memory(String games_memory) {
		this.games_memory = games_memory;
	}
	public String getGames_disk() {
		return games_disk;
	}
	public void setGames_disk(String games_disk) {
		this.games_disk = games_disk;
	}
	public String getGames_graphics() {
		return games_graphics;
	}
	public void setGames_graphics(String games_graphics) {
		this.games_graphics = games_graphics;
	}
	public String getGames_operating_system() {
		return games_operating_system;
	}
	public void setGames_operating_system(String games_operating_system) {
		this.games_operating_system = games_operating_system;
	}
	public String getGames_driver() {
		return games_driver;
	}
	public void setGames_driver(String games_driver) {
		this.games_driver = games_driver;
	}
     
     
}
