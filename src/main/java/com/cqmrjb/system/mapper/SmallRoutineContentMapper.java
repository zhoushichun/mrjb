package com.cqmrjb.system.mapper;

import com.cqmrjb.system.entity.SmallRoutineContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName:小程序内容 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2020-10-29
 */
@Mapper
@Repository
public interface SmallRoutineContentMapper extends BaseMapper<SmallRoutineContent> {

    /**
     * @throws
     * @Title: 物理批量删除
     * @Description: <p></p>
     * @author: zhou
     * @date: 2020-10-29
     * @param: int []arr = new int []{,}
     * @return: boolean
     */
    boolean doRemoveeIds(long[] arr);


    List<SmallRoutineContent> listRoutineContentInfo(@Param("title") String title, @Param("content")String content,@Param("appid") String appid);
}
