package com.fh.po.prodict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_shop_product")
public class Product implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    @TableField("brand_id")
    private Integer brandId;//        `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
    @TableField("name")
    private String name;//        `name` varchar(100) DEFAULT NULL COMMENT '商品名称',
    @TableField("subtitle")
    private String subtitle;//        `subtitle` varchar(500) DEFAULT NULL COMMENT '宣传标题',
    @TableField("main_img")
    private String mainImg;//        `main_img` varchar(255) DEFAULT NULL COMMENT '主图片',
    @TableField("sub_imgs")
    private String subImgs;//        `sub_imgs` text COMMENT '副图片',
    @TableField("detail")
    private String detail;//        `detail` text COMMENT '商品描述',
    @TableField("price")
    private BigDecimal price;//        `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
    @TableField("stock")
    private Integer stock;//        `stock` int(11) DEFAULT NULL COMMENT '库存',
    @TableField("status")
    private Integer status;//    `status` int(11) DEFAULT NULL COMMENT '状态',
    @TableField("create_time")
    private Date createTime;//        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    @TableField("update_time")
    private Date updateTime;//        `update_time` datetime DEFAULT NULL COMMENT '修改时间',

}
