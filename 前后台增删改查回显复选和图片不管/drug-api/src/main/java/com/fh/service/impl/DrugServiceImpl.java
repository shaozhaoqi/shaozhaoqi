package com.fh.service.impl;

import com.fh.bean.AreaBean;
import com.fh.bean.BrandBean;
import com.fh.bean.DrugBean;
import com.fh.dao.AreaDao;
import com.fh.dao.BrandDao;
import com.fh.dao.DrugDao;
import com.fh.service.DrugService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Resource
    private DrugDao drugDao;
    @Resource
    private AreaDao areaDao;
    @Resource
    private BrandDao brandDao;

    /*
    查询
     */
    public List<DrugBean> queryDrugLis() {
        return drugDao.queryDrugLis();
    }

    /*
    删除
     */
    public void delDrugid(int id) {
        drugDao.deleteById(id);
    }

    /*
    新增
     */
    public void adddrug(DrugBean drugBean) {
        drugDao.insert(drugBean);
    }

    /*
    查询地区
     */
    public List<AreaBean> queryAreaLis() {
        return areaDao.selectList(null);
    }

    public List<BrandBean> queryBrandLis() {
        return brandDao.selectList(null);
    }

    /*
    回显
     */
    public DrugBean getDrugByid(Integer id) {
        return drugDao.selectById(id);
    }

    public void UpdateDrug(DrugBean drugBean) {
        drugDao.updateById(drugBean);
    }
}
