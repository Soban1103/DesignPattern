package Creational;
// ----- > Singleton Pattern <----- 

import java.util.*;

class Bank{
    private static Bank instance;
    private Map<Integer, BankAccount> accounts;
    
    private Bank() {
        accounts = new HashMap<>();
    }
    
    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }
    
    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
    
    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }
}

class BankAccount {
    private int accountNumber;
    private double balance;
    
    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
}

public class Singleton{
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        BankAccount account = new BankAccount(123);
        bank.addAccount(account);
        account.deposit(100);
        account.withdraw(50);
        System.out.println(bank.getAccount(123).getBalance());

        BankAccount anotherAccount = new BankAccount(456);
        bank.addAccount(anotherAccount);
        anotherAccount.deposit(500);
        anotherAccount.withdraw(50);
        System.out.println(bank.getAccount(456).getBalance());

        BankAccount yetAnotherAccount = new BankAccount(789);
        bank.addAccount(yetAnotherAccount);
        
    }
}

/*
    class{
        private and static class instance
        connstructor
        public staic class getInstance method
    }
 */