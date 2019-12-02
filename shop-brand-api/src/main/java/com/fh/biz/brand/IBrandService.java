package com.fh.biz.brand;

import com.fh.po.brand.Brand;
import com.fh.vo.BrandVo;

import java.util.List;

public interface IBrandService {

    List<BrandVo> queryBrandByTypePib(Integer pid);
}
