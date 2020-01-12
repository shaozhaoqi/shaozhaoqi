package com.fh.vo.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVo {

    private Integer id;//            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    private String img;//        `brand_id` int(11) DEFAULT NULL COMMENT '类型ID',
    private String name;//        `name` varchar(100) DEFAULT NULL COMMENT '商品名称',
    private String subtitle;//        `subtitle` varchar(500) DEFAULT NULL COMMENT '宣传标题',
    private String mainImg;//        `main_img` varchar(255) DEFAULT NULL COMMENT '主图片',
    private String detail;//        `detail` text COMMENT '商品描述',
    private BigDecimal price;//        `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
    private Integer stock;//        `stock` int(11) DEFAULT NULL COMMENT '库存',
    private String status;//    `status` int(11) DEFAULT NULL COMMENT '状态',
    private String createTime;//        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    private String updateTime;//        `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    private String typeName;


}


