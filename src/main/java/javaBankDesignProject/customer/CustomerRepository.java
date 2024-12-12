package javaBankDesignProject.customer;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class CustomerRepository extends SimpleJpaRepository<Customer, Long> {

    public CustomerRepository(Class<Customer> domainClass, EntityManager entityManager) {
	super(domainClass, entityManager);
    }
}