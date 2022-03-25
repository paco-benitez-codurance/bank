package bank;


/*
Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When they print their bank statement
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceShould {
    @Test
    void a_client_can_makes_a_deposit_whithout_error() {
        AccountService accountService = new AccountServiceImpl(null);
        assertDoesNotThrow(() ->
            accountService.deposit(30)
        );
    }
}
