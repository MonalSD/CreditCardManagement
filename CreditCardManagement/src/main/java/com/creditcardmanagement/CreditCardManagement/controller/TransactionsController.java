package com.creditcardmanagement.CreditCardManagement.controller;

import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/merchant/{customerMerchant}")
    public ResponseEntity<List<Transactions>> getCustomerByMerchant(@PathVariable String customerMerchant){
        List<Transactions> customerList = transactionsService.getSpendingHistoryByMerchant(customerMerchant);
        return ResponseEntity.ok(customerList);
    }
    @GetMapping("/city/{customerCity}")
    public ResponseEntity<List<Transactions>> getCustomerByCity(@PathVariable String customerCity){
        List<Transactions> customerList = transactionsService.getSpendingHistoryByCity(customerCity);
        return ResponseEntity.ok(customerList);
    }
    @GetMapping("/transactionStatus/{state}")
    public ResponseEntity<List<Transactions>> getCustomerByState(@PathVariable String state){
        List<Transactions> customerList = transactionsService.getSpendingHistoryByState(state);
        return ResponseEntity.ok(customerList);
    }
    @GetMapping("/{transNum}")
    public List<Transactions> getAllByTransactionNum()
    {
        return transactionsService.getAllByTransactionNum();
    }

}
