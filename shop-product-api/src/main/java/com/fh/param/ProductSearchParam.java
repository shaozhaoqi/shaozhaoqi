package com.fh.param;


import com.fh.common.Page;
import lombok.Data;

@Data
public class ProductSearchParam extends Page {
    private Integer brandId;
    private Integer typeId;


}
