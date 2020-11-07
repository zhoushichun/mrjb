
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.ElectricService;
import com.cqmrjb.system.mapper.ElectricServiceMapper;
import com.cqmrjb.system.service.IElectricServiceService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
*@ClassName: 服务实现类
*@Description:
*@author: zhou
*@date 2020-11-04
*
*/
@Service
public class ElectricServiceServiceImpl extends BaseServiceImpl<ElectricServiceMapper, ElectricService> implements IElectricServiceService {

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return electricServiceMapper.doRemoveeIds(arr);
    }

    @Override
    public List<ElectricService> listElectricService(String appid, String electricType, String serviceType) {
        return electricServiceMapper.listElectricService(appid,electricType,serviceType);
    }

    @Override
    public int deleteByAppId(Long electricId) {
        QueryWrapper<ElectricService> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("electric_type_id",electricId);
        return baseMapper.delete(queryWrapper);

    }
}
