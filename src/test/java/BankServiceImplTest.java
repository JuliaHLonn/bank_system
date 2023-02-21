import com.bank.BankAccount;
import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankServiceImplTest {
    private BankAccount bankAccount;
    BankServiceImpl bankServiceImpl = new BankServiceImpl();


    @BeforeAll
    public void initialize() {
        bankAccount = new BankAccount("Charles", "1");
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
    public void testDepositing80ShouldGive180() {
        bankServiceImpl.deposit(bankAccount, 80);
        assertEquals(180, bankAccount.getBalance());
    }

    @Test
    public void testDepositingNegativeAmountShouldFail(){
        bankServiceImpl.deposit(bankAccount,-100);
        assertEquals(100, bankAccount.getBalance());
    }


}
