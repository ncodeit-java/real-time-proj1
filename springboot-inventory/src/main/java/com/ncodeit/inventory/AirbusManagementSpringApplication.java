package com.ncodeit.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Inventory Management API", version = "2.0",description = "API's related to inventory system"),
		servers = {@Server(url = "localhost:8080")}
		)
@SecurityScheme(
		name = "Bearer",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer",
		description = "JWT Bearer"
		)
public class AirbusManagementSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbusManagementSpringApplication.class, args);
	}

}
