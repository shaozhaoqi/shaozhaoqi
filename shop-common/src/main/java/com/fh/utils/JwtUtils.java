package com.fh.utils;

import com.alibaba.fastjson.JSON;
import com.fh.common.ResponseEnum;
import com.fh.common.ServerResponse;
import io.jsonwebtoken.*;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    public static  String createToken(Map<String,Object> map){
        //jwt如何生成字符串
        //声明头部信息
        Map<String,Object> headerMap=new HashMap<String,Object>();
        headerMap.put("alg","HS256");
        headerMap.put("typ","JWT");
        //设置负载:不要放着涉密的东西比如:银行账号密码，余额，身份证号
        Map<String,Object> payload=new HashMap<String,Object>();
        payload.putAll(map);
        Long iat=System.currentTimeMillis();
        //设置jwt的失效时间
        payload.put("exp",iat+1800000l);
        payload.put("iat",iat);

        //签名值就是我们的安全密钥
        String token=Jwts.builder()
                .setHeader(headerMap)
                .setPayload(JSON.toJSONString(payload))
                .signWith(SignatureAlgorithm.HS256,getSecretKey("aa"))
                .compact();
        return token;
    }

    public static ServerResponse resolverToken(String token ){
        Claims claims=null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(getSecretKey("aa"))
                    .parseClaimsJws(token)
                    .getBody();

        }catch (ExpiredJwtException exp){
            System.out.println("token超时，token失效了");
            return ServerResponse.error(ResponseEnum.TOKEN_TIMEOUT);
        }catch (SignatureException sing){
            System.out.println("token解析失败");
            return ServerResponse.error(ResponseEnum.SAFETY_ERROR);
        }
        return ServerResponse.success(claims);
    }
    private  static String getSecretKey(String key){
        return new BASE64Encoder().encode(key.getBytes());
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("phone","123");
        String token = JwtUtils.createToken(map);
        System.out.println(token);
        ServerResponse serverResponse = resolverToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzQ4MTYwNzA0MTcsImlhdCI6MTU3NDgxNjAxMDQxNywicGhvbmUiOiIxMjMifQ.KFeBuS7nLPXSOMPMgyblx4qO_ZzqZNaeU0ZlnMYg-6c");
        System.out.println(serverResponse.getCode());
    }


}
