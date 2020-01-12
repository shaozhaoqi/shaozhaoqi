package com.fh.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.mapper.ILoginMapper;
import com.fh.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service("loginService")
public class ILoginServiceImpl implements ILoginService {

    @Resource
    private ILoginMapper loginMapper;

    @Override
    public User isRegist(String phone) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("phone",phone);
        User user = loginMapper.selectOne(queryWrapper);
        //user为空注册
        if (user == null){
            //注册
            user = new User();
            user.setPhone(phone);
            user.setEntryDate(new Date());
            user.setCartsId(UUID.randomUUID().toString().replace("-",""));
            loginMapper.insert(user);
            return user;
        }
        return user;
    }
}
