package com.sivalabs.javalibs.mapstruct;


import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {


    @Test
    void shouldMapUserToUserDTO() {
        User user = new User(1L, "Siva", "siva@gmail.com", "secret");
        UserDTO userDTO = UserMapper.INSTANCE.toUserDTO(user);

        assertAll(
            () -> assertEquals(user.id(), userDTO.id()),
            () -> assertEquals(user.name(), userDTO.fullName()),
            () -> assertEquals(user.email(), userDTO.emailAddress())
        );
    }
}