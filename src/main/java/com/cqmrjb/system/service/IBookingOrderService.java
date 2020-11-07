
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.BookingOrder;

import java.util.List;

/**
 * @ClassName:预约订单 服务类
 * @Description:
 * @author: zhou
 * @date 2020-11-02
 */
public interface IBookingOrderService extends BaseService<BookingOrder> {


    List<BookingOrder> listBookingOrder(String appid, String electricType, String orderSite, String serviceType, String phone,String smallRoutineName );

    boolean doRemoveeIds(long[] arr);
}
