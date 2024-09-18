package org.example.basic_auth.controller;

import lombok.RequiredArgsConstructor;
import org.example.basic_auth.request.UserRequest;
import org.example.basic_auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/")
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest request) {
        String register = this.authService.register(request);
        return ResponseEntity.ok(register);
    }

}
