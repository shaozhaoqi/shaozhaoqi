package com.fh.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fh.bean.DrugBean;


import java.util.List;

public interface DrugDao extends BaseMapper<DrugBean> {

    /*
    查询
     */
    List<DrugBean> queryDrugLis();


}
