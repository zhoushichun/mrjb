package com.cqmrjb.system.entity;

import com.cqmrjb.system.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务类型
 * </p>
 *
 * @author zhou
 * @since 2020-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ServiceTypeInfo对象", description = "服务类型")
public class ServiceTypeInfo extends DataEntity<BookingOrder> {

    @ApiModelProperty(value = "服务类型")
    private String serviceType;

}
