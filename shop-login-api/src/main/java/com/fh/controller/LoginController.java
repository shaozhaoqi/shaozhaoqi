package com.fh.controller;

import com.alibaba.fastjson.JSONObject;
import com.fh.biz.ILoginService;
import com.fh.common.ResponseEnum;
import com.fh.common.ServerResponse;
import com.fh.po.User;
import com.fh.utils.JwtUtils;
import com.fh.utils.MobileMessageSend;
import com.fh.utils.SystemConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("login")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class LoginController {

    @Resource(name="loginService")
    private ILoginService loginService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @GetMapping("/{phone}")
    public ServerResponse login(@PathVariable String phone){
        //先判断一下
        if (StringUtils.isBlank(phone)) {
            return ServerResponse.error(ResponseEnum.PHONE_ISNULL);
        }
        //先发送验证码
        String jsonObject = null;
        try {
            jsonObject = MobileMessageSend.sendMsg(phone);
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* String code = jsonObject.getString("code");
        if (code.equals("200")) {
            String checkCode = jsonObject.getString("obj");
            redisTemplate.opsForValue().set(SystemConstant.REDIS_CODE + phone, checkCode, 300, TimeUnit.SECONDS);
        }*/
       redisTemplate.opsForValue().set(SystemConstant.REDIS_CODE + phone, jsonObject, 300, TimeUnit.SECONDS);


        return ServerResponse.success();
    }
    @PostMapping
    public ServerResponse login(String phone,String code){
       //判断手机号和验证码是否为空
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(code)){
            return ServerResponse.error(ResponseEnum.CODE_PHONE_NULL);
        }
        //判断验证码是否正确
        String redisCode = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CODE + phone);
        if (!code.equals(redisCode)){
            return ServerResponse.error(ResponseEnum.CODE_ERROR);
        }
        //登录成功删除redis里面的验证码
        redisTemplate.delete(SystemConstant.REDIS_CODE + phone);
        //判断手机号是否注册，没有直接注册
        User user =  loginService.isRegist(phone);
        //根据用户手机号把用户信息存入redis
        redisTemplate.opsForValue().set(SystemConstant.REDIS_USER + phone, user);
        //把购物车id 放入redis
        redisTemplate.opsForValue().set(SystemConstant.REDIS_CARTSID + phone, user.getCartsId());
        //生成token 返回前台
        Map<String,Object> map = new HashMap<>();
        map.put(SystemConstant.REDIS_PHONE,user.getPhone());
        String token = JwtUtils.createToken(map);
        return ServerResponse.success(token);
    }
}
