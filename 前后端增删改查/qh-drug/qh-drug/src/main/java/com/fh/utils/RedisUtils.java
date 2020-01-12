package com.fh.utils;

import redis.clients.jedis.Jedis;

public class RedisUtils {
    public static void set (String key,String value){
        Jedis jedis = RedisPools.getJedis();
        jedis.set(key,value);
        RedisPools.returnjedis(jedis);
    }
}
