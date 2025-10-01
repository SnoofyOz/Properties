package com.flrtt.exp.controller.api.authentication.models;

public record AuthRequest(
        String username,
        String password
) {
}
