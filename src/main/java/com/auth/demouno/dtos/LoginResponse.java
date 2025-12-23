package com.auth.demouno.dtos;

public record LoginResponse(
    boolean success,
    String message
) {}
