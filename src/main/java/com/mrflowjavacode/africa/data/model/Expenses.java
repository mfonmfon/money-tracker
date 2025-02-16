package com.mrflowjavacode.africa.data.model;

import java.time.LocalDateTime;

public class Expenses {
    private int expenseId;
    private String expenseDescription;
    private int amount;
    private String expenseCategory;
    private LocalDateTime timeStamp;



    public Expenses(int expenseId, String expenseDescription, int amount, String expenseCategory, LocalDateTime timeStamp) {
        this.expenseId = expenseId;
        this.expenseDescription = expenseDescription;
        this.amount = amount;
        this.expenseCategory = expenseCategory;
        this.timeStamp = timeStamp;

    }

    public Expenses() {}





    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getExpenseId(String expenseId) {
        return expenseId;
   }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }
}
