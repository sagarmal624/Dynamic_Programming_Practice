package com.example.mongodbpoc.thread;

public class ATM {
    private Integer balance;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void withdraw(int withdrawAmount) throws Exception {
        synchronized (this) {
            if (withdrawAmount > balance) {
                System.out.println("Less Amount in Account so pleease deposit");
                wait();
                System.out.println("Transaction is done");
            } else {
                balance = balance - withdrawAmount;
                System.out.println("Amount is withdraw successfull");
            }
        }
    }

    public void deposit(Integer amount) {
        balance = balance + amount;
        notify();
    }
}
