package com.fh.controller;

import com.fh.bean.AreaBean;
import com.fh.bean.BrandBean;
import com.fh.bean.DrugBean;
import com.fh.service.AreaService;
import com.fh.service.DrugService;
import com.fh.util.AliyunOssUtils;
import com.fh.util.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin
@RequestMapping("drug")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @Autowired
    private AreaService areaService;


    /*
    查询Drug
     */
    @RequestMapping("queryDrugLis")
    public Map queryDrugLis(){
        Map map = new HashMap();
        try {
            List<DrugBean> list = drugService.queryDrugLis();
            map.put("code","200");
            map.put("message","success");
            map.put("data",list);
        }catch (Exception e){
            map.put("code","500");
            map.put("message","错误的地区信息为"+e.getMessage());
        }
        return map;
    }

    /*
   查询Area
    */
    @RequestMapping("queryAreaLis")
    public Map queryAreaLis(){
        Map map = new HashMap();
        try {
            List<AreaBean> list = drugService.queryAreaLis();
            map.put("code","200");
            map.put("message","success");
            map.put("data",list);
        }catch (Exception e){
            map.put("code","500");
            map.put("message","错误的地区信息为"+e.getMessage());
        }
        return map;
    }


    /*
  查询AreaRedis
   */
    @RequestMapping("queryAreaRedis")
    public Map queryAreaRedis(){
        Map map = new HashMap();
        try {
            List<AreaBean> list = areaService.queryAreaRedis();
            map.put("code","200");
            map.put("message","success");
            map.put("data",list);
        }catch (Exception e){
            map.put("code","500");
            map.put("message","错误的地区信息为"+e.getMessage());
        }
        return map;
    }

    /*
   查询Drug
    */
    @RequestMapping("queryBrandLis")
    public Map queryBrandLis(){
        Map map = new HashMap();
        try {
            List<BrandBean> list = drugService.queryBrandLis();
            map.put("code","200");
            map.put("message","success");
            map.put("data",list);
        }catch (Exception e){
            map.put("code","500");
            map.put("message","错误的地区信息为"+e.getMessage());
        }
        return map;
    }


    /*
    删除
     */
    @RequestMapping("DelDrugid")
    public void DelDrugid (int id){
        drugService.delDrugid(id);
    }

    /*
      新增 adddrug
     */
   @RequestMapping("adddrug")
    public DrugBean adddrug(DrugBean drugBean){
        drugService.adddrug(drugBean);
        return drugBean;
    }

    /*
    initFileInput图片上传
     */
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

    /*
    回显
     */

    @PostMapping("getDrugByid")
    public ResponseServer getDrugByid(Integer id){
         DrugBean drugBean = drugService.getDrugByid(id);
        return ResponseServer.success(drugBean);
    }
    /*
    修改
     */

    @RequestMapping("UpdateDrug")
    public ResponseServer UpdateDrug(DrugBean drugBean){
        drugService.UpdateDrug(drugBean);
        return ResponseServer.success(drugBean);
    }


}
