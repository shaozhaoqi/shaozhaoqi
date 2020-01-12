package com.fh.biz.brand;

import com.fh.mapper.brand.IBrandMapper;
import com.fh.po.brand.Brand;

import com.fh.vo.BrandVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service("brandService")
public class IBrandServiceImpl implements IBrandService {
    @Resource
    private IBrandMapper brandMapper;


    @Override
    public List<BrandVo> queryBrandByTypePib(Integer pid) {
        List<BrandVo> brandList = brandMapper.queryBrandList();
        List<BrandVo> returnList= brandList.stream()
                .filter(brand->brand.getPid().equals(pid))
                .collect(Collectors.toList());
        return returnList;
    }
}
