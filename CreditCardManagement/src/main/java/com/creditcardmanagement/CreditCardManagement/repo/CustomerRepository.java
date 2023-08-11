package com.creditcardmanagement.CreditCardManagement.repo;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends MongoRepository <Customer, Long>{

}
