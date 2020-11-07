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
 * 预约订单
 * </p>
 *
 * @author zhou
 * @since 2020-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BookingOrder对象", description="预约订单")
public class BookingOrder  extends DataEntity<BookingOrder> {


    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "电器类型")
    private String electricType;

    @ApiModelProperty(value = "服务类型")
    private String serviceType;

    @ApiModelProperty(value = "订单地址")
    private String orderSite;

    @ApiModelProperty(value = "订单来源appid")
    private String appid;

    @TableField(exist = false)
    @ApiModelProperty(value = "小程序名称")
    private String smallRoutineName;

    @TableField(exist = false)
    @ApiModelProperty(value = "生产厂家")
    private String manufacturers;






}
