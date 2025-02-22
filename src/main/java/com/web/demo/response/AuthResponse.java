package com.web.demo.response;

import java.util.Set;

public record AuthResponse(
        String token,
        String username,
        Set<String> roles,
        Integer statusCode
) {
}
