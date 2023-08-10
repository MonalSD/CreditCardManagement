package com.creditcardmanagement.CreditCardManagement.repo;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long>{

}
