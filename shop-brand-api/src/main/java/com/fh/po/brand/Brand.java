package com.fh.po.brand;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_brand")
public class Brand implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("brandName")
    private String brandName;
    @TableField("typeId")
    private Integer typeId;
    @TableField("img")
    private String img;
}
