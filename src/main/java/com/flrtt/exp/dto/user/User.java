package com.flrtt.exp.dto.user;

public record User(
        String userId,
        String username,
        String password,
        String role,
        String property,
        String propertyId,
        String portal
) {
}
