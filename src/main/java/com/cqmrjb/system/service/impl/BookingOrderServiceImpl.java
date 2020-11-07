
package com.cqmrjb.system.service.impl;

import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.BookingOrder;
import com.cqmrjb.system.mapper.BookingOrderMapper;
import com.cqmrjb.system.service.IBookingOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
*
*@ClassName:预约订单 服务实现类
*@Description:
*@author: zhou
*@date 2020-11-02
*
*/
@Service
@Transactional
public class BookingOrderServiceImpl extends BaseServiceImpl<BookingOrderMapper, BookingOrder> implements IBookingOrderService {

    @Override
    public List<BookingOrder> listBookingOrder(String appid, String electricType, String orderSite, String serviceType, String phone,String smallRoutineName) {
        return bookingOrderMapper.listBookingOrder(appid,electricType,orderSite,serviceType,phone,smallRoutineName);
    }

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return bookingOrderMapper.doRemoveeIds(arr);
    }
}
