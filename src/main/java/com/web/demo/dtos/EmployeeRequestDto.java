package com.web.demo.dtos;

import java.util.Set;

public record EmployeeRequestDto(String username,
                                 String password,
                                 Set<String> roles
) {
}
