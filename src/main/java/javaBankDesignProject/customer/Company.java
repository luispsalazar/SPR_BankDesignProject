package javaBankDesignProject.customer;

import javaBankDesignProject.account.Account;
import javaBankDesignProject.account.CheckingAccount;
import javaBankDesignProject.safetydepositbox.Address;

public class Company extends Customer {

    public Company(String name, Address address) {
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