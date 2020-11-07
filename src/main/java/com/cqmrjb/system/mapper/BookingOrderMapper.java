package com.cqmrjb.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqmrjb.system.entity.BookingOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName:预约订单 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2020-11-02
 */
@Mapper
@Repository
public interface BookingOrderMapper extends BaseMapper<BookingOrder> {

    /**
     * @throws
     * @Title: 物理批量删除
     * @Description: <p></p>
     * @author: zhou
     * @date: 2020-11-02
     * @param: int []arr = new int []{,}
     * @return: boolean
     */
    boolean doRemoveeIds(long[] arr);


    List<BookingOrder> listBookingOrder(@Param("appid") String appid,
                                        @Param("electricType") String electricType,
                                        @Param("orderSite") String orderSite,
                                        @Param("serviceType") String serviceType,
                                        @Param("phone") String phone,
                                        @Param("smallRoutineName") String smallRoutineName);
}
