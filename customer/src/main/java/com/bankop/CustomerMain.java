package com.bankop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerMain {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMain.class, args);
	}
	@Bean
	public RestTemplate getResttemplateBean() {
		return new RestTemplate();
	}
}
