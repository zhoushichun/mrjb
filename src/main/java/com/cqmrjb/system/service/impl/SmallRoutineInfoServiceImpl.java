
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.SmallRoutineInfo;
import com.cqmrjb.system.mapper.SmallRoutineInfoMapper;
import com.cqmrjb.system.service.ISmallRoutineInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @ClassName:小程序程序 服务实现类
 * @Description:
 * @author: zhou
 * @date 2020-10-29
 */
@Service
@Transactional
public class SmallRoutineInfoServiceImpl extends BaseServiceImpl<SmallRoutineInfoMapper, SmallRoutineInfo> implements ISmallRoutineInfoService {


    @Override
    public SmallRoutineInfo getAppid(String appid) {
        QueryWrapper<SmallRoutineInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("appid",appid);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<SmallRoutineInfo> listRoutineInfo(String smallRoutineName, String appid, String manufacturers) {

        QueryWrapper<SmallRoutineInfo> wrapper = new QueryWrapper<>();
        if(smallRoutineName !=null &&smallRoutineName !=""){
            wrapper.like("small_routine_name",smallRoutineName);
        }
        if(appid !=null && appid !=""){
            wrapper.eq("appid",appid);
        }
        if(manufacturers!=null && manufacturers !=""){
            wrapper.like("manufacturers",manufacturers);
        }
        wrapper.eq("status",0);
        wrapper.orderByDesc("update_date");
        return baseMapper.selectList(wrapper);
    }

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return smallRoutineInfoMapper.doRemoveeIds(arr);
    }
}
