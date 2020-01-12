package com.fh.biz.product;

import com.fh.common.DataTableResult;
import com.fh.common.Page;
import com.fh.common.ServerResponse;
import com.fh.param.ProductSearchParam;

public interface IProductService {

    DataTableResult queryProductList(ProductSearchParam productSearchParam);


    ServerResponse queryProductByid(Integer productId);
}
