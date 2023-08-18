package com.creditcardmanagement.CreditCardManagement.controller;

import com.creditcardmanagement.CreditCardManagement.dto.*;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/transaction")
@CrossOrigin
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;

    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public List<MerchantAmount> getAmountForMerchant() {
        return  transactionsService.getMerchantAmount();
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public List<CityAmount> getAmountForCity() {
        return  transactionsService.getSpendingHistoryByCity();
    }

    @RequestMapping(value = "/Job", method = RequestMethod.GET)
    public List<JobAmount> getAmountByJob() {
        return  transactionsService.getSpendingHistoryByJob();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<CategoryAmount> getCustomerByCategory() {
        return  transactionsService.getSpendingHistoryByCategory();
    }

    @GetMapping("/cityPopulation")
    public List <CityPopulation> getSpendingHistoryByPopulation() {
        return  transactionsService.getSpendingHistoryByPopulation();
    }

    @GetMapping("/{state}")
    public List<StateAmount> getCustomerByState() {
        return  transactionsService.getSpendingHistoryByState();
    }

    @GetMapping("/total_amt/{gender}")
    public List<GenderAmount> getCustomerByGender() {
        return  transactionsService.getSpendingHistoryByGender();
    }

    @GetMapping("/spendingByAmount/{low}/{high}")
    public List<AmountSpending> getSpendingByAmount(@PathVariable double low, @PathVariable double high) {
        return  transactionsService.getSpendingHistoryByAmount(low, high);
    }
    @GetMapping("/topMerchants")
    public List<TopMerchant> getTopMerchants(@RequestParam int limit) {
        return  transactionsService.getTopMerchants(limit);
    }


}