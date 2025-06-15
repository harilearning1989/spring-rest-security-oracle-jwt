package com.web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringRestApplication {
	//-Xms256m -Xmx512m -XX:+UseG1GC

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}
