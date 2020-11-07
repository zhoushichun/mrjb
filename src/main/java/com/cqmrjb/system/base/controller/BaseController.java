
package com.cqmrjb.system.base.controller;

import com.cqmrjb.common.exception.MException;
import com.cqmrjb.system.controller.SmallRoutineInfoController;
import com.cqmrjb.system.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BaseController {

    /**
     * ======================public引入类放在这里======================
     */
    @Autowired
    public IUserInfoService userInfoService;

    @Autowired
    public ISmallRoutineInfoService smallRoutineInfoService;

    @Autowired
    public ISmallRoutineContentService smallRoutineContentService;

    @Autowired
    public IFileInfoService fileInfoService;

    @Autowired
    public IBookingOrderService bookingOrderService;

    @Autowired
    public IFileAppidService fileAppidService;

    @Autowired
    public IElectricTypeInfoService electricTypeInfoService;

    @Autowired
    public IServiceTypeInfoService serviceTypeInfoService;

    @Autowired
    public SmallRoutineInfoController smallRoutineInfoController;

    @Autowired
    public  IElectricServiceService electricServiceService;
    @Autowired
    public IElectricSmallRoutineService electricSmallRoutineService;


    public void isOption() throws MException {

        //可以写全局控制
    }


}
