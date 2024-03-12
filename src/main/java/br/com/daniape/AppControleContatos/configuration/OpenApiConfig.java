package br.com.daniape.AppControleContatos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("bearerAuth", 
								new SecurityScheme().type(SecurityScheme.Type.HTTP)
									.scheme("bearer").bearerFormat("JWt")))
				.info(new Info()
						.title("App de cadastro de pessoas e contatos")
						.description("Este aplicativo faz cadastro de pessoas e"
								+ "seus respectivos contatos.")
						.contact(new Contact()
									.name("Daniel Antonio Pereira")
									.email("dantsp@gmail.com")
									.url("http://localhost")
								)
						.version("Versão 0.0.1-SNAPSHOT")
				)
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}	
	
}