package com.cprm.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userDetailsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cprm.userservice"))
/*              .paths(regex("/userDetails.*"))
                .paths(regex("/users.*"))
                .paths(regex("/error.*"))*/
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        ApiInfo apiInfo = new ApiInfo(
                "User Details REST API",
                "User Details REST API for get User Information",
                "1.0",
                "Terms Of Service",
                new Contact("RegithKumar Chinnapandiyan",
                        "https://regith/cprm/userDetails",
                        "regith@gmail.com"),
                        "User Details Licence Version 1.0",
                        "https://www.apache.org/licenses/LICENSE-2.0");

        return apiInfo;
    }
}
