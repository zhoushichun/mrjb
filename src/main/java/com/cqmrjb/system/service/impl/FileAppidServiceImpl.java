
package com.cqmrjb.system.service.impl;

import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.FileAppid;
import com.cqmrjb.system.mapper.FileAppidMapper;
import com.cqmrjb.system.service.IFileAppidService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
*@ClassName: 服务实现类
*@Description:
*@author: zhou
*@date 2020-11-02
*
*/
@Service
public class FileAppidServiceImpl extends BaseServiceImpl<FileAppidMapper, FileAppid> implements IFileAppidService {


    @Override
    public boolean doRemoveeIds(long[] arr) {
        return fileAppidMapper.doRemoveeIds(arr);
    }

    @Override
    public List<FileAppid> listFileAppidInfo(String appid, Long fileId, String smallRoutineName) {

        return fileAppidMapper.listFileAppidInfo(appid,fileId,smallRoutineName);
    }
}
