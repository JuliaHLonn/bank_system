import com.bank.BankAccount;
import com.bank.BankMenu;
import com.bank.service.BankService;
import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class BankMenuTest {


    String name = "Kalle";
    String customerId = "10";
    String inputString = "c\n100\nc\nc";

    BankMenu mockBankMenu = mock(BankMenu.class);


    @Test
    public void shouldCallMenu() {

        mockBankMenu.menu();
        verify(mockBankMenu, times(1)).menu();

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
}
