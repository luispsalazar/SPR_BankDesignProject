package javaBankDesignProject;

public class Company extends Customer {

    public Company(String name, String address) {
	super(name, address);
    }

    @Override
    public void chargeAllAccounts(double amount) {
	for (Account account : getAccounts()) {
	    if (account instanceof CheckingAccount) {
		account.withdraw(amount);
	    } else {
		account.withdraw(2 * amount);
	    }
	}
    }
}