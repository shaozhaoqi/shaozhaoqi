package com.fh.service;


import com.fh.entity.po.AreaInfo;
import com.fh.entity.po.BrandInfo;
import com.fh.entity.po.DrugInfo;
import com.fh.entity.vo.DrugVo;
import com.fh.utils.PageBean;

import java.util.List;


public interface DrugService {
    void queryDrugList(PageBean<DrugVo> page);

    void addDrug(DrugInfo drugInfo);

    DrugInfo  getDrugById(Integer id);

    void updateDrug(DrugInfo drugInfo);

    List<BrandInfo> queryBrandList();

    List<AreaInfo> queryAreaList();

    void deleteDrug(Integer id);
    /*批量删*/
    void batchDelete(String ids);


    // List<BrandInfo> queryBrandList();
}
