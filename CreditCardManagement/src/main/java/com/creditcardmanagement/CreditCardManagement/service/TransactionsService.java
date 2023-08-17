package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.dto.*;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionMongoTemplate;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import java.util.List;

@Service
public class TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private TransactionMongoTemplate dao;

    public List<MerchantAmount> getMerchantAmount() {
        return dao.getAmountForMerchant();
    }

    public List<CategoryAmount> getSpendingHistoryByCategory() {
        return dao.getSpendingHistoryByCategory();
    }

    public List<JobAmount> getSpendingHistoryByJob() {
        return dao.getSpendingHistoryByJob();
    }


    public List<GenderAmount> getSpendingHistoryByGender() {
        return dao.getSpendingHistoryByGender();
    }

    public List<CityAmount> getSpendingHistoryByCity() {
        return dao.getSpendingHistoryByCity();
    }

    public List<StateAmount> getSpendingHistoryByState() {
        return dao.getSpendingHistoryByState();
    }

    public List<Transactions> getPopulationByCity(String city) {
        System.out.println(city + " Printing from service class");
        List<Transactions> customerList = transactionsRepository.findByCity(city);
        return customerList;
    }


    public List<AmountSpending> getSpendingHistoryByAmount(double low,double high) {
        return dao.getSpendingHistoryByAmount(low,high);
    }

    public List<TopMerchant> getTopMerchants(int limit) {
        return dao.getTopMerchants(limit);
    }

}
