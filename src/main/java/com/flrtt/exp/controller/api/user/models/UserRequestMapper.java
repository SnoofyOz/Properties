package com.flrtt.exp.controller.api.user.models;


import com.flrtt.exp.bootstrap.mapper.MapStructGlobalConfig;
import com.flrtt.exp.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructGlobalConfig.class)
public interface UserRequestMapper {
    @Mapping(target = "username", source = "username")
    UserRequest toModels(User user);
    User toDto(UserRequest request);
}
