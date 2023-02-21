import com.bank.BankAccount;
import com.bank.BankMenu;
import com.bank.service.BankService;
import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class BankMenuTest {


    String name = "Kalle";
    String customerId = "10";
    String inputString = "c\n100\nc\nc";
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
    public void shouldNotThrowExceptionToConsole() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));


        assertThrows(RuntimeException.class, () -> {
                    new BankMenu(new BankServiceImpl(), new BankAccount(name, customerId), stdin).menu();
                }
        );
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
    public void verifiesThatMenuWasCalledExpectedNumberOfTimes() {
        bankMenu = mock(BankMenu.class);

        bankMenu.menu();

        Mockito.verify(bankMenu, Mockito.times(1)).menu();

    }
}
