package com.fh.mapper.brand;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.po.brand.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBrandMapper extends BaseMapper<Brand> {


    List queryBrandList();
}
