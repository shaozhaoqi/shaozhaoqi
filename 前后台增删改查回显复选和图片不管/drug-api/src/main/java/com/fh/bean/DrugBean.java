package com.fh.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("drug")
public class DrugBean {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("drugname")
    private String drugname;//药品名称

    @TableField("drugprice")
    private double drugprice;//价格

    @TableField("drugsales")
    private int drugsales;//销量

    @TableField("drugstock")
    private int drugstock;//库存

    @TableField("isotc")
    private int isotc;//是否处方药 1是非处方药 2是处方药

    @TableField("person")
    private String person;//适合人群(1幼儿 2少年 3青年 4中年 5老年 6孕妇)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("produceddate")
    private Date produceddate;//生产日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("expireddate")
    private Date expireddate;//过期日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("createdate")
    private Date createdate;// 创建时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("updatedate")
    private Date updatedate;//修改时间

    @TableField("areaid")
    private int areaid;//产地id

    @TableField("brandid")
    private int brandid;//品牌id

    @TableField("img")
    private String img;

}
