package com.cqmrjb.system.entity;

import com.cqmrjb.system.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 小程序
 * </p>
 *
 * @author zhou
 * @since 2020-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SmallRoutineInfo对象", description = "小程序信息")
public class SmallRoutineInfo extends DataEntity<SmallRoutineInfo> {

    @ApiModelProperty(value = "appid")
    private String appid;

    @ApiModelProperty(value = "小程序名称")
    private String smallRoutineName;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturers;


}
