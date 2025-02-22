package com.web.demo.dtos;

public record LoginRequest(
        String username,
        String password
) {
}
