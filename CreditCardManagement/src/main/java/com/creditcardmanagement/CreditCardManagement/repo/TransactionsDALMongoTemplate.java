package com.creditcardmanagement.CreditCardManagement.repo;

import com.creditcardmanagement.CreditCardManagement.dto.CategoryTransactions;
import com.creditcardmanagement.CreditCardManagement.dto.CustomerTransactions;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionsDALMongoTemplate implements TransactionsRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Transactions> getAllTransactions()
    {
        return mongoTemplate.findAll(Transactions.class);
    }
    public Object getTransactionsById(long transId)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(transId));
        return mongoTemplate.findOne(query,Transactions.class);
    }
    public List<CustomerTransactions> getTransactionsForCustomer()
    {
        GroupOperation groupByCustomerTransactions = group("CustomerId").sum("amount")
                .as("total_transactions");

        MatchOperation allTransactions = match(new Criteria("CustomerId").exists(true));

        ProjectionOperation includes = project("total_transactions").and("CustomerId").previousOperation();

        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"total_transactions"));

        Aggregation aggregation = (Aggregation) newAggregation(allTransactions,groupByCustomerTransactions,sortBySalesDesc,includes);
        AggregationResults<CustomerTransactions> groupResults = mongoTemplate
                .aggregate((TypedAggregation<?>) aggregation, "transactions",CustomerTransactions.class);
        List<CustomerTransactions> result = groupResults.getMappedResults();
        return result;
    }
    public List<Transactions> getTransactionsName(String category) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customer").is(category));
        return mongoTemplate.find(query, Transactions.class);
    }
}
