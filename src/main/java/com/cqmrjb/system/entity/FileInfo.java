package com.cqmrjb.system.entity;

import com.cqmrjb.system.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件信息
 * </p>
 *
 * @author zhou
 * @since 2020-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FileInfo对象", description="文件信息")
public class FileInfo extends DataEntity<FileInfo> {


    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "path")
    private String path;

    @ApiModelProperty(value = "url")
    private String url;



}
