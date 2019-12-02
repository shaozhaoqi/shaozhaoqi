package com.fh.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 短信工具类
 * Created by LV on 2016/4/15 0015.
 * Email:LvLoveYuForever@gmail.com
 */
public class MobileMessageSend {
    /*通知类短信，请求的URL（https://api.netease.im/sms/sendtemplate.action ）
    运营类短信，请求的URL（https://api.netease.im/sms/sendtemplate.action ）
    验证码短信，请求的URL（https://api.netease.im/sms/sendcode.action ）*/
    private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";//发送验证码的请求路径URL
    private static final String APP_KEY="537ec2a45af51dc45bc7336bc8726dc6";//网易云信分配的账号
    private static final String APP_SECRET="903f4cc89996";//网易云信分配的密钥
    private static final String NONCE="123456";//随机数

    public static String sendMsg(String phone) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);

        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum=CheckUtils.getCheckSum(APP_SECRET,NONCE,curTime);

        //设置请求的header
        post.addHeader("AppKey",APP_KEY);
        post.addHeader("Nonce",NONCE);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        //设置请求参数
        List<NameValuePair> nameValuePairs =new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("mobile",phone));

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

        //执行请求
       /* HttpResponse response=httpclient.execute(post);
        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");
*/
        //判断是否发送成功，发送成功返回true
       // String code= JSON.parseObject(responseEntity).getString("code");
        return  "123456";

           /* return JSON.parseObject(responseEntity);*/


    }

    public static void main(String[] args) throws IOException {
        /*String s = sendMsg("13849991308");
        System.out.println(s);*/
    }
}