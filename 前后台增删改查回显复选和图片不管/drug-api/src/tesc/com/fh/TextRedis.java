package com.fh;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TextRedis {

    @Test
    public void  aaa(){
        Jedis jedis = new Jedis("192.168.32.131",6379);
        jedis.set("feihu","飞狐");
        System.out.print(jedis.get("feihu"));
    }

}
