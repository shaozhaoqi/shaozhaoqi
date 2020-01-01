package com.fh.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("drug_area")
public class AreaBean {

    @TableId(value = "areaid",type = IdType.AUTO )
    private int areaid;

    @TableField("areaname")
    private String areaname;
}
