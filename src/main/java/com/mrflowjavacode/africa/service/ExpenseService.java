package com.mrflowjavacode.africa.service;

import com.mrflowjavacode.africa.data.model.Expenses;

import java.util.List;

public interface ExpenseService {
    Expenses addExpense(Expenses expenses);

    int calculateTotalExpense();

    void deleteExpense(Expenses expense);

    List<Expenses> expenseList();

    String generateReport();

    Expenses getExpensesById(int id);
}
