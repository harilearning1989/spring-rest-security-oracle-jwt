package com.web.demo.services;

import com.web.demo.dtos.EmployeeRequestDto;
import com.web.demo.models.Role;
import com.web.demo.models.Users;
import com.web.demo.repos.RoleRepository;
import com.web.demo.repos.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Users getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Transactional
    public Users saveUsers(Users users) {
        return userRepository.save(users);
    }

    @Override
    public String registerUser(EmployeeRequestDto dto) {
        Users users = new Users();
        users.setUsername(dto.username());
        users.setPassword(passwordEncoder.encode(dto.password()));

        /*Set<Role> roles = new HashSet<>();
        String role_name = "ROLE_EMPLOYEE";
        Role role = roleRepository.findByName(role_name)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(role);

        users.setRoles(roles);*/

        Set<Role> roles = new HashSet<>();
        for (String roleName : Arrays.asList("ROLE_ADMIN", "ROLE_EMPLOYEE")) {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            roles.add(role);
        }

        // Assign roles to the user
        users.setRoles(roles);

        users = userRepository.save(users);

        //Employee employee = dataMappers.toEmployee(dto, users);
        //employee = employeeRepository.save(employee);
        //return dataMappers.toDto(users, employee);
        return users.getUsername();
    }
}
