package com.example.EnglishApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository <Users, Integer> {

    @Procedure(name = "Users.GetAllUsers")
    List<Users> GetAllUsers();

    @Procedure(name = "Users.GetUsersById")
    Users GetUsersById(@Param("uUserId") Integer UserId);

    @Procedure(name = "Users.InsertUsers")
    Users InsertUsers(
        @Param("uName") String Name,
        @Param("uEmail") String Email,
        @Param("uPhone") String Phone,
        @Param("uusername") String username,
        @Param("upassword_hash") String upassword_hash
    );

    @Procedure(name = "Users.UpdateUsers")
    Users UpdateUsers(
        @Param("uUserId") Integer UserId ,
        @Param("uName") String Name,
        @Param("uEmail") String Email,
        @Param("uPhone") String Phone,
        @Param("uusername") String username,
        @Param("upassword_hash") String upassword_hash
    );
   
}
