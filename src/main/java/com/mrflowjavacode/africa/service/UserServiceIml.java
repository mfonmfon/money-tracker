package com.mrflowjavacode.africa.service;

import com.mrflowjavacode.africa.data.model.Users;
import com.mrflowjavacode.africa.data.repository.UserRepository;
import com.mrflowjavacode.africa.data.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceIml implements UserService {
    private static final UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public Users createUserAccount(Users user) {
        validateEmail(user.getEmail());
        return userRepository.save(user);
    }
    private void validateEmail(String email) {
        boolean isEmailValid = userRepository.findUserByEmail(email);
        if (isEmailValid) {
            throw new IllegalArgumentException("Email already exists.");
        }
    }
    @Override
    public Users login(String email, String password) {
        System.out.println("Logging in user: " + email);
        Users user = userRepository.findByEmail(email.toLowerCase());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (user.getPassword().isEmpty()) {
            throw new RuntimeException("Invalid password");
        }

        user.setLoggedIn(true);
        return userRepository.save(user);
    }
    @Override
    public void logOut() {
       for (Users user : userRepository.findAll()) {
           user.setLoggedIn(false);
           userRepository.save(user);
       }
    }
    @Override
    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email.toLowerCase());
    }

    @Override
    public Users updateUser(Users user) {
        return null;
    }

    @Override
    public void deleteUser(Users user) {
        userRepository.delete(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
