package com.sivalabs.javalibs.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "fullName", source = "name")
    @Mapping(target = "emailAddress", source = "email")
    UserDTO toUserDTO(User user);

}
