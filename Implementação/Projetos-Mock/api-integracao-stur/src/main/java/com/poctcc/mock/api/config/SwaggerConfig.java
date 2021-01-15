package com.poctcc.mock.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title("API de Integração STUR")
				.description("POC para apresentação de Trabalho de Conclusão do Curso (TCC) para a PUC Minas Virtual, curso Arquitetura de Software Distribuído")
				.version("1.0")
				.contact(new Contact("Everton Cezar Gonçalves e Jeferson Job Ribeiro dos Santos", "", ""))
				.build();
	}

}
