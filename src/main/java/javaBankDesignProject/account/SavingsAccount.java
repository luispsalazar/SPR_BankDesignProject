package javaBankDesignProject.account;

public class SavingsAccount extends Account {

    private double interestRate;

    public void addInterest() {
	balance += balance * this.getInterestRate() / 100;
    }

    public double getInterestRate() {
	return interestRate;
    }

    public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
    }

    @Override
    public double withdraw(double amount) {

	if (amount > balance) {
	    return 0.0;
	} else {
	    balance -= amount;
	    return amount;
	}
    }
}