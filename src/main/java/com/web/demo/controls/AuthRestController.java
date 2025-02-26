package com.web.demo.controls;

import com.web.demo.dtos.UserRequestDto;
import com.web.demo.dtos.LoginRequest;
import com.web.demo.models.Users;
import com.web.demo.response.AuthResponse;
import com.web.demo.response.GlobalResponse;
import com.web.demo.response.ResponseHandler;
import com.web.demo.services.UserService;
import com.web.demo.utils.JwtTokenProvider;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthRestController.class);

    private static final String USER = "User";
    private static final String REGISTER_SUCCESS = "Successfully Registered %s with the Name: %s ";

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthRestController(AuthenticationManager authenticationManager,
                              JwtTokenProvider jwtTokenProvider,
                              UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/register")
    public GlobalResponse registerUser(
            @Valid @RequestBody UserRequestDto userDto) {
        LOGGER.info("The request entered into registerEmployee with the userId::{}", userDto.username());
        String username = userService.registerUser(userDto);
        return ResponseHandler.generateResponse(
                String.format(REGISTER_SUCCESS, USER, userDto.username()), HttpStatus.OK, username);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Extract roles
        Set<String> roles = authentication.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .collect(Collectors.toSet());
        // Generate JWT token with roles
        String token = jwtTokenProvider.generateToken(loginRequest.username(), roles);
        // Get roles from the JWT
        // String roles = jwtTokenProvider.getRolesFromJWT(jwt);

        return ResponseHandler.getAuthResponse(token, HttpStatus.OK, loginRequest.username(), roles);
    }

   /* @GetMapping("allUsers")
    public GlobalResponse getAllUsers(){
        List<Users> usersList = userService.getAllUsers();
        return ResponseHandler.generateResponse("Fetched User Details Successfully", HttpStatus.OK, usersList);
    }*/
}
