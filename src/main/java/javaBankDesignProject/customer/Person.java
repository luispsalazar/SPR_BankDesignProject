package javaBankDesignProject.customer;

import javaBankDesignProject.account.Account;
import javaBankDesignProject.safetydepositbox.Address;

public class Person extends Customer {

    public Person(String name, Address address) {
	super(name, address);
    }

    @Override
    public void chargeAllAccounts(double amount) {
	for (Account account : getAccounts()) {
	    account.withdraw(amount);
	}
    }
}