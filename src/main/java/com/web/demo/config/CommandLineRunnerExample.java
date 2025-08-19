package com.web.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerExample implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunnerExample is running...");
        //List<Object> list = new ArrayList<>();
        //while (true) {
        //	list.add(new byte[1024 * 1024]); // Allocate 1MB blocks
        //}
        for (String arg : args) {
            System.out.println("Arg: " + arg);
        }
    }
}
