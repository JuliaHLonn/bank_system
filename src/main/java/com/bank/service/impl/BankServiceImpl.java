package com.bank.service.impl;

import com.bank.BankAccount;
import com.bank.service.BankService;

public class BankServiceImpl implements BankService {
    @Override
    public void withdraw(BankAccount bankAccount, double amount) {
        if (amount > 0 && bankAccount.getBalance() >= amount) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            bankAccount.setPrevTrans(bankAccount.getPrevTrans() - amount);
        }else if (amount <= 0){
            System.out.println("Amount must be greater than 0");
        }
        else if (bankAccount.getBalance() < amount) {
            System.out.println("Bank balance insufficient");
        }
    }

    @Override
    public void deposit(BankAccount bankAccount, double amount) {
        if (amount >= 0) {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            bankAccount.setPrevTrans(amount);
        }
        else {
            System.out.println("The amount to deposit must be higher then 0");
        }
    }
}
