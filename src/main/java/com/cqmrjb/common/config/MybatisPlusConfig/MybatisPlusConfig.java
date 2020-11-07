package com.cqmrjb.common.config.MybatisPlusConfig;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MybatisPlusConfig {

    /**
     * @throws
     * @Title: plus 的性能优化
     * @Description: <p>设置 dev test local 环境开启</p>
     * @author: zhoushichun
     * @date: 2020/10/28 14.50
     * @param:
     * @return:
     */
    @Profile({"dev", "test", "local"})
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
//        performanceInterceptor.setMaxTime(2000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }


    /**
     * @throws
     * @Title: mybatis-plus分页插件
     * @Description: <p></p>
     * @author: zhoushichun
     * @date: 2020/10/28 14.50
     * @param:
     * @return:
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    /**
     * @throws
     * @Title: 逻辑删除
     * @Description: <p></p>
     * @author: zhoushichun
     * @date: 2020/10/28 14.50
     * @param:
     * @return:
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * @throws
     * @Title: 乐观锁
     * @Description: <p></p>
     * @author: zhoushichun
     * @date: 2020/10/28 14.50
     * @param:
     * @return:
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}

