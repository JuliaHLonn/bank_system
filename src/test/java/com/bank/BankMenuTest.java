package com.bank;

import com.bank.service.BankService;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankMenuTest {
    BankService bankService;
    BankMenu bankMenu;
    BankAccount bankAccount;

    @BeforeEach
    public void setUp() {

    bankService = Mockito.mock(BankService.class);
    bankMenu = new BankMenu(bankService, bankAccount);
    bankAccount = Mockito.mock(BankAccount.class);
    }

    @Test
    public void verifiesThatDepositWasCalledExpectedAmountOfTimes() {

        bankAccount.setBalance(100);

        bankService.deposit(bankAccount, 100);

        Mockito.verify(bankService, Mockito.times(1)).deposit(bankAccount, 100);
    }

    @Test
    public void verifiesThatWithdrawWasCalledExpectedAmountOfTimes() {

        bankAccount.setBalance(100);

        bankService.withdraw(bankAccount, 100);

        Mockito.verify(bankService, Mockito.times(1)).withdraw(bankAccount, 100);
    }


    public void testGetBankAccount() {
    }
}