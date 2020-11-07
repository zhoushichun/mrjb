
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.ElectricService;

import java.util.List;

/**
*
*@ClassName: 服务类
*@Description:
*@author: zhou
*@date 2020-11-04
*
*/
public interface IElectricServiceService extends BaseService<ElectricService> {

    boolean doRemoveeIds(long[] arr);

    List<ElectricService> listElectricService(String appid, String electricType, String serviceType);

    int deleteByAppId(Long electricId);
}
