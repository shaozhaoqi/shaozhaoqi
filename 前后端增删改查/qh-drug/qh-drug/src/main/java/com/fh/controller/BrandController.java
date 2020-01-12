package com.fh.controller;

import com.fh.entity.po.BrandInfo;
import com.fh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brands")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/queryBrandList")
    public List<BrandInfo> queryBrandList(){
       List<BrandInfo>brandList= brandService.queryBrandList();
        return brandList;
    }

}