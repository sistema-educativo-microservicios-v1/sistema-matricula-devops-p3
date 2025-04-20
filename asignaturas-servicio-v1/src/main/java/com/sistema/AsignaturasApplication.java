package com.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.sistema")
@EnableFeignClients(basePackages = "com.sistema")
public class AsignaturasApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsignaturasApplication.class, args);
	}
}
