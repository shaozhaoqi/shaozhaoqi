package com.fh.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.po.Cart;
import com.fh.utils.HttpclientUtils;
import com.fh.utils.SystemConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cartService")
public class ICartServiceImpl implements ICartService {

    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public Long addCarts(Integer productId, String userPhone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CARTSID + userPhone);
        //根据商品id查询商品信息
        String url = "http://localhost:8091/product/" + productId;
        //接口返回json字符串
        String result = HttpclientUtils.doGet(url);
        //把json转成obj
        JSONObject jsonObject = JSON.parseObject(result);
        //获取商品信息
        String data = jsonObject.get("data").toString();
        //把信息转成obj对象
        JSONObject productData = JSONObject.parseObject(data);
        //讲数据加入购物车实体bean中
        Cart cartBean = new Cart();
        cartBean.setProductName(productData.getString("name"));
        cartBean.setProductId(productData.getInteger("id"));
        cartBean.setMainImg(productData.getString("mainImg"));
        cartBean.setPrice(productData.getBigDecimal("price"));
        cartBean.setIsCheck(true);
        //判断商品是否存在购物车
        if(redisTemplate.opsForHash().hasKey(cartId,productId)){
            //获取商品
            Cart cart= (Cart) redisTemplate.opsForHash().get(cartId,productId);
            cartBean.setCount(cart.getCount()+1);
            cartBean.setSubtotal(cart.getSubtotal().add(productData.getBigDecimal("price")));

        }else{
            cartBean.setCount(1);
            cartBean.setSubtotal(productData.getBigDecimal("price"));
        }
        //加入到redis
        redisTemplate.opsForHash().put(cartId,productId,cartBean);
        Long cartCount=redisTemplate.opsForHash().size(cartId);
        return Long.valueOf(cartCount);
    }

    @Override
    public ServerResponse cartsShow(String phone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CARTSID + phone);
        //根据购物车id 找到对应的商品
        List<Cart> values = redisTemplate.opsForHash().values(cartId);
        Map map = new HashMap();
        map.put("product",values);
        Integer count=0;
        BigDecimal sumSubtotal = new BigDecimal(0.00);
        for (int i = 0; i <values.size() ; i++) {
            if (values.get(i).getIsCheck()){
                count++;
                sumSubtotal = sumSubtotal.add(values.get(i).getSubtotal());
            }
        }
        map.put("sumCount",count);
        map.put("sumSubtotal",sumSubtotal);
        return ServerResponse.success(map);
    }

    @Override
    public void addCartNum(Integer productId,String userPhone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CARTSID + userPhone);
        //获取商品
        Cart cart= (Cart) redisTemplate.opsForHash().get(cartId,productId);
        //商品个数加1
        cart.setCount(cart.getCount()+1);
        //小计价格加上原价
        cart.setSubtotal(cart.getSubtotal().add(cart.getPrice()));
        //修改缓存数据
        redisTemplate.opsForHash().put(cartId,productId,cart);
    }

    @Override
    public void delCartNum(Integer productId, String userPhone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CARTSID + userPhone);
        //获取商品
        Cart cart= (Cart) redisTemplate.opsForHash().get(cartId,productId);
        //商品个数-1
        cart.setCount(cart.getCount()-1);
        //小计价格减去原价
        cart.setSubtotal(cart.getSubtotal().subtract(cart.getPrice()));
        //修改缓存数据
        redisTemplate.opsForHash().put(cartId,productId,cart);
    }

    @Override
    public void isCheck(Integer productId, String userPhone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CARTSID + userPhone);
        //获取商品
        Cart cart= (Cart) redisTemplate.opsForHash().get(cartId,productId);
        //是否选中  取反
        cart.setIsCheck(!cart.getIsCheck());
        //修改缓存数据
        redisTemplate.opsForHash().put(cartId,productId,cart);
    }

    @Override
    public void isCheckAll(String userPhone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CARTSID + userPhone);
        //根据购物车id 找到对应的商品
        List<Cart> values = redisTemplate.opsForHash().values(cartId);
        for (int i = 0; i < values.size(); i++) {
            if (!values.get(i).getIsCheck()){
                values.get(i).setIsCheck(true);
                //修改缓存数据
                redisTemplate.opsForHash().put(cartId,values.get(i).getProductId(),values.get(i));

            }

        }
    }

    @Override
    public void delProduct(String userPhone,Integer productId) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get(SystemConstant.REDIS_CARTSID + userPhone);
        //删除商品
        redisTemplate.opsForHash().delete(cartId,productId);

    }
}
