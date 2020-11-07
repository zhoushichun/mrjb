
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
*
*@ClassName:文件信息 服务类
*@Description:
*@author: zhou
*@date 2020-10-29
*
*/
public interface IFileInfoService extends BaseService<FileInfo> {

    String addFile(MultipartFile[] files);

    List<FileInfo> listFileInfo(String fileName);

    boolean doRemoveeIds(long[] arr);

}
