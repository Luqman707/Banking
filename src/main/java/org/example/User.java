package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class User {
    public String userName = "Ola";
    public String email = "Olalinks@gmail.com";
    private int password;
    private Optional phoneNumber;
    public LocalDate date;
    public int previousTransaction;
    public double balance;
    private int acountNumber = 01134050005;
    public List<Transaction> transactions;
    private static int salaryAdvance = 50000;

    public User() {
        this.userName = userName;
    }

    public void moneyDeposited(int amount1) {
        if (amount1 != 0) {
            balance += amount1;
            previousTransaction = amount1;
            System.out.println("The sum of "+ amount1 + " successfully deposited on " + date);
        }
    }

    public void moneyTransferred(int amount2){
        if (amount2 != 0){
            balance -= amount2;
            previousTransaction = amount2;
            System.out.println("The sum of "+ amount2 + " successfully transferred on " + date);
        }

    }

    public void getPreviousTransaction() {
        if(previousTransaction > 0){
            System.out.println("Money Received: "+ previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("Money Transferred: "+ previousTransaction);
        }
        else {
            System.out.println("No transacion has occured! ");
        }
    }
    public void applyForQuickLoan(){
        if (balance >= 50000){
//            System.out.println("Eligible to Apply for Quick Loan");
            System.out.println("Enter amount to apply for Quick Loan " + ("Enter Q to Quit"));
            Scanner in = new Scanner(System.in);
            int amount = in.nextInt();
            System.out.println("Congratulations! your account has been credited with "+ amount);
            System.out.println("******************************************************************************************************************");
        }
        else if(balance < 50000){
            System.out.println("Not Eligible for Loan! ");
            System.out.println("Apply for salary advance " + ("Enter Q to Quit"));
            Scanner in = new Scanner(System.in);
            int amount = in.nextInt();
            System.out.println("Congratulations! your account has been credited with "+ amount);
            System.out.println("Transaction successful! An offer letter has been sent to your mail.");
            System.out.println("******************************************************************************************************************");
        }

    }

    public void getSalaryAdvance(){
        if (balance >= 0) {
            System.out.println("Eligible to access salary advance");
            Scanner in = new Scanner(System.in);
            int amount = in.nextInt();
            balance += amount;

        }
        else {
            System.out.println("No transaction has occured! ");

        }
    }

    void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------OSLO Savings Bank App-------------------- ");
        System.out.println("******************************************************************************");

        System.out.println("\t\t\t1. Login\n");
        System.out.println("\t\t\t2. New User\n");
        System.out.print("\t\t\tChoice: ");
        int choice = sc.nextInt();

        System.out.println("\t\t\tEnter your email: ");
        String email = sc.next();

        System.out.println("\n\t\t\tEnter your password: ");
        int password = sc.nextInt();

        System.out.println("******************************************************************************");
        System.out.println("welcome " + userName + "     Account Number: " + acountNumber);
        System.out.println("Your Id is your registered email: " + email);
        System.out.println("******************************************");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Transfer");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Quick Loans");
        System.out.println("F. Airtime & Data");
        System.out.println("G. Bill payments");
        System.out.println("Q. Quit Transaction");
//        System.out.println("New ID is " + email);

        do {
            System.out.println("-------------------------************************************----------------------------------");

            System.out.println("Enter the option");
            System.out.println("**************************************");
            option = sc.next().charAt(0);

            Character.toUpperCase(option);

            switch (option){
                case 'A':
                    System.out.println("**************************************");
                    System.out.println("Balance is: "+ balance);
                    System.out.println("**************************************");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("**************************************");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("**************************************");
                    int amount = sc.nextInt(); // taking an input from the user and showing inside the amount variable
                    moneyDeposited(amount); // passing the amount variable method to the deposit method
                    System.out.println("Transaction successful! proceed to print receipt.");
                    break;
                case'C':
                    System.out.println("**************************************");
                    System.out.println("Enter amount of money to be transferred");
                    System.out.println("**************************************");
                    int amount2 = sc.nextInt();
                    moneyTransferred(amount2);
                    System.out.println("Transaction successful! proceed to print receipt.");
                    break;
                case 'D':
                    System.out.println("**************************************");
                    getPreviousTransaction();
                    System.out.println("**************************************");
                    break;
                case 'E':
                    System.out.println("**************************************");
                    System.out.println("Needa Quick Loan?");
                    applyForQuickLoan();
//                    getPreviousTransaction();
//                    System.out.println("**************************************");
                    getSalaryAdvance();

                    break;
                case 'G':
                    System.out.println("**************************************");
                    System.out.println("-------------------Bill Payments--------------------");
                    System.out.println("\t\t\t1. CableTV\n");
                    System.out.println("\t\t\t2. Utilities\n");
                    System.out.println("\t\t\t3. Sports & gaming\n");
                    System.out.println("\t\t\t4. School & professional body\n");
                    System.out.println("\t\t\t5. Electricity & water\n");
                    System.out.println("\t\t\t6. Visa fee payment\n");
                    System.out.print("\t\t\tChoice: ");
//                    int choice = 0;
                    choice = sc.nextInt();
                    int amount5 = sc.nextInt();
                    moneyTransferred(amount5);
                    System.out.println("Transaction successful! proceed to print receipt.");
                    break;

                default:
                    System.out.println("Invalid Option! Please try again ");
                    break;

            }
        } while (option != 'Q');
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(int acountNumber) {
        this.acountNumber = acountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Optional getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Optional phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email=" + email +
                ", password=" + password +
                ", acountNumber=" + acountNumber +
                ", transactions=" + transactions +
                '}';
    }
}
