package javaBankDesignProject.customer;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import javaBankDesignProject.account.Account;
import javaBankDesignProject.safetydepositbox.Address;

@Entity
public abstract class Customer {

    @Id
    private long CUSTOMER_ID;
    private static long nextCustomerId = 2000000;
    private String name;

    @OneToOne
    private Address address;
    private List<Account> accounts;

    public Customer(String name, Address address) {
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

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }
}