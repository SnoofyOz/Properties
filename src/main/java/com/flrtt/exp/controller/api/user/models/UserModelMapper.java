package com.flrtt.exp.controller.api.user.models;


import com.flrtt.exp.dto.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserModelMapper {
    @Mapping(target = "id", source = "id")
    UserResponse toModels(User user);
    User toDto(UserRequest request);
}
