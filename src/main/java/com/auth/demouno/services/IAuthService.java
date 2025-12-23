package com.auth.demouno.services;

import com.auth.demouno.dtos.LoginRequest;
import com.auth.demouno.dtos.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest request);
}
