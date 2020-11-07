
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.ElectricTypeInfo;
import com.cqmrjb.system.mapper.ElectricTypeInfoMapper;
import com.cqmrjb.system.service.IElectricTypeInfoService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName:电器类型 服务实现类
 * @Description:
 * @author: zhou
 * @date 2020-11-03
 */
@Service
public class ElectricTypeInfoServiceImpl extends BaseServiceImpl<ElectricTypeInfoMapper, ElectricTypeInfo> implements IElectricTypeInfoService {

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return electricTypeInfoMapper.doRemoveeIds(arr);
    }

    @Override
    public List<ElectricTypeInfo> listElectricTypeInfo(String electricType) {
        QueryWrapper<ElectricTypeInfo> wrapper = new QueryWrapper<>();

        if (electricType != null && electricType != "") {
            wrapper.like("electric_type", electricType);
        }
        wrapper.eq("status",0);
        wrapper.orderByDesc("update_date");
        return baseMapper.selectList(wrapper);
    }
}
