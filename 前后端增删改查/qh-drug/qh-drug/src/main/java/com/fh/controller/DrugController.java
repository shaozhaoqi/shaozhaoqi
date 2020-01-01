package com.fh.controller;


import com.fh.entity.po.AreaInfo;
import com.fh.entity.po.BrandInfo;
import com.fh.entity.po.DrugInfo;
import com.fh.entity.vo.DrugVo;
import com.fh.service.DrugService;
import com.fh.utils.AliyunOssUtils;
import com.fh.utils.PageBean;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("drugs")
@CrossOrigin

public class DrugController {

    @Autowired
    private DrugService drugService;


   @PostMapping("queryDrugList")
    public PageBean<DrugVo> queryDrugList(PageBean<DrugVo> page){
        drugService.queryDrugList(page);
        return page;
    }


    //图片上传
    @PostMapping("uploadFile")

    public Map<String,Object> uploadFile(@RequestParam("imgUrl") CommonsMultipartFile imgUrl){
        Map<String,Object> map = new HashMap<String,Object>();
        AliyunOssUtils aliyunOssUtils=new AliyunOssUtils();
        String url = "";
        try {
            /*获取上传的图片名称*/
            url = aliyunOssUtils.uploadImg2Oss(imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*拼接图片路径 并返回到前台*/
        String imageUrl = aliyunOssUtils.getImageUrl(url);
        map.put("data",imageUrl);
        return map;

    }



    /*添加*/
    @PostMapping("addDrug")

    public ResponseServer addDrug(DrugInfo drugInfo){
        drugService.addDrug(drugInfo);
        return ResponseServer.success(drugInfo);
    }

    //下拉增加商品
    @PostMapping("/queryBrandList")
    public List<BrandInfo> queryBrandList(){
        List<BrandInfo>brandList=drugService.queryBrandList();
        return brandList;
    }
    //下拉增加地区
    @PostMapping("/queryAreaList")
    public List<AreaInfo> queryAreaList(){
        List<AreaInfo>areaList=drugService.queryAreaList();
        return areaList;
    }

    /*修改*/

    @GetMapping
    public ResponseServer getDrugById(Integer id){
        DrugInfo drugInfo=drugService.getDrugById(id);
        return ResponseServer.success(drugInfo);
    }


    @PostMapping("/updateDrug")
    public  ResponseServer updateDrug(DrugInfo drugInfo){
        drugService.updateDrug(drugInfo);
        return ResponseServer.success(drugInfo);
    }



    /*删除*/
    @DeleteMapping
    public ResponseServer deleteDrug(Integer id){
        drugService.deleteDrug(id);
        return ResponseServer.success(id);
    }
    /*批量删除*/
    @PostMapping("/batchDelete")
    public ResponseServer batchDelete(String ids) {
        drugService.batchDelete(ids);
        return ResponseServer.success();
    }


}
