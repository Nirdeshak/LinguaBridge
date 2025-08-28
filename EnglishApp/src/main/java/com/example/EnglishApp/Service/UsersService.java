package com.example.EnglishApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishApp.entity.Users;
import com.example.EnglishApp.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public List<Users> GetAllUsers() {
        return usersRepository.GetAllUsers();
    }

    @Transactional
    public Users GetUsersById(Integer UserId) {
        return usersRepository.GetUsersById(UserId);
    }

    @Transactional
    public Users InsertUsers(Users users) {
        return usersRepository.InsertUsers(
            users.getName(),
            users.getEmail(),
            users.getPhone(),
            users.getUsername(),
            users.getPassword_hash()
        );
    }

    @Transactional
    public Users UpdateUsers( Integer userId, Users users) {
        return usersRepository.UpdateUsers(
            users.getUserid(),
            users.getName(),
            users.getEmail(),
            users.getPhone(),
            users.getUsername(),
            users.getPassword_hash()
        );
    }

}

