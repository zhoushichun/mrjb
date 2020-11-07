package com.cqmrjb.system.mapper;

import com.cqmrjb.system.entity.ElectricSmallRoutine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqmrjb.system.entity.ElectricSmallRoutineVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2020-11-04
 */
@Mapper
@Repository
public interface ElectricSmallRoutineMapper extends BaseMapper<ElectricSmallRoutine> {

    /**
     * @throws
     * @Title: 物理批量删除
     * @Description: <p></p>
     * @author: zhou
     * @date: 2020-11-04
     * @param: int []arr = new int []{,}
     * @return: boolean
     */
    boolean doRemoveeIds(long[] arr);


    List<ElectricSmallRoutineVO> listElectricSmallRoutine(@Param("appid") String appid, @Param("electric")String electric);
}
