package com.flrtt.exp.repository.database.user;


import com.flrtt.exp.bootstrap.mapper.MapStructGlobalConfig;
import com.flrtt.exp.dto.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructGlobalConfig.class)
public interface UserEntityMapper{
    @Mapping(source = "userId" , target = "userId")
    User toDto(UserEntity entity);
    @Mapping(source = "userId" , target = "userId")
    UserEntity toEntity(User dto);
}
