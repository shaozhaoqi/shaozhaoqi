package com.fh.mapper.product;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.param.ProductSearchParam;
import com.fh.po.prodict.Product;
import com.fh.vo.product.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IProductMapper extends BaseMapper<Product> {
    List<ProductVo> queryProduct(ProductSearchParam productSearchParam);

    long queryCount(ProductSearchParam productSearchParam);
}
