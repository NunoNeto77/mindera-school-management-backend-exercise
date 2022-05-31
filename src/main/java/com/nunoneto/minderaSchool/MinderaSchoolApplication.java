package com.nunoneto.minderaSchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class })
public class MinderaSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinderaSchoolApplication.class, args);
	}

}
