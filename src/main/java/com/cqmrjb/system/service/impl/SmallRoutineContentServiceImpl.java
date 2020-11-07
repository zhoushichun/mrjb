
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.SmallRoutineContent;
import com.cqmrjb.system.mapper.SmallRoutineContentMapper;
import com.cqmrjb.system.service.ISmallRoutineContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @ClassName:小程序内容 服务实现类
 * @Description:
 * @author: zhou
 * @date 2020-10-29
 */
@Service
@Transactional
public class SmallRoutineContentServiceImpl extends BaseServiceImpl<SmallRoutineContentMapper, SmallRoutineContent> implements ISmallRoutineContentService {

    @Override
    public SmallRoutineContent getSmallRoutineContentByTitle(String title) {
        QueryWrapper<SmallRoutineContent> wrapper = new QueryWrapper<>();
        wrapper.eq("title", title);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<SmallRoutineContent> listRoutineContentInfo(String title, String content, String appid) {

        QueryWrapper<SmallRoutineContent> wrapper = new QueryWrapper<>();
        if (title != null && title != "") {
            wrapper.like("title", title);
        }

        if (content != null && content != "") {
            wrapper.like("content", content);

        }
        if (appid != null && appid != "") {
            wrapper.eq("appid", appid);

        }
        wrapper.eq("status",0);
        wrapper.orderByDesc("update_date");
        return baseMapper.selectList(wrapper);

    }

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return smallRoutineContentMapper.doRemoveeIds(arr);
    }
}
