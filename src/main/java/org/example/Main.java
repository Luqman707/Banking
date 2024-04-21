package org.example;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setPhoneNumber(Optional.of("09087888737"));
        String User = "Ola";
        System.out.println("----------------------************************************--------------------------");
        u1.showMenu();
        System.out.println("Welcome " + User);

        Transaction t1 = new Transaction();
        t1.moneyDeposited(20000);
        t1.setDate(LocalDate.of(2024, 4, 2));
//        Calendar c1 = Calendar.getInstance();
        System.out.println(t1.getTransactions());

        Transaction t2 = new Transaction();
        t2.moneyTransferred(10000);
        t2.setDate(LocalDate.of(2024, 4, 1));
//        Calendar c2 = Calendar.getInstance();

//        Transaction t3 = new Transaction();
//        t3.applyForQuickLoan();
//        t3.setDate(LocalDate.of(2024,4,5));
//
//        Transaction t4 = new Transaction();
//        t4.getSalaryAdvance();
//        t4.setDate(LocalDate.of(2024,3, 29));

        List<Transaction> list = List.of(t1,t2);



       Map<Double, String> transaction = new LinkedHashMap<>();
       transaction.put(20000.0, "Deposit");
       transaction.put(-10000.0, "Transfer");
       transaction.put(100000.0, "Quick Credit");
       transaction.put(40000.0, "Salary advance");

       transaction.forEach((k,v) -> System.out.println(k + "" + v));
        System.out.println(transaction);

    }
}