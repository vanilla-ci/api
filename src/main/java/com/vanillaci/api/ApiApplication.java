package com.vanillaci.api;

import com.fasterxml.jackson.databind.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;

/**
 * @author Joel Johnson
 */
@Configuration
@ComponentScan("com.vanillaci.api")
@EnableAutoConfiguration
@EnableJpaRepositories
public class ApiApplication {
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
