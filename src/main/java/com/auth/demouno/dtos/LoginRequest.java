package com.auth.demouno.dtos;

public record LoginRequest(
    String username,
    String password
) {}