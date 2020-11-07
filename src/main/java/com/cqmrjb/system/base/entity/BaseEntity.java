
package com.cqmrjb.system.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel
@EqualsAndHashCode(callSuper=false)
public abstract class BaseEntity <T extends Model> extends Model<T> {

    @ApiModelProperty("ID")
    @TableId(value = "id",type= IdType.ID_WORKER)
    @JsonSerialize(using= ToStringSerializer.class)
    protected Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
