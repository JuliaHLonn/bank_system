package com.bank;

import com.bank.service.BankService;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class BankMenuTest {
    BankService bankService;
    BankMenu bankMenu;
    BankAccount bankAccount;

    @BeforeEach
    public void setUp() {

        bankService = Mockito.mock(BankService.class);
        bankAccount = new BankAccount("Alice", "2");
        bankMenu = new BankMenu(bankService, bankAccount);
    }

    @Test
    public void verifiesThatDepositWasCalledExpectedNumberOfTimes() {

        bankAccount.setBalance(100);
        
        bankService.deposit(bankAccount, 100);

        Mockito.verify(bankService, Mockito.times(1)).deposit(bankAccount, 100);
    }

    @Test
    public void verifiesThatWithdrawWasCalledExpectedNumberOfTimes() {

        bankAccount.setBalance(100);

        bankService.withdraw(bankAccount, 100);

        Mockito.verify(bankService, Mockito.times(1)).withdraw(bankAccount, 100);
    }

    @Test
    public void runTimeException() {
        //  Dmitriy ska försöka lösa den
        bankMenu = Mockito.mock(BankMenu.class);
        bankAccount.setBalance(100);

        doThrow(new RuntimeException()).when(bankService).withdraw(bankAccount, 50);

        try {
            bankMenu.menu();
        } catch (Exception e) {
            fail("");
        }
    }
}