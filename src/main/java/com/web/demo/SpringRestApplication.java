package com.web.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class SpringRestApplication implements CommandLineRunner {
	//-Xms256m -Xmx512m -XX:+UseG1GC

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//List<Object> list = new ArrayList<>();
		//while (true) {
		//	list.add(new byte[1024 * 1024]); // Allocate 1MB blocks
		//}
	}
}
