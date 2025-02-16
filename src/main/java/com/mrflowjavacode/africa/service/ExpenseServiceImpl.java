package com.mrflowjavacode.africa.service;

import com.mrflowjavacode.africa.data.model.Expenses;
import com.mrflowjavacode.africa.data.repository.ExpenseRepository;
import com.mrflowjavacode.africa.data.repository.ExpenseRepositoryImpl;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository = new ExpenseRepositoryImpl();

    @Override
    public Expenses addExpense(Expenses expenses) {
        validateAmount(expenses.getAmount());
        return expenseRepository.save(expenses);
    }

    @Override
    public int calculateTotalExpense() {
        int total = 0;
        for (Expenses expense: expenseRepository.findAll()){
            total += expense.getAmount();
        }
        return total;
    }

    @Override
    public void deleteExpense(Expenses expense) {
        expenseRepository.delete(expense);
    }


    @Override
    public List<Expenses> expenseList() {
        return expenseRepository.findAll();
    }

    @Override
    public String generateReport() {
        List<Expenses> expenseList = expenseRepository.findAll();
        int calculatedAmount = calculateTotalExpense();
        if (expenseList.isEmpty()) return "No expenses found";
        StringBuilder report = new StringBuilder();
        report.append  ("Expenses: Report \n");
        report.append("===================\n\n");
        report.append("Customer expense:\n");
        for (Expenses expense : expenseList) {
            report.append(String.format("%s - %s (%s): %d\n",
                    expense.getExpenseId(),
                    expense.getExpenseDescription(),
                    expense.getExpenseCategory(),
                    expense.getAmount()));
        }
        report.append(String.format("\nTotal expense: %d\n", calculatedAmount));
        return report.toString();
    }
    private void validateAmount(int amount) {
        if (amount <= 0) throw new RuntimeException("Invalid amount");
    }
}
