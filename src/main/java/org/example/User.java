package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class User {
    // Encapsulation: Keeping data secure and standardized
    private String userName;
    private String email;
    private double balance;
    private double previousTransaction;
    private final long accountNumber = 1134050005L; // Leading zero removed to avoid Octal bug
    private final LocalDateTime date = LocalDateTime.now();

    public User(String userName, String email, double initialBalance) {
        this.userName = userName;
        this.email = email;
        this.balance = initialBalance;
    }

    // Core transaction methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
            System.out.printf("Successfully credited %.2f to your account on %s%n",
                    amount, date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
    }

    public void transfer(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            previousTransaction = -amount;
            System.out.printf("Successfully debited %.2f from your account.%n", amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void showPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Money Received: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Money Transferred: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No previous transactions found.");
        }
    }

    public void handleLoan(Scanner sc) {
        System.out.println("******************************************************************************");
        if (balance >= 50000) {
            System.out.print("Enter amount to apply for Quick Loan (or '0' to cancel): ");
            double amount = sc.nextDouble();
            if (amount > 0) {
                balance += amount;
                previousTransaction = amount;
                System.out.println("Congratulations! Your account has been credited with " + amount);
            }
        } else {
            System.out.println("Not eligible for Quick Loan. Proceeding to Salary Advance...");
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            balance += amount;
            previousTransaction = amount;
            System.out.println("Congratulations! Account credited with " + amount + " salary advance.");
            System.out.println("An offer letter has been sent to your email: " + email);
        }
        System.out.println("******************************************************************************");
    }

    public void showMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            // Initial Login Simulation
            System.out.println("-------------------- OSLO Savings Bank App --------------------");
            System.out.print("1. Login\n2. New User\nChoice: ");
            sc.nextInt(); // Consume choice

            System.out.print("Enter your email: ");
            this.email = sc.next();
            System.out.print("Enter your password: ");
            sc.nextInt(); // Consume password

            System.out.println("\n******************************************************************************");
            System.out.println("Welcome " + userName + " | Account Number: " + accountNumber);
            System.out.println("User ID: " + email);

            char option;
            do {
                printMenuOptions();
                // Handle lowercase by converting input string to uppercase
                String input = sc.next().toUpperCase();
                option = input.isEmpty() ? ' ' : input.charAt(0);

                switch (option) {
                    case 'A':
                        System.out.printf("Current Balance: %.2f%n", balance);
                        break;
                    case 'B':
                        System.out.print("Enter deposit amount: ");
                        deposit(sc.nextDouble());
                        break;
                    case 'C':
                        System.out.print("Enter transfer amount: ");
                        transfer(sc.nextDouble());
                        break;
                    case 'D':
                        showPreviousTransaction();
                        break;
                    case 'E':
                        handleLoan(sc);
                        break;
                    case 'F':
                        System.out.print("Enter amount for Airtime/Data: ");
                        transfer(sc.nextDouble());
                        break;
                    case 'G':
                        handleBillPayments(sc);
                        break;
                    case 'Q':
                        System.out.println("Thank you for using OSLO BANKING APP. Logged out.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 'Q');
        }
    }

    private void handleBillPayments(Scanner sc) {
        System.out.println("--- Bill Payments ---");
        System.out.println("1. CableTV\n2. Utilities\n3. Sports\n4. School\n5. Electricity\n6. Visa");
        System.out.print("Choice: ");
        sc.nextInt();
        System.out.print("Enter amount: ");
        transfer(sc.nextDouble());
    }

    private void printMenuOptions() {
        System.out.println("\n[A] Balance [B] Deposit [C] Transfer [D] History");
        System.out.println("[E] Loans   [F] Airtime [G] Bills    [Q] Quit");
        System.out.print("Selection: ");
    }

    public static void main(String[] args) {
        // You can now initialize with specific user data
        User u1 = new User("Mustapha", "m.moritala@example.com", 60000.0);
        u1.showMenu();
    }
}