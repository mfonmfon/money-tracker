package com.mrflowjavacode.africa.data.repository;

import com.mrflowjavacode.africa.data.model.Expenses;

import java.util.List;

public interface ExpenseRepository {
    Expenses save(Expenses expense);
    void delete(Expenses expense);
    Expenses findById(int id);
    List<Expenses> findAll();

}
