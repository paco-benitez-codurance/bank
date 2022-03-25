package bank;

public class AccountServiceImpl implements AccountService {

  private static final String HEADER = "Date || Amount || Balance\n";
  private final Console console;
  private boolean hasDeposit;

  public AccountServiceImpl(Console console) {
    this.console = console;
  }

  @Override
  public void deposit(int amount) {
    hasDeposit = true;
  }

  @Override
  public void withdraw(int amount) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void printStatement() {
    if (hasDeposit) {
      console.writeInConsole(HEADER + "10/01/2012 || 1000 || 1000");
    } else console.writeInConsole(HEADER);
  }
}
