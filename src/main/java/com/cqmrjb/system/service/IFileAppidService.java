
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.FileAppid;

import java.util.List;

/**
*
*@ClassName: 服务类
*@Description:
*@author: zhou
*@date 2020-11-02
*
*/
public interface IFileAppidService extends BaseService<FileAppid> {

    boolean doRemoveeIds(long[] arr);

    List<FileAppid> listFileAppidInfo(String appid, Long fileId, String smallRoutineName);

}
