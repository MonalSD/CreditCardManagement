package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.dto.CategoryTransactions;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionsDALMongoTemplate;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {
    @Autowired
    private TransactionsDALMongoTemplate dao;
    public List<Transactions> getAllTransactions(){
        return dao.getAllTransactions();
    }

    public Transactions getCustomersById(Long TransId){
        return dao.getCustomersById(TransId);
    }

    public List<CategoryTransactions> getCategoryTransactions(){
        return dao.getCategoryTransactions();
    }

}
