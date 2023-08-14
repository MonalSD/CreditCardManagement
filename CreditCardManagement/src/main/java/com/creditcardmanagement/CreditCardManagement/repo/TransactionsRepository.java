package com.creditcardmanagement.CreditCardManagement.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionsRepository extends MongoRepository<Transactions, ObjectId> {
    List<Transactions> findByMerchant(String Merchant);
    List<Transactions> findByCity(String customerCity);
    @Aggregation(pipeline = {
            "{'$match':{'state':?0}}",
            "{'$sample':{'size':?20}}",
            "{'$sort': {'trans_num':1}}"
    })
    List<Transactions> findByState(String state);
    @Aggregation(pipeline = {
            "{'$match':{'trans_num':?0}}",
            "{'$sample':{'size':?20}}",
            "{'$sort': {'trans_num':-1}}"
    })
    List<Transactions> findAllByTransactionNum();
}
