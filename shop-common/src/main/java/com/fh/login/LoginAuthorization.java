package com.fh.login;

import com.fh.common.ResponseEnum;
import com.fh.common.ServerResponse;
import com.fh.exception.AuthenticateException;
import com.fh.utils.JwtUtils;
import com.fh.utils.SystemConstant;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
@Order(5)
public class LoginAuthorization {
    @Around(value="execution(* com.fh.controller.*.*(..)) && @annotation(loginAnnotation)")
    public Object loginAround(ProceedingJoinPoint joinPoint,LoginAnnotation loginAnnotation){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //从浏览器头部获取token
        String token =request.getHeader("token");
        //System.out.println(token);
        //判断token是否为空
        if(StringUtils.isBlank(token)){
            //自定义异常
            throw new AuthenticateException(ResponseEnum.TOKEN_TIMEOUT);
        }
        //解析token
        ServerResponse responseServer = JwtUtils.resolverToken(token);
        //解析失败
        if(responseServer.getCode() != 200){
            throw new AuthenticateException(ResponseEnum.TOKEN_TIMEOUT);
        }
        //解析成功 获取 token里面的参数
        Claims claims= (Claims) responseServer.getData();
        //获取token参数里面的手机号
        String phone= (String) claims.get(SystemConstant.REDIS_PHONE);
        //将手机号存入request当前请求
        request.setAttribute(SystemConstant.REDIS_PHONE,phone);
        Object obj=null;
        try {
            obj=joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
