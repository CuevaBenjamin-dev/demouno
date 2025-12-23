package com.auth.demouno.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demouno.dtos.LoginRequest;
import com.auth.demouno.dtos.LoginResponse;
import com.auth.demouno.services.IAuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // SOLO PARA DESARROLLO
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
