package com.fh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.fh.common.ConstantData;
import com.fh.dao.BrandDao;
import com.fh.entity.po.BrandInfo;
import com.fh.service.BrandService;
import com.fh.utils.RedisPools;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;

    @Override
    public List<BrandInfo> queryBrandList() {
        List<BrandInfo> brands = new ArrayList<>();
        //先查redis  如果redis有在redis中取 没有在数据库取 再放回redis中
        Jedis jedis = RedisPools.getJedis();
        //redis 存的是String数据类型
        String brandString = jedis.get(ConstantData.brandKey);
        if(brandString!=null&& !brandString.equals("")){
            //将jsonArray 字符串转为list
            brands=JSONArray.parseArray(brandString,BrandInfo.class);
            System.out.println("redis============");
        }else {
            //查数据库
            brands = brandDao.queryBrandList();
            //存redis
            jedis.set(ConstantData.brandKey,JSONArray.toJSONString(brands));
            System.out.println("mySql================");
        }
        RedisPools.returnjedis(jedis);
        return brands;
    }
}
