package com.mrflowjavacode.africa.data.repository;

import com.mrflowjavacode.africa.data.model.Expenses;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepositoryImpl implements ExpenseRepository{

    private final List<Expenses> expensesList = new ArrayList<>();


    @Override
    public Expenses save(Expenses expense) {
        if (expense == null){
            throw new RuntimeException("Expense is null");
        }
        expensesList.add(expense);
        return expense;
    }

    @Override
    public void delete(Expenses expense) {
        if (expense == null) {
            throw new RuntimeException("Expense is null");
        }
        expensesList.remove(expense);
    }

    @Override
    public Expenses findById(int id) {
        for (Expenses expenses: expensesList){
            if (expenses.getExpenseId() == id){
                return expenses;
            }
        }
        return null;
    }

    @Override
    public List<Expenses> findAll() {
        return new ArrayList<>(expensesList);
    }
}
