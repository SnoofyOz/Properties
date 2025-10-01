package com.flrtt.exp.repository.database.user;


import com.flrtt.exp.dto.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    UserEntity toEntity(User userDTO);
    User toDTO(UserEntity userEntity);
}
