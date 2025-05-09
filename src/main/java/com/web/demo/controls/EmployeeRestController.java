package com.web.demo.controls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping
    public String helloWorld(){
        LOGGER.info("EmployeeRestController helloWorld::::::::");
        return "Hello World";
    }
}
