package javaBankDesignProject;

public abstract class Account {

    private final long ACCOUNT_ID;
    private static long nextAccountId = 1_000;
    protected double balance;

    public Account() {
	this.ACCOUNT_ID = nextAccountId;
	nextAccountId += 5;
    }

    public double withdraw(double amount) {
	balance -= amount;
	// returns amount, not balance
	return amount;
    }

    public void deposit(double amount) {
	balance += amount;
    }

    public void correctBalance(double amount) {
	balance = amount;
    }

    public long getACCOUNT_ID() {
	return ACCOUNT_ID;
    }

    public double getBalance() {
	return balance;
    }
}