<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../Base/baseHeader.jsp" %>
<title>峰线游戏资讯平台</title>

<style type="text/css">
	ul li{font-size: 30px;color:#2ec0f6;}
	.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
	.tyg-p{
		font-size: 14px;
	    font-family: 'microsoft yahei';
	    position: absolute;
	    top: 135px;
	    left: 60px;
	}
	.tyg-div-denglv{
		z-index:1000;float:right;position:absolute;right:3%;top:10%;
	}
	.tyg-div-form{
		background-color: #23305a;
		width:300px;
		height:auto;
		margin:120px auto 0 auto;
		color:#2ec0f6;
	}
	.tyg-div-form form {padding:10px;}
	.tyg-div-form form input[type="text"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	.tyg-div-form form button {
	    cursor: pointer;
	    width: 270px;
	    height: 44px;
	    margin-top: 25px;
	    padding: 0;
	    background: #2ec0f6;
	    -moz-border-radius: 6px;
	    -webkit-border-radius: 6px;
	    border-radius: 6px;
	    border: 1px solid #2ec0f6;
	    -moz-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    -webkit-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	    font-size: 14px;
	    font-weight: 700;
	    color: #fff;
	    text-shadow: 0 1px 2px rgba(0,0,0,.1);
	    -o-transition: all .2s;
	    -moz-transition: all .2s;
	    -webkit-transition: all .2s;
	    -ms-transition: all .2s;
}
</style>
<body>
<div class="tyg-div">
	<ul>
    	<li>让</li>
    	<li><div style="margin-left:20px;">游</div></li>
    	<li><div style="margin-left:40px;">戏</div></li>
    	<li><div style="margin-left:60px;">变</div></li>
    	<li><div style="margin-left:80px;">的</div></li>
    	<li><div style="margin-left:100px;">更</div></li>
    	<li><div style="margin-left:120px;">简</div></li>
    	<li><div style="margin-left:120px;">单</div></li>
    </ul>
</div> 
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0">峰线游戏资讯平台</div>
		<div class="title1">单机,网游,3A大作</div>
		<div class="imgGroug">
			<ul>
				<img alt="" class="img0 png" src="Game/ftl/ServerP/img/page1_0.png">
				<img alt="" class="img1 png" src="Game/ftl/ServerP/img/page1_1.png">
				<img alt="" class="img2 png" src="Game/ftl/ServerP/img/page1_2.png">
			</ul>
		</div>
		<img alt="" class="img3 png" src="Game/ftl/ServerP/img/page1_3.jpg">
	</div>
</div>
<div class="tyg-div-denglv">
	<div class="tyg-div-form">
		<form action="user.do" method=get>
			<h2>登录</h2><p class="tyg-p">欢迎访问  游讯平台</p>
			<div style="margin:5px 0px;">
				<input type="text" placeholder="请输入账号..." name="admin_email"/>
			</div>
			<div style="margin:5px 0px;">
				<input type="password" placeholder="请输入密码..." name="admin_password"/>
			</div>
			<div style="margin:5px 0px;">
				<input type="text" style="width:150px;" placeholder="请输入验证码..."/>
				<img src="Game/ftl/ServerP/img/1.png" style="vertical-align:bottom;" alt="验证码"/>
			</div>
			<button type="submit" >登<span style="width:20px;"></span>录</button>
		</form>
	</div>
</div>

More Templates <a href="http://www.cssmoban.com/" target="_blank" title="峰线">峰线游讯</a> - Collect from <a href="http://www.cssmoban.com/" title="游讯" target="_blank">游讯平台</a>


<%@ include file="../Base/baseFooter.jsp" %>