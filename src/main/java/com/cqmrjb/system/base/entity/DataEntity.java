
package com.cqmrjb.system.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public abstract class DataEntity<T extends Model> extends BaseEntity<T> {

    /**
     * 实体类上面才有效果，继承的没用。。
     *
     * @JsonIgnore：返回不显示的字段 hidden = true swagger 不显示该字段
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    protected Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    @JsonIgnore
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    protected Date updateDate;

    @ApiModelProperty(value = "状态")
    private Integer status=0;


    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private int current;

    @TableField(exist = false)
    @ApiModelProperty(value = "每一页的条数")
    private int size;


}
