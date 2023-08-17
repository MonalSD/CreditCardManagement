package com.creditcardmanagement.CreditCardManagement.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionsRepository extends MongoRepository<Transactions, ObjectId> {
    List<Transactions> findByCity(String city);

}
