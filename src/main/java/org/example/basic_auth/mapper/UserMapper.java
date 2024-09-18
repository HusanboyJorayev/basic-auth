package org.example.basic_auth.mapper;

import org.example.basic_auth.entity.User;
import org.example.basic_auth.request.UserRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "role")
    User toUser(UserRequest request);

    @AfterMapping
    default void setPassword(UserRequest request, @MappingTarget User user, PasswordEncoder passwordEncoder) {
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
    }
}
