package com.example.ecoleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EcoleApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcoleApiApplication.class, args);
	}

}
