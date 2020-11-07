package com.cqmrjb.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类（controller包路径），才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.cqmrjb.system.controller"))
                .paths(PathSelectors.any())
                .build()
                //配置swagger全局配置
                .securitySchemes(security());
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("空调维修")
                //描述
                .description("接口文档")
//                .termsOfServiceUrl("http://localhost:8500/")
                //创建人
//                .contact(new Contact("FuRao", "", ""))
                //版本号
                .version("1.0")
                .build();
    }


    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey("Authorization", "Authorization", "header")
        );
    }
}
