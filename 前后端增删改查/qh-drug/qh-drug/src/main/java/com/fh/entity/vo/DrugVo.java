package com.fh.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class DrugVo {


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("drugName")
    private String drugName;
    @TableField("drugPrice")
    private BigDecimal drugPrice;
    @TableField("drugSales")
    private Integer drugSales;//销量
    @TableField("drugStock")
    private Integer drugStock;//库存
    @TableField("isOtc")
    private Integer isOtc;//状态
    @TableField("person")
    private String person;//人群
    @TableField("producedDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producedDate;
    @TableField("createDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    @TableField("updateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    @TableField("areaId")
    private Integer areaId;
    @TableField("brandId")
    private Integer brandId;
    @TableField("img")
    private String img;




    @TableField("brandName")
    private String brandName;
    @TableField("areaName")
    private String areaName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public BigDecimal getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(BigDecimal drugPrice) {
        this.drugPrice = drugPrice;
    }

    public Integer getDrugSales() {
        return drugSales;
    }

    public void setDrugSales(Integer drugSales) {
        this.drugSales = drugSales;
    }

    public Integer getDrugStock() {
        return drugStock;
    }

    public void setDrugStock(Integer drugStock) {
        this.drugStock = drugStock;
    }

    public Integer getIsOtc() {
        return isOtc;
    }

    public void setIsOtc(Integer isOtc) {
        this.isOtc = isOtc;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
