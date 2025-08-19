package com.web.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class SpringRestApplication {
	//-Xms256m -Xmx512m -XX:+UseG1GC

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}
