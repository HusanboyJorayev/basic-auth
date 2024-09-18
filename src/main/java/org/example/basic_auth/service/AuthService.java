package org.example.basic_auth.service;

import org.example.basic_auth.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public interface AuthService {
    String register(UserRequest request);

}
