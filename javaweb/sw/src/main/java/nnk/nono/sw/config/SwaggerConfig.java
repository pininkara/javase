// 2022/2/21 16:07

package nnk.nono.sw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    @Bean
    //配置Swagger的Bean实例
    public Docket docket(Environment environment){
        //获取项目环境
        Profiles profile=Profiles.of("dev","test");
        boolean flag = environment.acceptsProfiles(profile);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
                //.select()
                //RequestHandlerSelectors：配置要扫描的接口的方式
                //basePackage：指定要扫描的包
                //any扫描全部，none不扫描
                //withClassAnnotation：扫描类上的注解
                //.apis(RequestHandlerSelectors.basePackage("nnk.nono.sw.controller"))
                //.build();
    }


    //配置Swagger信息
    private ApiInfo apiInfo(){

        Contact contact=new Contact("捏捏卡","wsunsettide.ltd","");

        return new ApiInfo("捏捏卡的文档",
                "捏捏卡",
                "1.9",
                "wsunsettide.ltd",
                "contact",
                "Apache 2.0",
                "www.baidu.com");
    }
}
