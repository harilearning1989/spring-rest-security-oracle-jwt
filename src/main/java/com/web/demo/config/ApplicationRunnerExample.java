package com.web.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunnerExample implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunnerExample is running...");

        System.out.println("Option names: " + args.getOptionNames());
        if (args.containsOption("name")) {
            System.out.println("Name: " + args.getOptionValues("name"));
        }
    }
}
