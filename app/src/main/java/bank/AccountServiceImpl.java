package bank;

public class AccountServiceImpl implements AccountService {

  private static final String HEADER = "Date || Amount || Balance\n";
  private final Console console;
  private int lastAmount;

  public AccountServiceImpl(Console console) {
    this.console = console;
  }

  @Override
  public void deposit(int amount) {
    lastAmount = amount;
  }

  @Override
  public void withdraw(int amount) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void printStatement() {
    console.writeInConsole(HEADER + amountLine());
  }

  private String amountLine() {
    if(lastAmount > 0) {
      return "10/01/2012 || " + lastAmount + " || " + lastAmount;
    } else {
      return "";
    }
  }
}
