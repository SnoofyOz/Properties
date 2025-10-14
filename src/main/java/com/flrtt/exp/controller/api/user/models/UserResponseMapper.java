package com.flrtt.exp.controller.api.user.models;


import com.flrtt.exp.bootstrap.mapper.MapStructGlobalConfig;
import com.flrtt.exp.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructGlobalConfig.class)
public interface UserResponseMapper {
    @Mapping(target = "userId", source = "userId")
    UserResponse toModels(User user);
    User toDto(UserResponse response);
}
