package com.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	/**
	@Bean
	public Docket swaggerConfiguration () {
		
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.ant("/myapp"))
					.apis(RequestHandlerSelectors.basePackage("com.assignment.controller"))
					.build()
					.apiInfo(appDetails());
	} */
	
	@SuppressWarnings("deprecation")
	public ApiInfo appDetails() {
		return new ApiInfo(
				"Spring Rest API",
				"Spring Boot, Rest API, Security, Swagger UI",
				"1.0",
				"Free to use",
				"",
				"API License",
				"http://test.com" );
	}
}
