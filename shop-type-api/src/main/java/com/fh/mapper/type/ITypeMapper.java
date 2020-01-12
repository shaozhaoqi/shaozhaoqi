package com.fh.mapper.type;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.po.type.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITypeMapper extends BaseMapper<Type> {
    List<Type> queryTypeList();
}
