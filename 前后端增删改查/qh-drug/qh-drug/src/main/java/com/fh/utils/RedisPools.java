package com.fh.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPools {
        private static JedisPool jedisPool;
        private RedisPools(){

        }
        //静态块的代码只能执行一次
    static {
            //创建连接池之前，设置连接池信息
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            //最大连接数
            poolConfig.setMaxTotal(100);
            //最大空闲链接数
            poolConfig.setMaxIdle(10);
            //最小空闲链接数
            poolConfig.setMinIdle(5);
            //创建连接池对象
            jedisPool = new JedisPool(poolConfig,"192.168.136.131",6379);
        }

        public  static Jedis getJedis(){
            //从连接池拿出一个
            Jedis resource = jedisPool.getResource();
            resource.auth("123");
            return resource;
        }


        public static void returnjedis(Jedis jedis){
            //将redis 还回连接池中
            if(jedis!=null){
                jedis.close();
            }
        }

}
