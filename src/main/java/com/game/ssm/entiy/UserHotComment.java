package com.game.ssm.entiy;

import java.io.Serializable;

public class UserHotComment implements Serializable{
   private Integer hotId;//热评文章的id
   private Integer game_id;//游戏种类id
   private String name;//游戏名称
   private Integer count;//热评文章的评论总条数
   
   
public Integer getHotId() {
	return hotId;
}
public void setHotId(Integer hotId) {
	this.hotId = hotId;
}
public Integer getGame_id() {
	return game_id;
}
public void setGame_id(Integer game_id) {
	this.game_id = game_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
   
   
   
   
   
}
