package com.fh.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class testRedis {


    @Test
    public void test1(){
        Jedis client = new Jedis("192.168.136.131");
        client.auth("123");
        client.set("hhh","哈哈");
        System.out.println(client.get("hhh"));

    }
}
