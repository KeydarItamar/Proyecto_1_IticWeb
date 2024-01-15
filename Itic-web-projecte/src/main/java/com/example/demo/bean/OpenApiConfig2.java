package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig2 {


@Bean
public OpenAPI openApi() {

	return new OpenAPI().info(new Info()
			.title("Api-rest de Empresa")
			.description("Api-rest que devuelve información de empresas con ofertas de empleo")
			.version("0.0.2"));
	}
}

