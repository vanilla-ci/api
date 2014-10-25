package com.vanillaci.api;

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
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
