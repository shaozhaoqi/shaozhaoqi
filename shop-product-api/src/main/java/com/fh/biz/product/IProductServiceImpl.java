package com.fh.biz.product;

import com.fh.common.DataTableResult;
import com.fh.common.Page;
import com.fh.common.ServerResponse;
import com.fh.config.RedisUtil;
import com.fh.mapper.product.IProductMapper;
import com.fh.param.ProductSearchParam;
import com.fh.po.prodict.Product;
import com.fh.utils.DateUtil;
import com.fh.vo.product.ProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("productService")
public class IProductServiceImpl implements IProductService {
    @Resource
    private IProductMapper productMapper;

    /***
     * 展示商品
     * @parampage
     * @return
     */
    @Override
    public DataTableResult queryProductList(ProductSearchParam productSearchParam) {
        //获取总条数
        long totalCount = productMapper.queryCount(productSearchParam);
        //查出所有商品
        List<ProductVo> productList = productMapper.queryProduct(productSearchParam);
        //转vo展示
       /* List<ProductVo> productVoList = getProductVos(productList);*/
        DataTableResult dataTableResult = new DataTableResult(productSearchParam.getDraw(), totalCount, totalCount, productList);
        return dataTableResult;
    }

    @Override
    public ServerResponse queryProductByid(Integer productId) {
        Product product = productMapper.selectById(productId);
        return ServerResponse.success(product);
    }


}
