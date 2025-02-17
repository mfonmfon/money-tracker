package com.mrflowjavacode.africa;

import com.mrflowjavacode.africa.data.model.Expenses;
import com.mrflowjavacode.africa.data.model.Users;
import com.mrflowjavacode.africa.service.ExpenseService;
import com.mrflowjavacode.africa.service.ExpenseServiceImpl;
import com.mrflowjavacode.africa.service.UserService;
import com.mrflowjavacode.africa.service.UserServiceIml;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final ExpenseService expenseService = new ExpenseServiceImpl();
    private static final UserService userService = new UserServiceIml();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        displayMenu();
        userAuth();
    }

    public static void userAuth(){
        String userOption = """
                Welcome to Expense Tracker Testing System
                1 -> Sign up
                2 -> Sign in
                """;
        String userChoice = JOptionPane.showInputDialog(userOption);
        switch (userChoice){
            case "1":
                signUp();
                break;
            case "2":
                signIn();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                userAuth();
                break;
        }
    }
    private static void signIn() {
        String email = JOptionPane.showInputDialog("Enter your email:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        Users user = userService.login(email, password);
        if(user!= null){
            JOptionPane.showMessageDialog(null, "Welcome back, " + user.getFirstName() + "! You are now logged in.");
            displayMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email or password. Please try again.");
            signIn();
        }
    }

    private static void signUp() {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");

        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        String email = JOptionPane.showInputDialog("Enter your email:");
        if (!email.contains("@")|| !email.contains(".")){
            JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email.");
            signUp();
            return;
        }

        String password = JOptionPane.showInputDialog("Enter your password:");
        userService.createUserAccount(new Users(5, firstName, lastName, password, email));
        String confirmPassword = JOptionPane.showInputDialog("Confirm your password:");
        if(password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null, "Account created successfully. Please sign in.");
            displayMenu();
//            signIn();
        } else {
            JOptionPane.showMessageDialog(null,"Passwords do not match. Please try again.");
            signUp();
        }
    }

    public static void displayMenu(){
      String menuOption =  """
                Welcome to Expense Tracker
                Please choose an option:
                1. Generate Report
                2. View Expenses
                3. Add Expenses
                4. Calculate Expenses
                5. Exit
                """;
        String choice = JOptionPane.showInputDialog(menuOption);

        switch (choice){
            case "1":
                generateReport();
                break;
            case "2":
                viewExpenses();
                break;
            case "3":
                addExpenses();
                break;
            case "4":
                calculateExpense();
                break;
            case "5":
                JOptionPane.showMessageDialog(null,"Thank you for using Expense Tracker. Goodbye!");
                exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                displayMenu();
                break;
        }
    }
    private static void generateReport() {
        String expenseReport = expenseService.generateReport();
        JOptionPane.showMessageDialog(null, "Total expenses is : " + expenseReport);
        displayMenu();
    }

    private static void viewExpenses() {
        List<Expenses> expense =  expenseService.expenseList();
       JOptionPane.showMessageDialog(null,"\nExpenses " + expense.size());
        for (Expenses e : expense) {
            JOptionPane.showMessageDialog(null,"Amount: " + e.getAmount()
                    +"\nCategory "
                    + e.getExpenseCategory()
                    + "\nDescription"
                    + e.getExpenseDescription() + " \n");
        }
        displayMenu();
    }

    private static void addExpenses() {
        JOptionPane.showMessageDialog(null, "Track your expenses");

        while (true) {
            String description = JOptionPane.showInputDialog("Enter expense description: ");
            String amountInput = JOptionPane.showInputDialog("Enter expense amount: ");
            String category = JOptionPane.showInputDialog("Enter expense category: ");

            // Parse the amount and handle potential exceptions
            int amount;
            try {
                amount = Integer.parseInt(amountInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid integer.");
                continue; // Restart the loop for valid inputs
            }

            LocalDateTime dateTime = LocalDateTime.now();
            Expenses expense = new Expenses(5, description, amount, category, dateTime); // consider generating a unique ID
            expenseService.addExpense(expense);

            JOptionPane.showMessageDialog(null, "Expense added successfully on " + dateTime);

            String answer = JOptionPane.showInputDialog("Do you want to add another expense? (yes/no)");

            if (answer.equalsIgnoreCase("no")) {
//                JOptionPane.showMessageDialog(null, "Thank you for using the expense tracker.");
                displayMenu();
                break; // Exit the loop
            } else if (!answer.equalsIgnoreCase("yes")) {
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                // Optionally, you could loop back to ask if they want to add another expense
            }
        }
    }
    private static void calculateExpense() {
        JOptionPane.showMessageDialog( null,"Calculate your total expenses");
        var calculatedAmount =   expenseService.calculateTotalExpense();
        JOptionPane.showMessageDialog( null,"The Total Expenses is" + calculatedAmount);
        displayMenu();
    }


}