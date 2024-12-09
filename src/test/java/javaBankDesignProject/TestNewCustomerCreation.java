package javaBankDesignProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestNewCustomerCreation {

    Customer person1;
    Customer company1;

    @BeforeEach
    public void setUp() {
	person1 = new Person("person1", "address1");
	company1 = new Company("company1", "address2");
    }

    @Test
    public void test_customers_are_created() {
	Assertions.assertEquals(2000000, person1.getCUSTOMER_ID());
	Assertions.assertEquals(2000007, company1.getCUSTOMER_ID());
    }
}