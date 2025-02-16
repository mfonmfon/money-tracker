package com.mrflowjavacode.africa.service;

import com.mrflowjavacode.africa.data.enums.ExpenseCategory;
import com.mrflowjavacode.africa.data.model.Expenses;
import com.mrflowjavacode.africa.data.repository.ExpenseRepository;
import com.mrflowjavacode.africa.data.repository.ExpenseRepositoryImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

public class ExpenseServiceTest extends TestCase {
    private final ExpenseRepository expenseRepository = new ExpenseRepositoryImpl();
    private final ExpenseService expenseService = new ExpenseServiceImpl();

    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testThatCanAddExpense() {
        Expenses expenses = new Expenses();
        expenses.setAmount(500);
        expenses.setExpenseCategory(ExpenseCategory.CLOTHING);
        expenses.setExpenseDescription("Bought the 5 clothes today");
        expenses.setTimeStamp(LocalDateTime.now());
        Expenses savedExpense =  expenseService.addExpense(expenses);
        assertNotNull(savedExpense);
    }
    @Test
    public void testThatCanGetExpensesByCalculated() {
        Expenses firstExpense = new Expenses();
        firstExpense.setAmount(500);
        firstExpense.setExpenseCategory(ExpenseCategory.CLOTHING);
        firstExpense.setTimeStamp(LocalDateTime.now());
        expenseService.addExpense(firstExpense);

        Expenses secondExpense = new Expenses();
        secondExpense.setAmount(200);
        secondExpense.setExpenseCategory(ExpenseCategory.FOOD);
        firstExpense.setTimeStamp(LocalDateTime.now());
        expenseService.addExpense(secondExpense);

        Expenses thirdExpense = new Expenses();
        thirdExpense.setAmount(700);
        thirdExpense.setExpenseCategory(ExpenseCategory.TRANSPORTATION);
        firstExpense.setTimeStamp(LocalDateTime.now());
        expenseService.addExpense(thirdExpense);
        int totalCalculatedExpense = expenseService.calculateTotalExpense();
        assertEquals(1400,totalCalculatedExpense);
    }


    @Test
    public void testThatCanDeleteExpense() {
        Expenses expenses = new Expenses();
        expenses.setExpenseId(expenses.getExpenseId());
        expenseService.deleteExpense(expenses);
        assertNotNull(expenses);
    }
}