package com.flrtt.exp.domain.user;

public record User(
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
