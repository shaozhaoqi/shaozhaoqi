package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ILoginMapper extends BaseMapper<User> {
}
