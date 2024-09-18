package org.example.basic_auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/admin")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public String admin() {
        return "HELLO CONTROLLER";
    }

    @GetMapping("/all")
    public String all() {
        return "HELLO CONTROLLER";
    }
}
