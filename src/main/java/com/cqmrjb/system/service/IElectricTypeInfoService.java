
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.ElectricTypeInfo;

import java.util.List;

/**
*
*@ClassName:电器类型 服务类
*@Description:
*@author: zhou
*@date 2020-11-03
*
*/
public interface IElectricTypeInfoService extends BaseService<ElectricTypeInfo> {

    boolean doRemoveeIds(long[] arr);

    List<ElectricTypeInfo> listElectricTypeInfo(String electricType);
}
