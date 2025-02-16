package com.mrflowjavacode.africa.data.repository;

import com.mrflowjavacode.africa.data.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private List<Users> listOfUsers = new ArrayList<>();
    @Override
    public void save(Users user) {
        if (user == null){
            throw new RuntimeException("User is null");
        }
        listOfUsers.add(user);
    }

    @Override
    public void delete(Users user) {
        if(user == null){
            throw new RuntimeException("User is null");
        }
        listOfUsers.remove(user);

    }

    @Override
    public Users findById(int id) {
        for (Users users: listOfUsers){
            if(users.getId() == id){
                return users;
            }
        }
        return null;
    }

    @Override
    public List<Users> findAll() {
        return new ArrayList<>(listOfUsers);
    }
}
