package javaBankDesignProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javaBankDesignProject.account.Account;
import javaBankDesignProject.account.CheckingAccount;
import javaBankDesignProject.account.SavingsAccount;

public class TestDepositAndWithdrawInAccounts {

    Account savingsAccount1;
    Account checkingAccount1;

    @BeforeEach
    public void setUp() {
	savingsAccount1 = new SavingsAccount();
	checkingAccount1 = new CheckingAccount();
    }

    @Test
    public void test_depositInAccount() {
	savingsAccount1.deposit(150);
	checkingAccount1.deposit(200);

	Assertions.assertEquals(150, savingsAccount1.getBalance(), 0.001);
	Assertions.assertEquals(200, checkingAccount1.getBalance(), 0.001);
    }

    @Test
    public void test_withdrawFromAccounts() {
	savingsAccount1.deposit(150);
	checkingAccount1.deposit(200);

	double withdraw1 = savingsAccount1.withdraw(80);
	double withdraw2 = checkingAccount1.withdraw(150);

	Assertions.assertEquals(80, withdraw1, 0.001);
	Assertions.assertEquals(150, withdraw2, 0.001);
    }

    @Test
    public void test_savingsAccountCannotOverdraw() {
	savingsAccount1.deposit(200);
	// cannot overdraw:
	double withdraw1 = savingsAccount1.withdraw(300);
	Assertions.assertEquals(0, withdraw1, 0.001);
	// the balance is still 200
	Assertions.assertEquals(200, savingsAccount1.getBalance(), 0.001);
    }
}