package com.escuelita.clase1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
public class SpringFoxConfig {
	/**
     * Publish a bean to generate swagger2 endpoints
     * @return a swagger configuration bean
     */
    @Bean
    public Docket usersApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(usersApiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.escuelita.clase1.controller"))
                .build()
                .useDefaultResponseMessages(false);
    }

   private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("Api Escuelita")
                .version("1.0")
                .license("Apache License Version 2.0")
                .build();
    }
}
