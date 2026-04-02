package com.example.demo.controller;

import com.example.demo.model.JwtUtil;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        // ADMIN login
        if ("admin".equals(user.getUsername()) &&
                "1234".equals(user.getPassword())) {

            return jwtUtil.generateToken(user.getUsername(), "ADMIN");
        }

        // USER login
        if ("user".equals(user.getUsername()) &&
                "1234".equals(user.getPassword())) {

            return jwtUtil.generateToken(user.getUsername(), "USER");
        }

        throw new RuntimeException("Invalid credentials");
    }
}