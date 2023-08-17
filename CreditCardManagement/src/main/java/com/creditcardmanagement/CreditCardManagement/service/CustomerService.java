package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.*;
import com.creditcardmanagement.CreditCardManagement.repo.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(@Valid Customer c) throws CustomerAlreadyExists {
        if (customerRepository.existsById((c.getId())))
            throw new CustomerAlreadyExists("Customer with " + c.getCustomerId() + " already exists");
        return customerRepository.save(c);
    }



    public long getCount(){
        return this.customerRepository.count();
    }
    public List<Customer>getAllCustomer(){
        return this.customerRepository.findAll();
    }
    public Customer updateCustomer(int customerId, @Valid Customer dataToUpdate) {
        Customer existingCustomer = customerRepository.findByCustomerId(customerId);
        if (existingCustomer != null) {

            // Ensures customerId is unchanged
            dataToUpdate.setCustomerId(existingCustomer.getCustomerId());
            // It takes the original customerId

            return customerRepository.save(dataToUpdate);
        } else {
            System.out.println("Customer not found");
            return null;
        }
    }

    public void deleteCustomer(int customerId){
        Customer c =customerRepository.findByCustomerId(customerId);
        if(c!=null){
            customerRepository.save(c);
        }
        else
            System.out.println("not found");
    }

    public Customer getCustomerById(int  customerId)  {
        System.out.println(customerId + "Printing");
        Customer c = customerRepository.findByCustomerId(customerId);
        return c;
    }

    public List<Customer> getCustomerByFirst(String customerName)  {
        System.out.println(customerName+ " Printing from service class");
        List<Customer> customerList = customerRepository.findByFirst(customerName);
        return customerList;
    }
    public List<Customer> getCustomerByGender(String customerGender)  {

        List<Customer> customerList = customerRepository.findByGender(customerGender);
        return customerList;
    }
    public List<Customer> getCustomerByJob(String customerJob)  {

        List<Customer> customerList = customerRepository.findByJob(customerJob);
        return customerList;
    }
    public List<Customer> getCustomerByLast(String customerLastName)  {
        System.out.println(customerLastName + " Printing from service class");
        List<Customer> customerList = customerRepository.findByLast(customerLastName);
        return customerList;
    }


    public boolean existsByCustomerId(int customerId) {
        return customerRepository.existsByCustomerId(customerId);
    }



}