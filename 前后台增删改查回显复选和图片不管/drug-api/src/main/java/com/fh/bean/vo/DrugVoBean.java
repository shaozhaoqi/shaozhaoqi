package com.fh.bean.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DrugVoBean {

    private int id;

    private String drugname;//药品名称

    private double drugprice;//价格

    private int drugsales;//销量

    private int drugstock;//库存

    private int isotc;//是否处方药 1是非处方药 2是处方药

    private String person;//适合人群(1幼儿 2少年 3青年 4中年 5老年 6孕妇)

    private Date produceddate;//生产日期

    private Date expireddate;//过期日期

    private Date createdate;// 创建时间

    private Date updatedate;//修改时间

    private String areaname;//产地id

    private String brandname;//品牌id

    private String img;//图片



}
