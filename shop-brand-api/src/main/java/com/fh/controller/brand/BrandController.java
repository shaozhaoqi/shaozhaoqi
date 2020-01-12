package com.fh.controller.brand;

import com.fh.biz.brand.IBrandService;
import com.fh.common.ServerResponse;
import com.fh.po.brand.Brand;

import com.fh.vo.BrandVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("brand")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class BrandController {
    @Resource(name="brandService")
    private IBrandService brandService;

    /*查询*/
   /* @GetMapping("queryBrandList")
    public ServerResponse queryBrandList(){
        List<Brand> brandList = brandService.queryBrandList();
           return ServerResponse.success(brandList);
    }*/
    @GetMapping("/{pid}")
    public ServerResponse queryBrandList(@PathVariable Integer pid){
        List<BrandVo> brandList = brandService.queryBrandByTypePib(pid);
        return ServerResponse.success(brandList);
    }
}
