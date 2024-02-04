package com.binaryBookShop.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan // Loads configuration data beans in the Spring context
public class CatalogServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
