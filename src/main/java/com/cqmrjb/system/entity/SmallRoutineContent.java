package com.cqmrjb.system.entity;

import com.cqmrjb.system.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 小程序内容
 * </p>
 *
 * @author zhou
 * @since 2020-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SmallRoutineContent对象", description="小程序内容")
public class SmallRoutineContent extends DataEntity<SmallRoutineContent> {


    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "业务范围")
    private String content;

    @ApiModelProperty(value = "小程序ID")
    private String appid;


}
