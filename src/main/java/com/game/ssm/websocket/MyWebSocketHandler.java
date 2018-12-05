package com.game.ssm.websocket;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.game.ssm.entiy.Admin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MyWebSocketHandler implements WebSocketHandler{

	protected  Logger logger=LogManager.getLogger(this.getClass());
	//保存所有用户的session
    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();
    
    //连接关闭后
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.info("websocket 连接关闭了.......");
        
        users.remove(session);
	}
     
	//连接就绪时
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub		
		users.add(session);
		logger.info("webSocket建立连接............");
		Admin loginAdmin=(Admin)session.getAttributes().get("LoginAdmin");
		if(loginAdmin!=null)
		{
			logger.info("当前登录的管理员:"+loginAdmin.getAdmin_name());
		}
		logger.info("当前登录的管理员人数:"+users.size());	
	}

	//处理信息
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
        Gson gson = new Gson();
        Admin loginAdmin=(Admin)session.getAttributes().get("LoginAdmin");
        // 将消息JSON格式通过Gson转换成Map
        // message.getPayload().toString() 获取消息具体内容
        Map<String, Object> msg = gson.fromJson(message.getPayload().toString(), 
                new TypeToken<Map<String, Object>>() {}.getType());
        logger.info("处理的消息为......."+message.getPayload()+"..........."+msg);
        TextMessage textMessage = new TextMessage(loginAdmin.getAdmin_name()+":"+msg.get("msgContent").toString(), true);
//      session.sendMessage(message);
        // 处理消息 msgContent消息内容
        //TextMessage textMessage = new TextMessage(msg.get("msgContent").toString(), true);
        // 调用方法（发送消息给所有人）
        sendMsgToAllUsers(textMessage);   
	}
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}	 
    // 给所有用户发送 信息
    public void sendMsgToAllUsers(WebSocketMessage<?> message) throws Exception{
        for (WebSocketSession user : users) {
            user.sendMessage(message);
        }
    }
  
}
