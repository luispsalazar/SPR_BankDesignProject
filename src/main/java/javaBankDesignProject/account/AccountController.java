package javaBankDesignProject.account;

import java.util.ArrayList;
import java.util.List;

import javaBankDesignProject.customer.Company;
import javaBankDesignProject.customer.Customer;
import javaBankDesignProject.customer.Person;
import javaBankDesignProject.safetydepositbox.Address;

public class AccountController {

    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    public Customer createCustomer(String name, Address address, String type) {
	if (type.equals("person")) {
	    Person person = new Person(name, address);
	    customers.add(person);
	    return person;
	}

	if (type.equals("company")) {
	    Company company = new Company(name, address);
	    customers.add(company);
	    return company;
	}
	return null;
    }

    public Account createAccount(Customer customer, String type) {
	if (type.equals("checking")) {
	    CheckingAccount checkingAccount = new CheckingAccount();
	    customer.addAccount(checkingAccount);
	    accounts.add(checkingAccount);
	    return checkingAccount;
	}

	if (type.equals("savings")) {
	    SavingsAccount savingsAccount = new SavingsAccount();
	    customer.addAccount(savingsAccount);
	    accounts.add(savingsAccount);
	    return savingsAccount;
	}
	return null;
    }

    public void removeCustomer(Customer customer) {
	customers.remove(customer);
	for (Account account : customer.getAccounts()) {
	    accounts.remove(account);
	}
    }

    public void removeAccount(Account account) {
	accounts.remove(account);
	for (Customer customer : customers) {
	    customer.getAccounts().remove(account);
	}
    }

    public List<Customer> getCustomers() {
	return customers;
    }

    public List<Account> getAccounts() {
	return accounts;
    }
}