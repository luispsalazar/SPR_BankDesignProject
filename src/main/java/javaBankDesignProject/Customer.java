package javaBankDesignProject;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    private long CUSTOMER_ID;
    private static long nextCustomerId = 2000000;
    private String name;
    private String address;
    private List<Account> accounts;

    public Customer(String name, String address) {
	this.CUSTOMER_ID = nextCustomerId;
	this.name = name;
	this.address = address;
	this.accounts = new ArrayList<Account>();
	nextCustomerId += 7;
    }

    public void addAccount(Account account) {
	accounts.add(account);
    }

    public void removeAccount(Account account) {
	accounts.remove(account);
    }

    public abstract void chargeAllAccounts(double amount);

    public List<Account> getAccounts() {
	return accounts;
    }

    public long getCUSTOMER_ID() {
	return CUSTOMER_ID;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }
}