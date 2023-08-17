package com.creditcardmanagement.CreditCardManagement.repo;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends MongoRepository <Customer, ObjectId>{
    boolean existsByCustomerId(int customerId);

//   Optional<Customer> findByCustomerId(String customerId);

    List<Customer> findByFirst(String customerFirst);
    List<Customer> findByLast(String customerLast);
    //@Query("{customerId:?0}")
    public Customer findByCustomerId(int customerId);


    List<Customer> findByJob(String customerJob);

    List<Customer> findByGender(String customerGender);
}
