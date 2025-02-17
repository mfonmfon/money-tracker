package com.mrflowjavacode.africa.data.repository;

import com.mrflowjavacode.africa.data.model.Users;

import java.util.List;

public interface UserRepository {
    Users save(Users user);
    void delete(Users user);
    Users findById(int id);
    List<Users> findAll();

    Users findByEmail(String email);

    boolean findUserByEmail(String email);

}
