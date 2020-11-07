
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.ServiceTypeInfo;
import com.cqmrjb.system.mapper.ServiceTypeInfoMapper;
import com.cqmrjb.system.service.IServiceTypeInfoService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName:服务类型 服务实现类
 * @Description:
 * @author: zhou
 * @date 2020-11-03
 */
@Service
public class ServiceTypeInfoServiceImpl extends BaseServiceImpl<ServiceTypeInfoMapper, ServiceTypeInfo> implements IServiceTypeInfoService {

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return serviceTypeInfoMapper.doRemoveeIds(arr);
    }

    @Override
    public List<ServiceTypeInfo> listServiceTypeInfo( String serviceType) {
        QueryWrapper<ServiceTypeInfo> wrapper = new QueryWrapper<>();
        if (serviceType != null && serviceType != "") {
            wrapper.like("service_type", serviceType);
        }
        wrapper.eq("status", 0);
        wrapper.orderByDesc("update_date");
        return baseMapper.selectList(wrapper);
    }
}
