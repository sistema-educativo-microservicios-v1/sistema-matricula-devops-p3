package com.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.sistema")
public class MatriculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculasApplication.class, args);
	}

}
