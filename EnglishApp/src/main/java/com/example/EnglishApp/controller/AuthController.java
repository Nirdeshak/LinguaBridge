// package com.example.EnglishApp.controller;

// import org.springframework.web.bind.annotation.*;

// import com.example.EnglishApp.security.JwtUtil;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final JwtUtil jwtUtil;

//     public AuthController(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/login")
//     public String login(@RequestParam String username, @RequestParam String password) {
//         if (username.equals("admin") && password.equals("1234")) {
//             return jwtUtil.generateToken(username);
//         }
//         return "Invalid credentials";
//     }
// }
