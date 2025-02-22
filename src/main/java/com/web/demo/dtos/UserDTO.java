package com.web.demo.dtos;

import java.util.List;

public record UserDTO(Long id, String username, List<RoleDTO> list) {
}
