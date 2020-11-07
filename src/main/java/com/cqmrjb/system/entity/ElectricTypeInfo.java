package com.cqmrjb.system.entity;

import com.cqmrjb.system.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 电器类型
 * </p>
 *
 * @author zhou
 * @since 2020-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ElectricTypeInfo对象", description="电器类型")
public class ElectricTypeInfo extends DataEntity<BookingOrder> {


    @ApiModelProperty(value = "电器类型")
    private String electricType;

}
