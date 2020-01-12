package com.fh.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("drug_brand")
public class BrandBean {

    @TableId(value = "brandid", type = IdType.AUTO)
    private int brandid;

    @TableField("brandname")
    private String brandname;

}
