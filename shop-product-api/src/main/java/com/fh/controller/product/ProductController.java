package com.fh.controller.product;

import com.fh.biz.product.IProductService;
import com.fh.common.DataTableResult;
import com.fh.common.Page;
import com.fh.common.ServerResponse;
import com.fh.config.RedisUtil;
import com.fh.param.ProductSearchParam;
import com.fh.po.prodict.Product;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("product")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class ProductController {
    @Resource(name = "productService")
    private IProductService productService;

    /***
     * 查询
     * @parampage
     * @return
     */
    @PostMapping
    public DataTableResult queryProductList(ProductSearchParam productSearchParam){
            DataTableResult result = productService.queryProductList(productSearchParam);
        return result;
    }

    @GetMapping("/{productId}")
    public ServerResponse queryProductByid(@PathVariable Integer productId){
        return productService.queryProductByid(productId);
    }

}
