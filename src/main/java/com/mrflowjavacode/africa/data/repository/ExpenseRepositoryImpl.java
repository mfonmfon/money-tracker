package com.mrflowjavacode.africa.data.repository;

import com.mrflowjavacode.africa.data.model.Expenses;

import java.util.*;

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
    public void delete(Expenses expenses) {
        for (Expenses expense : expensesList) {
            if(expense.equals(expenses)){
                expensesList.remove(expenses);
                break;
            }
        }
    }

    @Override
    public Expenses findById(int id) {
        for(Expenses expense : expensesList){
            if(expense.getExpenseId() == id){
                return expense;
            }
        }
        return null;

    }

    @Override
    public List<Expenses> findAll() {
        return new ArrayList<>(expensesList);
    }
}
