package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAssignmentApplication.class, args);
	}

}
