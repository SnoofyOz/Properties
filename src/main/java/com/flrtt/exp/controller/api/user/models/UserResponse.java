package com.flrtt.exp.controller.api.user.models;

public record UserResponse(
        String id,
        String username,
        String password,
        String role
) {
}
