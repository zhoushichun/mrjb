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
 * @since 2020-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FileAppid对象", description="")
public class FileAppid extends DataEntity<FileAppid> {

    @ApiModelProperty(value = "文件id")
    private Long fileId;

    @ApiModelProperty(value = "小程序id")
    private String appid;

    @TableField(exist = false)
    @ApiModelProperty(value = "小程序名称")
    private String smallRoutineName;

    @TableField(exist = false)
    @ApiModelProperty(value = "文件名")
    private String fileName;

    @TableField(exist = false)
    @ApiModelProperty(value = "path")
    private String path;

    @TableField(exist = false)
    @ApiModelProperty(value = "url")
    private String url;


}
