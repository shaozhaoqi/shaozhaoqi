package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.dao.BrandDao;
import com.fh.dao.DrugDao;

import com.fh.entity.po.AreaInfo;
import com.fh.entity.po.BrandInfo;
import com.fh.entity.po.DrugInfo;
import com.fh.entity.vo.DrugVo;
import com.fh.service.DrugService;
import com.fh.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Resource
    private DrugDao drugDao;
    @Resource
    private BrandDao brandDao;

    @Override
    public void queryDrugList(PageBean<DrugVo> page) {
        long count = drugDao.queryCount();
        page.setRecordsTotal(count);
        page.setRecordsFiltered(count);
        List<DrugVo> drugVoList = drugDao.queryDrugList(page);
        page.setData(drugVoList);
    }

    @Override
    public void addDrug(DrugInfo drugInfo) {
        drugInfo.setUpdateDate(new Date());
        drugInfo.setCreateDate(new Date());
        drugDao.addDrug(drugInfo);
    }

    @Override
    public DrugInfo getDrugById(Integer id) {
        QueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return drugDao.selectOne(queryWrapper);
    }
    //修改
    @Override
    public void updateDrug(DrugInfo drugInfo) {
        drugDao.updateById(drugInfo);
    }

    @Override
    public List<BrandInfo> queryBrandList() {
        return drugDao.queryBrandList();
    }

    @Override
    public List<AreaInfo> queryAreaList() {
        return drugDao.queryAreaList();
    }
    //删除
    @Override
    public void deleteDrug(Integer id) {
        drugDao.deleteById(id);
    }
    //批量删
    @Override
    public void batchDelete(String ids) {
        String[] split = ids.split(",");//["1","2"...]
        List isList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int i1 = Integer.parseInt(s);
            isList.add(i1);

        }
        drugDao.batchDelete(isList);

    }













}
