package com.web.demo.dtos;

import java.util.Set;

public record UserRequestDto(String username,
                             String password,
                             Set<String> roles
) {
}
