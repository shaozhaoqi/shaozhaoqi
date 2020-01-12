package com.fh.service;

import com.fh.bean.AreaBean;

import java.util.List;

public interface AreaService {
    List<AreaBean> queryAreaRedis();
}
