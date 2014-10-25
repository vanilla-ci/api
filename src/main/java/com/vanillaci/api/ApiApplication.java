package com.vanillaci.api;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

/**
 * @author Joel Johnson
 */
@Configuration
@ComponentScan("com.vanillaci.api")
@EnableAutoConfiguration
public class ApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
