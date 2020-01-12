package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.fh.entity.po.AreaInfo;
import com.fh.entity.po.BrandInfo;
import com.fh.entity.po.DrugInfo;
import com.fh.entity.vo.DrugVo;
import com.fh.utils.PageBean;

import java.util.List;

public interface DrugDao extends BaseMapper<DrugInfo> {
    long queryCount();

    List<DrugVo> queryDrugList(PageBean<DrugVo> page);

    void addDrug(DrugInfo drugInfo);

    List<BrandInfo> queryBrandList();

    List<AreaInfo> queryAreaList();

    void batchDelete(List isList);



}
