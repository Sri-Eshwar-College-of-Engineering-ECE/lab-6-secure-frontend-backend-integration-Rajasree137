package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecureController {

    @GetMapping("/user")
    public String user() {
        return "Hello USER";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello ADMIN";
    }
}
