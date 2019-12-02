package com.fh.controller.type;

import com.fh.biz.type.ITypeService;
import com.fh.common.ServerResponse;
import com.fh.po.type.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("type")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class TypeController {
    @Resource(name="typeService")
    private ITypeService typeService;


    /***
     * 查询
     * @return
     */
    /*@GetMapping("queryTypeList")
    public ServerResponse queryTypeList(){
        List typeList = typeService.queryTypeList();
        return ServerResponse.success(typeList);
    }*/
    @GetMapping
    public ServerResponse queryTypeAll(){
        Object typeList = typeService.queryTypeList();
        return ServerResponse.success(typeList);
    }
}
