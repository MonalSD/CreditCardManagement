package com.creditcardmanagement.CreditCardManagement.repo;

import com.creditcardmanagement.CreditCardManagement.dto.*;
import com.creditcardmanagement.CreditCardManagement.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
@Repository
public class TransactionMongoTemplate
{
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CategoryAmount> getSpendingHistoryByCategory()
    {
        GroupOperation groupByCategorySumAmount = group("category").sum("amt").as("total_amt");
        MatchOperation allCategory = match(new Criteria("category").exists(true));
        ProjectionOperation includes = project("total_amt").and("category").previousOperation();
        SortOperation sortByAmtDESC = sort(Sort.by(Sort.Direction.DESC,"total_amt"));

        Aggregation aggregation = newAggregation((AggregationOperation) allCategory,groupByCategorySumAmount,sortByAmtDESC,includes);
        AggregationResults<CategoryAmount> groupResults = mongoTemplate.aggregate(aggregation,"transactions",CategoryAmount.class);
        List<CategoryAmount> result = groupResults.getMappedResults();

        return result;
    }

    public List<MerchantAmount> getAmountForMerchant()
    {
        GroupOperation groupByMerchantSumAmount = group("merchant").sum("amt").as("total_amt");
        MatchOperation allMerchant = match(new Criteria("merchant").exists(true));
        ProjectionOperation includes = project("total_amt").and("merchant").previousOperation();
        SortOperation sortByAmtDESC = sort(Sort.by(Sort.Direction.DESC,"total_amt"));

        Aggregation aggregation = newAggregation(allMerchant,groupByMerchantSumAmount,sortByAmtDESC,includes);
        AggregationResults<MerchantAmount> groupResults = mongoTemplate.aggregate(aggregation,"transactions",MerchantAmount.class);
        List<MerchantAmount> result = groupResults.getMappedResults();

        return result;
    }
    public List<GenderAmount> getSpendingHistoryByGender()
    {
        GroupOperation groupByGenderSumAmount = group("gender").sum("amt").as("total_amt");
        MatchOperation allGender = match(new Criteria("gender").exists(true));
        ProjectionOperation includes = project("total_amt").and("gender").previousOperation();
        SortOperation sortByAmtDESC = sort(Sort.by(Sort.Direction.DESC,"total_amt"));

        Aggregation aggregation = newAggregation(allGender,groupByGenderSumAmount,sortByAmtDESC,includes);
        AggregationResults<GenderAmount> groupResults = mongoTemplate.aggregate(aggregation,"transactions",GenderAmount.class);
        List<GenderAmount> result = groupResults.getMappedResults();

        return result;
    }
    public List<JobAmount> getSpendingHistoryByJob()
    {
        GroupOperation groupByJobSumAmount = group("Job").sum("amt").as("total_amt");
        MatchOperation allJob = match(new Criteria("Job").exists(true));
        ProjectionOperation includes = project("total_amt").and("Job").previousOperation();
        SortOperation sortByAmtDESC = sort(Sort.by(Sort.Direction.DESC,"total_amt"));

        Aggregation aggregation = newAggregation(allJob,groupByJobSumAmount,sortByAmtDESC,includes);
        AggregationResults<JobAmount> groupResults = mongoTemplate.aggregate(aggregation,"transactions", JobAmount.class);
        List<JobAmount> result = groupResults.getMappedResults();

        return result;
    }
    public List<CityAmount> getSpendingHistoryByCity()
    {
        GroupOperation groupByCitySumAmount = group("city").sum("amt").as("total_amt");
        MatchOperation allCity = match(new Criteria("city").exists(true));
        ProjectionOperation includes = project("total_amt").and("city").previousOperation();
        SortOperation sortByAmtDESC = sort(Sort.by(Sort.Direction.DESC,"total_amt"));

        Aggregation aggregation = newAggregation(allCity,groupByCitySumAmount,sortByAmtDESC,includes);
        AggregationResults<CityAmount> groupResults = mongoTemplate.aggregate(aggregation,"transactions", CityAmount.class);
        List<CityAmount> result = groupResults.getMappedResults();

        return result;
    }


    public List<StateAmount> getSpendingHistoryByState() {
        GroupOperation groupByStateSumAmount = group("state").sum("amt").as("total_amt");
        MatchOperation allState = match(new Criteria("state").exists(true));
        ProjectionOperation includes = project("total_amt").and("city").previousOperation();
        SortOperation sortByAmtDESC = sort(Sort.by(Sort.Direction.DESC,"total_amt"));

        Aggregation aggregation = newAggregation(allState,groupByStateSumAmount,sortByAmtDESC,includes);
        AggregationResults<StateAmount> groupResults = mongoTemplate.aggregate(aggregation,"transactions", StateAmount.class);
        List<StateAmount> result = groupResults.getMappedResults();
        return result;
    }

    public List<AmountSpending> getSpendingHistoryByAmount(double lowValue, double highValue) {
        Criteria amountCriteria = Criteria.where("amt").gte(lowValue).lte(highValue);
        Query query = new Query(amountCriteria).with(Sort.by(Sort.Direction.DESC,"amt"));
        List<AmountSpending> amountSpendingList = new ArrayList<>();
        List<Transactions>transactions = mongoTemplate.find(query,Transactions.class);

        for(Transactions transaction: transactions)
        {
            AmountSpending amountSpending = new AmountSpending();
            amountSpending.setCustomerId(transaction.getCustomerId());
            amountSpending.setAmt(transaction.getAmt());
            amountSpendingList.add(amountSpending);
        }
        return amountSpendingList;
    }

    public List<TopMerchant> getTopMerchants(int limit) {
        GroupOperation groupByTopMerchantSumAmount = group("merchant").sum("amt").as("total_amt").first("city").as("city")
                .first("state").as("state")
                .first("city_population").as("cityPopulation");
        MatchOperation allMerchant = match(new Criteria("merchant").exists(true));
        ProjectionOperation includes =project("total_amt").andInclude("city").andInclude("state").andInclude("cityPopulation");
        SortOperation sortByAmtDESC = sort(Sort.by(Sort.Direction.DESC,"total_amt"));

        Aggregation aggregation = newAggregation(allMerchant,groupByTopMerchantSumAmount,sortByAmtDESC,includes);
        AggregationResults<TopMerchant> groupResults = mongoTemplate.aggregate(aggregation,"transactions", TopMerchant.class);
        List<TopMerchant> result = groupResults.getMappedResults();
        return result;
    }
}
