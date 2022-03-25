package bank;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/*
Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When they print their bank statement
 */
public class AcceptanceShould {
    @Test
    void acceptance_test_should_pass() {
        Console console = mock(Console.class);

        AccountService accountService = new AccountServiceImpl(console);

        //hoy es 10-01-2012
        accountService.deposit(1000);

        //hoy es 13-01-2012
        accountService.deposit(2000);

        //hoy es 14-01-2012
        accountService.withdraw(500);

        accountService.printStatement();

        String expectedStatement = "Date       || Amount || Balance\n" +
                "14/01/2012 || -500   || 2500\n" +
                "13/01/2012 || 2000   || 3000\n" +
                "10/01/2012 || 1000   || 1000";

        assertEquals(expectedStatement, console.output());
    }
}
