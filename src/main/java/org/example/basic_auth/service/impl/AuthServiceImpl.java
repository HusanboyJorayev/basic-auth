package org.example.basic_auth.service.impl;

import org.example.basic_auth.entity.Role;
import org.example.basic_auth.entity.User;
import org.example.basic_auth.mapper.UserMapper;
import org.example.basic_auth.repository.UserRepository;
import org.example.basic_auth.request.UserRequest;
import org.example.basic_auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper userMapper,
                           UserDetailsManager userDetailsManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }


    @Override
    public String register(UserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return "USER ALREADY EXISTS";
        }
        User user = this.userMapper.toUser(request);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return "USER REGISTERED";
    }
}
