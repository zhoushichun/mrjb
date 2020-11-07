
package com.cqmrjb.system.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    @Autowired
    public UserInfoMapper userInfoMapper;
    @Autowired
    public SmallRoutineInfoMapper smallRoutineInfoMapper;
    @Autowired
    public SmallRoutineContentMapper smallRoutineContentMapper;
    @Autowired
    public FileInfoMapper fileInfoMapper;
    @Autowired
    public BookingOrderMapper bookingOrderMapper;
    @Autowired
    public FileAppidMapper fileAppidMapper;
    @Autowired
    public ElectricTypeInfoMapper electricTypeInfoMapper;
    @Autowired
    public ServiceTypeInfoMapper serviceTypeInfoMapper;
    @Autowired
    public ElectricServiceMapper electricServiceMapper;

    @Autowired
    public ElectricSmallRoutineMapper electricSmallRoutineMapper;


    /**
     * 实体类型
     */
    private Class<?> entityClass;

    {
        Class<?> clazz = this.getClass();
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) p[1];
        }
    }

    @Override
    public IPage<T> getPageList(int current, int size) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        Page<T> page = new Page<>(current, size);
        return baseMapper.selectPage(page, wrapper);
    }


}
