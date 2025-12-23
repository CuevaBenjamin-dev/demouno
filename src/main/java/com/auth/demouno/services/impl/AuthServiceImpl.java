package com.auth.demouno.services.impl;

import org.springframework.stereotype.Service;

import com.auth.demouno.dtos.LoginRequest;
import com.auth.demouno.dtos.LoginResponse;
import com.auth.demouno.repositories.UsuarioRepository;
import com.auth.demouno.services.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponse login(LoginRequest request) {

        var usuario = usuarioRepository.findByUsernameAndPassword(
                request.username(),
                request.password());

        if (usuario.isPresent()) {
            return new LoginResponse(true, "Login correcto");
        }

        return new LoginResponse(false, "Credenciales incorrectas");
    }
}
