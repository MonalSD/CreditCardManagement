package com.creditcardmanagement.CreditCardManagement.controller;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController
{
    private CustomerService customerService;

    @RequestMapping(path = "/customer/greet/get", method = RequestMethod.GET)
    public String greet()
    {
        return "Hey";
    }


    @RequestMapping(path = "/customer/get", method = RequestMethod.GET)
    public List<Customer> findAllEmployees()
    {
        return this.customerService.getAllCustomers();
    }

    @RequestMapping(path = "/employees/post",method = RequestMethod.POST)
    public Customer addCustomer()
    {
        System.out.println("Adding employees");
        //return this.employeeService.addEmployee();
        return new Customer(101,2,"Monal","Singh","F","Analyst","30/08/2000");
    }
}
