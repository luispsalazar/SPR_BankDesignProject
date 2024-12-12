package javaBankDesignProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javaBankDesignProject.account.AccountController;

public class TestAccountControllerRemoveCustomer {

    AccountController accountController;

    @BeforeEach
    public void setUp() {
	accountController = new AccountController();
    }

    @Test
    public void test_createCustomerWithOneSavingsAndOneCheckingAndRemoveCustomer() {

	// Customer customer1 = accountController.createCustomer("person1", "address1",
	// "person");

//	Account account1 = accountController.createAccount(customer1, "savings");
//	Account account2 = accountController.createAccount(customer1, "checking");
//
//	List<Account> allAccounts = accountController.getAccounts();
//
//	Assertions.assertEquals(2, allAccounts.size());
//
//	accountController.removeCustomer(customer1);

//	Assertions.assertTrue(!allAccounts.contains(account1) & !allAccounts.contains(account2));
    }
}