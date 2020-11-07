
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.ElectricSmallRoutine;
import com.cqmrjb.system.entity.ElectricSmallRoutineVO;
import com.cqmrjb.system.mapper.ElectricSmallRoutineMapper;
import com.cqmrjb.system.service.IElectricSmallRoutineService;
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
public class ElectricSmallRoutineServiceImpl extends BaseServiceImpl<ElectricSmallRoutineMapper, ElectricSmallRoutine> implements IElectricSmallRoutineService {

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return electricSmallRoutineMapper.doRemoveeIds(arr);
    }

    @Override
    public int deleteByAppId(String appid) {
        QueryWrapper<ElectricSmallRoutine> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("appid",appid);
        return baseMapper.delete(queryWrapper);
    }

    @Override
    public List<ElectricSmallRoutine> listElectricSmallRoutine(String appid, String electric) {
        return electricSmallRoutineMapper.listElectricSmallRoutine(appid,electric);
    }
}
