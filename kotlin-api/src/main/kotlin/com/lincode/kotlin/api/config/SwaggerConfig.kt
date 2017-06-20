package com.lincode.kotlin.api.config

import com.google.common.collect.Lists.newArrayList
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import org.springframework.web.servlet.mvc.method.RequestMappingInfo.paths
import springfox.documentation.service.ApiInfo
import springfox.documentation.builders.ResponseMessageBuilder
import springfox.documentation.schema.ModelRef
import org.springframework.web.bind.annotation.RequestMethod





@Configuration
@EnableSwagger2
open class SwaggerConfig {
    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/v1/**/*"))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
    }

    private fun apiInfo() = ApiInfo(
                "Kotlin Test API",
                "REST API to test Swagger Docs.",
                "v1.0.1",
                "Terms of service",
                "fernando@zup.com.br",
                "License of API",
                "http://google.com/license")
}