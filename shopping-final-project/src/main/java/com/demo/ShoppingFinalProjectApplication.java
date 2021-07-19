package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com")
public class ShoppingFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingFinalProjectApplication.class, args);
	}

	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
