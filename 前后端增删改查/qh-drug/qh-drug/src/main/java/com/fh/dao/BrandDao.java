package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.po.BrandInfo;

import java.util.List;

public interface BrandDao extends BaseMapper<BrandInfo> {
    List<BrandInfo> queryBrandList();
    /*List<BrandInfo> queryBrandList();*/
}
