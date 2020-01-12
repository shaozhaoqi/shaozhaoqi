package com.fh.service;


import com.fh.bean.AreaBean;
import com.fh.bean.BrandBean;
import com.fh.bean.DrugBean;

import java.util.List;

public interface DrugService {
    /*
    查询
     */
    List<DrugBean> queryDrugLis();

    /*
    删除
     */
    void delDrugid(int id);

    /*
    新增
     */
    void adddrug(DrugBean drugBean);

    /*
    查询地区
     */
    List<AreaBean> queryAreaLis();

    /*
    查询类型
     */
    List<BrandBean> queryBrandLis();

    /*
    回显
     */
    DrugBean getDrugByid(Integer id);

    void UpdateDrug(DrugBean drugBean);
}
