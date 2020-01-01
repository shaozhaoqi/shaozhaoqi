package com.fh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.fh.common.ConstantData;
import com.fh.dao.AreaDao;
import com.fh.bean.AreaBean;
import com.fh.service.AreaService;
import com.fh.util.RedisPools;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaDao areaDao;

    public List<AreaBean> queryAreaRedis() {
        List <AreaBean> area = new ArrayList<AreaBean>();
        Jedis jedis = RedisPools.getJedis();
        String areaString = jedis.get(ConstantData.areaKey);
        if(areaString != null &&!areaString.equals("")){
            area = JSONArray.parseArray(areaString).toJavaList(AreaBean.class);
            System.out.println("redis---------------------------------");
        }else {
            area =areaDao.selectList(null);
            jedis.set(ConstantData.areaKey,JSONArray.toJSONString(area));
            System.out.println("mysql-----------------------------------");

        }
        RedisPools.returnjedis(jedis);
        return area;

    }
}
