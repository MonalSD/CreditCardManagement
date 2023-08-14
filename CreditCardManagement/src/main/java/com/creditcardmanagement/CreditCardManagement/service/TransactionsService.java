package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;
    public List<Transactions> getSpendingHistoryByMerchant(String merchant){
        System.out.println(merchant+" Printing from service class");
        List<Transactions> transactionsList = transactionsRepository.findByMerchant(merchant);
        return transactionsList;
    }
    public List<Transactions> getSpendingHistoryByCity(String city){
        System.out.println(city+" Printing from service class");
        List<Transactions> customerList = transactionsRepository.findByCity(city);
        return customerList;
    }
    public List<Transactions> getSpendingHistoryByState(String state){
        System.out.println(state+" Printing from service class");
        List<Transactions> stateList = transactionsRepository.findByState(state);
        return stateList;
    }

    public List<Transactions> getAllByTransactionNum()
    {
        return transactionsRepository.findAllByTransactionNum();
    }

}
