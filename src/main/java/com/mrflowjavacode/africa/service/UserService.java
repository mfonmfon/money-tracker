package com.mrflowjavacode.africa.service;

import com.mrflowjavacode.africa.data.model.Users;

import java.util.List;

public interface UserService {
    Users createUserAccount(Users user);
    Users login(String email, String password);
    void logOut();
    Users findUserByEmail(String email);
    Users updateUser(Users user);
    void deleteUser(Users user);
    List<Users> getAllUsers();
}
