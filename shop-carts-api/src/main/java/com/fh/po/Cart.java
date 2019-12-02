package com.fh.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Cart implements Serializable {

    private Integer productId;

    private String productName;

    private String mainImg;

    private BigDecimal price;

    private Integer count;

    private BigDecimal subtotal;

    private Boolean isCheck;


}
