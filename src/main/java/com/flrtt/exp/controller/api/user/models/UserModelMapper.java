package com.flrtt.exp.controller.api.user.models;


import com.flrtt.exp.dto.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserModelMapper {
    UserResponse toModels(User user);
    User toDto(UserRequest request);

}
