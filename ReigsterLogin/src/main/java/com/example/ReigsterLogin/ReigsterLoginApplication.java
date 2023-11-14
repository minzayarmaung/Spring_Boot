package com.example.ReigsterLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class ReigsterLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReigsterLoginApplication.class, args);
	}

}
