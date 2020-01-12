package com.fh.biz;

import com.fh.common.ServerResponse;

public interface ICartService {

    Long addCarts(Integer productId, String userPhone);

    ServerResponse cartsShow(String userPhone);

    void addCartNum(Integer productId,String userPhone);

    void delCartNum(Integer productId, String userPhone);

    void isCheck(Integer productId, String userPhone);

    void isCheckAll(String userPhone);

    void delProduct(String userPhone,Integer productId);
}
