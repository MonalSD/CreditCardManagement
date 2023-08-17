package com.creditcardmanagement.CreditCardManagement.controller;

import com.creditcardmanagement.CreditCardManagement.dto.*;
import com.creditcardmanagement.CreditCardManagement.entity.Transactions;
import com.creditcardmanagement.CreditCardManagement.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;
    @RequestMapping(value="/merchant",method = RequestMethod.GET)
    public List<MerchantAmount> getAmountForMerchant(@PathVariable String merchant)
    {
        return transactionsService.getMerchantAmount();
    }
    @RequestMapping(value="/city",method = RequestMethod.GET)
    public List<CityAmount> getAmountForCity(@PathVariable String city)
    {
        return transactionsService.getSpendingHistoryByCity();
    }
    @RequestMapping(value="/Job",method = RequestMethod.GET)
    public List<JobAmount> getAmountForJob(@PathVariable String job)
    {
        return transactionsService.getSpendingHistoryByJob();
    }
    @RequestMapping(value="/category",method = RequestMethod.GET)
    public List<CategoryAmount> getCustomerByCategory(@PathVariable String category)
    {
        return transactionsService.getSpendingHistoryByCategory();
    }
    @GetMapping("/city_population")
    public <city_population> List<Transactions> getPopulationByCity(@PathVariable String city)
    {

        return transactionsService.getPopulationByCity(city);
    }
    @GetMapping("/total_amt/{state}")
    public List<StateAmount> getCustomerByState(@PathVariable String state)
    {
        return transactionsService.getSpendingHistoryByState();
    }
    @GetMapping("/total_amt/{gender}")
    public List<GenderAmount> getCustomerByGender(@PathVariable String gender)
    {
        return transactionsService.getSpendingHistoryByGender();
    }
    @GetMapping("/spendingByAmount/{low}/{high}")
    public List<AmountSpending> getSpendingByAmount(@PathVariable double low,@PathVariable double high)
    {
        return transactionsService.getSpendingHistoryByAmount(low,high);
    }
    @GetMapping("/topMerchants")
    public List<TopMerchant> getTopMerchants(@RequestParam int limit)
    {
        return transactionsService.getTopMerchants(limit);
    }

}
