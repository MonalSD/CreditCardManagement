package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.CustomerAlreadyExists;
import com.creditcardmanagement.CreditCardManagement.repo.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer addCustomer(@Valid Customer c) throws CustomerAlreadyExists {
        if (repo.existsById((c.getId())))
            throw new CustomerAlreadyExists("Customer with " + c.getCustomerId() + " already exists");
        return repo.save(c);
    }



    public long getCount(){
        return this.repo.count();
    }
    public List<Customer>getAllCustomer(){
        return this.repo.findAll();
    }
    public Customer updateCustomer(int customerId, @Valid Customer dataToUpdate) {
        Customer existingCustomer = repo.findByCustomerId(customerId);
        if (existingCustomer != null) {

            // Ensures customerId is unchanged
            dataToUpdate.setCustomerId(existingCustomer.getCustomerId());
            // It takes the original customerId

            return repo.save(dataToUpdate);
        } else {
            System.out.println("Customer not found");
            return null;
        }
    }

    public void deleteCustomer(int customerId){
        Customer c =repo.findByCustomerId(customerId);
        if(c!=null){
            repo.save(c);
        }
        else
            System.out.println("not found");
    }

    public Customer getCustomerById(int  customerId)  {
        System.out.println(customerId + "Printing");
        Customer c = repo.findByCustomerId(customerId);
        return c;
    }

    public List<Customer> getCustomerByName(String customerName)  {
        System.out.println(customerName+ " Printing from service class");
        List<Customer> customerList = repo.findByFirstName(customerName);
        return customerList;
    }
    public List<Customer> getCustomerByGender(String customerGender)  {

        List<Customer> customerList = repo.findByGender(customerGender);
        return customerList;
    }
    public List<Customer> getCustomerByJob(String customerJob)  {

        List<Customer> customerList = repo.findByJob(customerJob);
        return customerList;
    }
    public List<Customer> getCustomerByLastName(String customerLastName)  {
        System.out.println(customerLastName + " Printing from service class");
        List<Customer> customerList = repo.findByLastName(customerLastName);
        return customerList;
    }


    public boolean existsByCustomerId(int customerId) {
        return repo.existsByCustomerId(customerId);
    }



}