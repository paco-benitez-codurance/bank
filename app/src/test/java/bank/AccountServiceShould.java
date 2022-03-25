package bank;

/*
Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When they print their bank statement
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {

  AccountService accountService;
  Console console;

  @BeforeEach
  void setup() {
    console = mock(Console.class);
    accountService = new AccountServiceImpl(console);
  }

  @Test
  void when_print_statement_console_writeInConsoleIsCalled() {
    String expectedOutput = "Date || Amount || Balance\n";
    accountService.printStatement();

    verify(console).writeInConsole(expectedOutput);
  }

  @ParameterizedTest
  @ValueSource(ints = {1000, 2000})
  void a_client_can_make_a_deposit(int amount) {
    accountService.deposit(amount);
    accountService.printStatement();

    String expectedOutput = "Date || Amount || Balance\n" + "10/01/2012 || " + amount +" || " + amount;
    verify(console).writeInConsole(expectedOutput);
  }

}
