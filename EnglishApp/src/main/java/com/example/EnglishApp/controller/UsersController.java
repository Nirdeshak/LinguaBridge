package com.example.EnglishApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.UsersService;
import com.example.EnglishApp.entity.Users;



@Controller
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/GetAllUsers")
    public List<Users> GetAllUsers() {
        return usersService.GetAllUsers();
    }

    @GetMapping("/GetUsersById/{id}")
    public Users GetUsersById(@PathVariable("id") Integer UserId) {
        return usersService.GetUsersById(UserId);
    }

    @PostMapping("InsertUsers")
    public ResponseEntity <String> InsertUsers(@RequestBody Users user) {
        usersService.InsertUsers(user);
        return ResponseEntity.ok("User created successfully");
    }
    

    @PutMapping("/UpdateUsers/{id}")
    public ResponseEntity<String> UpdateUsers(@PathVariable("id") Integer userId, @RequestBody Users user) {
        usersService.UpdateUsers(userId, user);
        return ResponseEntity.ok("User updated successfully");
    }

}
