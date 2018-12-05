package com.game.ssm.interceptor;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{
	protected  Logger logger=LogManager.getLogger(this.getClass());
	
}
