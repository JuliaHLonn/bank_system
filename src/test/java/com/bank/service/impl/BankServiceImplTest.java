package com.bank.service.impl;

import com.bank.BankAccount;
import com.bank.service.BankService;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest extends TestCase {

    BankAccount bankAccount;
    BankService bankService;

    @BeforeEach
    public void setUp() {
        bankService = new BankServiceImpl();
        bankAccount = new BankAccount("Anton", "1");
    }

    public void currentBalance() {
        System.out.println("Current balance " + bankAccount.getBalance());
    }

    @Test
    public void checksIfWithdrawIsSuccessful() {

        bankAccount.setBalance(100);

        bankService.withdraw(bankAccount, 50);
        currentBalance();

        assertEquals(50d, bankAccount.getBalance());
    }

    @Test
    public void checksIfWithdrawIsSuccessfulWith0Amount() {

        bankAccount.setBalance(100);

        bankService.withdraw(bankAccount, 0);
        currentBalance();

        assertEquals(100d, bankAccount.getBalance());
    }

    @Test
    public void checkWithdrawWithInsufficientBankBalance() {

        bankAccount.setBalance(100);

        bankService.withdraw(bankAccount, 150);
        currentBalance();

        assertEquals(100d, bankAccount.getBalance());
    }

    @Test
    public void checksWithdrawWithNegativeAmount() {

        bankAccount.setBalance(1000);

        bankService.withdraw(bankAccount, -500);
        currentBalance();

        assertEquals(1000d, bankAccount.getBalance());
    }

    @Test
    public void checksIfDepositWorksProperly() {
        bankAccount.setBalance(100);

        bankService.deposit(bankAccount, 100);
        currentBalance();

        assertEquals(200d, bankAccount.getBalance());
    }

    @Test
    public void checksDepositWithNegativeAmount() {
        bankAccount.setBalance(100.0);

        try {
            bankService.deposit(bankAccount, -500);
            fail("Expected an IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Amount must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void checksDepositWith0() {
        bankAccount.setBalance(100.0);

        try {
            bankService.deposit(bankAccount, 0);
            fail("Expected an IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Amount must be greater than 0", e.getMessage());
        }
    }

}