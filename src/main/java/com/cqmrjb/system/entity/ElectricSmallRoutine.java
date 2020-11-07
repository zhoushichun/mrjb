package com.cqmrjb.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cqmrjb.system.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zhou
 * @since 2020-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ElectricSmallRoutine对象", description = "")
public class ElectricSmallRoutine extends DataEntity<ElectricSmallRoutine> {

    @ApiModelProperty(value = "电器类型id")
    private Long electricTypeId;

    @ApiModelProperty(value = "appid")
    private String appid;

    @TableField(exist = false)
    @ApiModelProperty(value = "电器类型名")
    private String electricType;

    @TableField(exist = false)
    @ApiModelProperty(value = "小程序名称")
    private String smallRoutineName;

    @TableField(exist = false)
    @ApiModelProperty(value = "生产厂家")
    private String manufacturers;




}
