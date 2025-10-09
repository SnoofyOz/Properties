package com.flrtt.exp.controller.api.user.models;

public record UserResponse(
        String userId,
        String username,
        String password,
        String role,
        String propertyId,
        String propertyName,
        String portalId,
        String portalName
) {
}
