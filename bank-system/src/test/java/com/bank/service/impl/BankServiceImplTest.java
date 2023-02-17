package com.bank.service.impl;

import com.bank.BankAccount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankServiceImplTest {
    private BankAccount bankAccount;
    private BankServiceImpl bankServiceImpl;

    @BeforeAll
    public void setup() {
        bankAccount = new BankAccount("Johan", "32");
        bankServiceImpl = new BankServiceImpl();


    }

    @Test
    public void withdrawShouldWorkWithAmountLessThenBalance() {
        bankAccount.setBalance(0);
        bankServiceImpl.deposit(bankAccount, 380);
        bankServiceImpl.withdraw(bankAccount, 200);
        assertEquals(180, bankAccount.getBalance());
    }

    @Test
    public void withdrawShouldFailWithAmountBiggerThenBalance() {
        bankAccount.setBalance(0);
        bankServiceImpl.deposit(bankAccount, 380);
        bankServiceImpl.withdraw(bankAccount, 400);
        assertEquals(380, bankAccount.getBalance());
    }

    @Test
    public void depositShouldWork() {
        bankAccount.setBalance(0);
        bankServiceImpl.deposit(bankAccount,120);
        assertEquals(120,bankAccount.getBalance());
    }

    @Test
    public void depositShouldFailWithAmountLessThenZero(){
        bankAccount.setBalance(100);
        bankServiceImpl.deposit(bankAccount,-100);
        assertEquals(100,bankAccount.getBalance());
    }

}