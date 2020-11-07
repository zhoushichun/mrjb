
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.ServiceTypeInfo;

import java.util.List;

/**
*
*@ClassName:服务类型 服务类
*@Description:
*@author: zhou
*@date 2020-11-03
*
*/
public interface IServiceTypeInfoService extends BaseService<ServiceTypeInfo> {

    boolean doRemoveeIds(long[] arr);

    List<ServiceTypeInfo> listServiceTypeInfo(String serviceType);
}
