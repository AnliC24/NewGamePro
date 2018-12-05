package com.game.ssm.junit4;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {
    @Test
    public void testRedis(){
    	Jedis jedis=new Jedis("127.0.0.1",6379);
    	System.out.println("redis连接地址:"+jedis);
    	System.out.println("key=hello,value="+jedis.get("hello"));
    	System.out.println("查看服务是否运行:"+jedis.ping());
    }
    @Test
    public void testRedisPool()
    {
    }
    
}
