
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.SmallRoutineInfo;

import java.util.List;

/**
*
*@ClassName:小程序程序 服务类
*@Description:
*@author: zhou
*@date 2020-10-29
*
*/
public interface ISmallRoutineInfoService extends BaseService<SmallRoutineInfo> {


    SmallRoutineInfo getAppid(String appid);

    List<SmallRoutineInfo> listRoutineInfo(String smallRoutineName, String appid, String manufacturers);

    boolean doRemoveeIds(long[] arr);


}
