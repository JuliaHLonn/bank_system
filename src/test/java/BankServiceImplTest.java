import com.bank.BankAccount;
import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankServiceImplTest {
    private BankAccount bankAccount;
    BankServiceImpl bankServiceImpl;


    @BeforeEach
    public void initialize() {
        bankAccount = new BankAccount("Charles", "1");
        bankServiceImpl = new BankServiceImpl();
        bankAccount.setBalance(100);

    }

    @Test
    public void testWithdrawing80ShouldLeave20() {
        bankServiceImpl.withdraw(bankAccount, 80);
        assertEquals(20, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawingMoreThanBalanceShouldFail(){
        bankServiceImpl.withdraw(bankAccount, 180);
        assertEquals(100, bankAccount.getBalance());
    }
    
@Test
public void depositShouldWork() {
    bankServiceImpl.deposit(bankAccount,120);
    assertEquals(220,bankAccount.getBalance());
}

    @Test
    public void depositShouldFailWithAmountLessThenZero(){
        bankServiceImpl.deposit(bankAccount,-100);
        assertEquals(100,bankAccount.getBalance());
    }


}
