package com.cqmrjb.system.mapper;

import com.cqmrjb.system.entity.ElectricService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ElectricServiceMapper extends BaseMapper<ElectricService> {

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


    List<ElectricService> listElectricService(@Param("appid") String appid, @Param("electricType")String electricType,@Param("serviceType") String serviceType);
}
