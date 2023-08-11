package com.creditcardmanagement.CreditCardManagement.controller;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController
{
    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/customer/greet/get", method = RequestMethod.GET)
    public String greet()
    {
        return "Hey";
    }


    @RequestMapping(path = "/customer/get", method = RequestMethod.GET)
    public List<Customer> findAllCustomers()
    {
        return this.customerService.getAllCustomers();
    }

    @RequestMapping(path = "/customer/post",method = RequestMethod.POST)
    public Customer addCustomer()
    {
        System.out.println("Adding customer");
        //return this.employeeService.addEmployee();
        return new Customer("101",2,"Monal","Singh","F","Analyst","30/08/2000");
    }
}
