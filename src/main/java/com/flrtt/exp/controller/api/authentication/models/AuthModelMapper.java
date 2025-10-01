package com.flrtt.exp.controller.api.authentication.models;

import com.flrtt.exp.dto.authentication.Auth;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthModelMapper {
    AuthRequest toModels(Auth auth);
    Auth toDto(AuthRequest request);
}
