package bank;

/*
Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When they print their bank statement
 */
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {

  @Captor
  ArgumentCaptor<String> stringArgumentCaptor;

  @Test
  void when_print_statement_console_writeInConsoleIsCalled() {
    Console console = mock(Console.class);

    String expectedOutput = "Date || Amount || Balance\n";

    AccountService accountService = new AccountServiceImpl(console);
    accountService.printStatement();

    verify(console).writeInConsole(expectedOutput);
  }

  @Test
  void a_client_can_make_a_deposit() {
    Console console = mock(Console.class);

    AccountService accountService = new AccountServiceImpl(console);
    accountService.deposit(1000);
    String expectedOutput = "Date       || Amount || Balance\n" + "10/01/2012 || 1000   || 1000";
    accountService.printStatement();

    verify(console).writeInConsole(stringArgumentCaptor.capture());

    assertTrue(stringArgumentCaptor.getValue().contains("1000"));
  }
}
