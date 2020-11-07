package com.cqmrjb.common.config.corsConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * AJAX请求跨域
 * @author Mr.W
 * @time 2018-08-13
 */
@Configuration
//public class CorsConfig {
    public class CorsConfig  implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedOrigins("*")
                    .allowedHeaders("*")
                    .allowedMethods("*")
                    .maxAge(30*1000);
    }


//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        //  你需要跨域的地址  注意这里的 127.0.0.1 != localhost
//        // * 表示对所有的地址都可以访问
//        corsConfiguration.addAllowedOrigin("*");
//        //  跨域的请求头
//        corsConfiguration.addAllowedHeader("*"); // 2
//        //  跨域的请求方法
//        corsConfiguration.addAllowedMethod("*"); // 3
//        //加上了这一句，大致意思是可以携带 cookie
//        //最终的结果是可以 在跨域请求的时候获取同一个 session
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        //配置 可以访问的地址
//        source.registerCorsConfiguration("/**", buildConfig()); // 4
//        return new CorsFilter(source);
//    }

}