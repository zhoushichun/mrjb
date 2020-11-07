
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.ElectricSmallRoutine;
import com.cqmrjb.system.entity.ElectricSmallRoutineVO;

import java.util.List;

/**
*
*@ClassName: 服务类
*@Description:
*@author: zhou
*@date 2020-11-04
*
*/
public interface IElectricSmallRoutineService extends BaseService<ElectricSmallRoutine> {

    boolean doRemoveeIds(long[] arr);

    int deleteByAppId(String appid);

    List<ElectricSmallRoutine> listElectricSmallRoutine(String appid, String electric);
}
