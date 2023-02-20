import com.bank.BankAccount;
import com.bank.BankMenu;
import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertThrows;

public class BankMenuTest {


    String name = "Kalle";
    String customerId = "10";


    @Test
    public void shouldNotThrowExceptionToConsole() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("c\n100\nc\nc".getBytes()));


        assertThrows(RuntimeException.class, () -> {
                    new BankMenu(new BankServiceImpl(), new BankAccount(name, customerId), stdin).menu();
                }
        );
    }
}
