package com.jaws.backendencuestajaws;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.jaws.backendencuestajaws.controllers"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
			"RestApi EncuestaApp",
			"Servicios Rest para proyecto Final JAWS",
			"API ToS",
			"Terms of services",
			new Contact("nekrapula@gmail.com","https://www.facebook.com/Nekrapula","@nekrapulaOb"),
			"Licence of API", "nekrapula@gmail.com", Collections.emptyList()
		);
	}
	

}
