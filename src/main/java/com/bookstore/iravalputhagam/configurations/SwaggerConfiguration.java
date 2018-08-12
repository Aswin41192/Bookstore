package com.bookstore.iravalputhagam.configurations;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.iravalputhagam.constants.AppConstants;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket getSwaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bookstore.iravalputhagam.services")).build()
				.apiInfo(getApiInfo())
				;
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(AppConstants.SWAGGER_API_TITLE, AppConstants.SWAGGER_API_DESCRIPTION,
				AppConstants.SWAGGER_API_VERSION, AppConstants.SWAGGER_API_SERVICE_URL,
				new Contact(AppConstants.SWAGGER_API_CONTACT_NAME, "", AppConstants.SWAGGER_API_CONTACT_NAME), "", "",
				Collections.emptyList()
				);
			}
}
