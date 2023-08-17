package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.dto.*;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionMongoTemplate;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private TransactionMongoTemplate dao;
    public List<MerchantAmount> getmerchantAmount()
    {
        return dao.getAmountForMerchant();
    }
    public List<CategoryAmount> getSpendingHistoryByCategory()
    {
        return dao.getSpendingHistoryByCategory();
    }
    public List<JobAmount> getSpendingHistoryByJob()
    {
        return dao.getSpendingHistoryByJob();
    }
    public List<GenderAmount> getSpendingHistoryByGender()
    {
        return dao.getSpendingHistoryByGender();
    }
    public List<CityAmount> getSpendingHistoryByCity()
    {
        return dao.getSpendingHistoryByCity();
    }
    public List<StateAmount> getSpendingHistoryByState()
    {
        return dao.getSpendingHistoryByState();
    }
    public List<Transactions> getPopulationByCity(String city)
    {
        System.out.println(city+" Printing from Service Class");
        List<Transactions> customerList = transactionsRepository.findByCity(city);
        return customerList;
    }
    public List<Transactions> getSpendingHistoryByMerchant(String merchant){
        System.out.println(merchant+" Printing from service class");
        List<Transactions> transactionsList = transactionsRepository.findByMerchant(merchant);
        return transactionsList;
    }
//    public List<Transactions> getSpendingHistoryByCity(String city){
//        System.out.println(city+" Printing from service class");
//        List<Transactions> customerList = transactionsRepository.findByCity(city);
//        return customerList;
//    }
//    public List<Transactions> getSpendingHistoryByState(String state){
//        System.out.println(state+" Printing from service class");
//        List<Transactions> stateList = transactionsRepository.findByState(state);
//        return stateList;
//    }

    public List<Transactions> getAllByTransactionNum()
    {
        return transactionsRepository.findAllByTransactionNum();
    }

    public List<AmountSpending> getSpendingHistoryByAmount(double low, double high) {
        return dao.getSpendingHistoryByAmount(low,high);
    }

    public List<TopMerchant> getTopMerchants(int limit) {
        return dao.getTopMerchants(limit);
    }
}
