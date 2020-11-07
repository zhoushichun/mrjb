package com.cqmrjb.common.page;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable {

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "每页数量")
    private Integer size = 10;

//    @ApiModelProperty(value = "默认根据排序desc")
//    private String ordeby = "desc";

}
