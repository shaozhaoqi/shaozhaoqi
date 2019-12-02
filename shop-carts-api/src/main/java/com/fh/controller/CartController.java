package com.fh.controller;

import com.fh.biz.ICartService;
import com.fh.common.ServerResponse;
import com.fh.login.LoginAnnotation;
import com.fh.utils.SystemConstant;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("carts")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080",exposedHeaders="NOLONGIN")
public class CartController {

    @Resource
    private ICartService cartService;

    /**
     * 把商品加入购物车
     * @param productId
     * @param request
     * @return
     */
    @PostMapping
    @LoginAnnotation
    public ServerResponse addCarts(Integer productId,HttpServletRequest request){
       //获取request里的手机号
        String userPhone= (String) request.getAttribute(SystemConstant.REDIS_PHONE);
        //新增 参数是 商品id  手机号 返回 商品个数
        Long count = cartService.addCarts(productId,userPhone);

        return ServerResponse.success(count);
    }

    /**
     * 展示购物车
     * @return
     */
    @GetMapping
    @LoginAnnotation
    public ServerResponse lookCarts(){
        return ServerResponse.success();
    }

    /**
     * 展示购物车里的商品
     * @param request
     * @return
     */
    @PostMapping("cartsShow")
    @LoginAnnotation
    public ServerResponse cartsShow(HttpServletRequest request){
        //获取request里的手机号
        String userPhone= (String) request.getAttribute(SystemConstant.REDIS_PHONE);
        return cartService.cartsShow(userPhone);
    }

    /**
     * 商品添加个数
     * @param request
     * @param productId
     * @return
     */
    @PostMapping("addCartNum")
    @LoginAnnotation
    public ServerResponse addCartNum(HttpServletRequest request,Integer productId){
        //获取request里的手机号
        String userPhone= (String) request.getAttribute(SystemConstant.REDIS_PHONE);
        cartService.addCartNum(productId,userPhone);
        return ServerResponse.success();
    }

    /**
     * 商品减个数
     * @param request
     * @param productId
     * @return
     */
    @PostMapping("delCartNum")
    @LoginAnnotation
    public ServerResponse delCartNum(HttpServletRequest request,Integer productId){
        //获取request里的手机号
        String userPhone= (String) request.getAttribute(SystemConstant.REDIS_PHONE);
        cartService.delCartNum(productId,userPhone);
        return ServerResponse.success();
    }

    /**
     * 是否选中
     * @param request
     * @param productId
     * @return
     */
    @PostMapping("isCheck")
    @LoginAnnotation
    public ServerResponse isCheck(HttpServletRequest request,Integer productId){
        //获取request里的手机号
        String userPhone= (String) request.getAttribute(SystemConstant.REDIS_PHONE);
        cartService.isCheck(productId,userPhone);
        return ServerResponse.success();
    }

    /**
     * 全选全不选
     * @param request
     * @return
     */
    @PostMapping("isCheckAll")
    @LoginAnnotation
    public ServerResponse isCheckAll(HttpServletRequest request){
        //获取request里的手机号
        String userPhone= (String) request.getAttribute(SystemConstant.REDIS_PHONE);
        cartService.isCheckAll(userPhone);
        return ServerResponse.success();
    }

    /**
     * 移除商品
     * @return
     */
    @DeleteMapping
    @LoginAnnotation
    public ServerResponse delProduct(HttpServletRequest request,Integer productId){
        //获取request里的手机号
        String userPhone= (String) request.getAttribute(SystemConstant.REDIS_PHONE);
        cartService.delProduct(userPhone,productId);
        return ServerResponse.success();
    }

}
