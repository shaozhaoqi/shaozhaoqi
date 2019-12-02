package com.fh.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user1")
public class User implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("userName")
    private  String userName;
    @TableField("realName")
    private  String realName;
    @TableField("password")
    private  String password;
    @TableField("age")
    private int age;
    @TableField("sex")
    private int sex;
    @TableField("phone")
    private String phone;
    @TableField("email")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("entryDate")
    private Date entryDate;
    @TableField("cartsId")
    private String cartsId;

}
