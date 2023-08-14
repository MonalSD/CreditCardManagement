package com.creditcardmanagement.CreditCardManagement.controller;

import com.creditcardmanagement.CreditCardManagement.dto.CategoryTransactions;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;

    @GetMapping
    public Transactions getAllTransactions(){
        return transactionsService.getAllTransactions();
    }
    @GetMapping(value = "/{transId}")
    public List<Transactions> getCustomers(@PathVariable Long transId)
    {
        return transactionsService.getCustomersById(transId);
    }
    @GetMapping(value = "/salesbycategory")
    public List<CategoryTransactions> getCategoryTransactions(){
        return transactionsService.getCategoryTransactions();
    }

}
