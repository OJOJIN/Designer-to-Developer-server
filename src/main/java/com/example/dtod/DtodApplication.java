package com.example.dtod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DtodApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtodApplication.class, args);
	}

}
