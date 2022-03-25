package bank;

public class AccountServiceImpl implements AccountService {

    private final Console console;

    public AccountServiceImpl(Console console) {
        this.console = console;
    }

    @Override
    public void deposit(int amount) {
    }

    @Override
    public void withdraw(int amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printStatement() {
        throw new UnsupportedOperationException();
    }
}
