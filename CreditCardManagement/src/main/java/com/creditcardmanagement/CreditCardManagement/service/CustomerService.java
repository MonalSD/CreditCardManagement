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

    public Customer addCustomer(Customer customer) throws CustomerAlreadyExists {
        if (!isCustomerIdValid(String.valueOf(customer.getCustomerId()))) {
            throw new InvalidDataTypeException(String.valueOf(customer.getCustomerId()), "Invalid customerId. Please provide a valid integer value.");
        }

        if (customerRepository.existsByCustomerId(customer.getCustomerId())) {
            throw new CustomerAlreadyExists("Customer with ID " + customer.getCustomerId() + " already exists.");
        }

        // Add the customer
        return customerRepository.save(customer);
    }
    private boolean isCustomerIdValid(String customerId) {
        try {
            int parsedCustomerId = Integer.parseInt(customerId);
            return parsedCustomerId > 0;
        } catch (NumberFormatException e) {
            return false; // Parsing failed, not a valid integer
        }
    }



    public long getCount(){
        return this.customerRepository.count();
    }
    public List<Customer>getAllCustomer(){
        return this.customerRepository.findAll();
    }
    public Customer updateCustomer(int customerId, Customer dataToUpdate) {
        Customer existingCustomer = customerRepository.findByCustomerId(customerId);
        if (existingCustomer != null) {
            existingCustomer.setCustomerId(dataToUpdate.getCustomerId());
            existingCustomer.setFirst(dataToUpdate.getFirst());
            existingCustomer.setLast(dataToUpdate.getLast());
            existingCustomer.setGender(dataToUpdate.getGender());
            existingCustomer.setJob(dataToUpdate.getJob());
            existingCustomer.setDob(dataToUpdate.getDob());

            return customerRepository.save(existingCustomer);
        } else {
            System.out.println("Customer not found");
            return null;
        }
    }

    public void deleteCustomer(int customerId){
        Customer c =customerRepository.findByCustomerId(customerId);
        if(c!=null){
            customerRepository.delete(c);
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