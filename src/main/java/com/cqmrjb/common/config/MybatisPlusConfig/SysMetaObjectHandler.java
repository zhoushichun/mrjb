package com.cqmrjb.common.config.MybatisPlusConfig;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
@Slf4j
public class SysMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createData = getFieldValByName("createDate",metaObject);
        Object updateDate = getFieldValByName("updateDate",metaObject);
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String nowTime = sdf.format(date);//将时间格式转换成符合Timestamp要求的格式.
        Timestamp dates =Timestamp.valueOf(nowTime);//把时间转换
        if(null==createData){
            setFieldValByName("createDate",dates,metaObject);
        }
        if(null==updateDate){
            setFieldValByName("updateDate",dates,metaObject);
        }
//        Object versions = this.getFieldValByName("versions", metaObject);
//        if (null == versions){
//            this.setFieldValByName("versions", 0,metaObject);
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String nowTime = sdf.format(date);//将时间格式转换成符合Timestamp要求的格式.
        Timestamp dates =Timestamp.valueOf(nowTime);//把时间转换
        setFieldValByName("updateDate",dates,metaObject);
//        Object versions = this.getFieldValByName("versions", metaObject);
//        this.setFieldValByName("versions", versions,metaObject);
    }

}
