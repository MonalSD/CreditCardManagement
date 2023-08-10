package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.RecordExistsException;
import com.creditcardmanagement.CreditCardManagement.exception.RecordNotFoundException;
import com.creditcardmanagement.CreditCardManagement.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public long getCustomerCount() {
        return customerRepository.count();
    }


    public Customer addCustomer(Customer customer) throws RecordExistsException {
        if (customerRepository.existsById(customer.getCustomerID()))
            throw new RecordExistsException("Employee with " + customer.getCustomerID() + " already exists");
        Customer saveEntity = this.customerRepository.save(customer);
        return saveEntity;
    }

    public Customer getCustomerId(long custid) throws RecordNotFoundException {
        Optional<Customer> optCust = customerRepository.findById(custid);
        if (optCust.isPresent())
            return optCust.get();
        throw new RecordNotFoundException("Employee with " + custid + " does not exists");
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer) throws RecordNotFoundException {
        Optional<Customer> customerDb = this.customerRepository.findById(customer.getCustomerID());
        if (customerDb.isPresent()) {
            Customer customerUpdate = customerDb.get();
            customerUpdate.setCustomer_id(customer.getCustomerID());
            customerUpdate.setFirst(customer.getFirst());
            customerUpdate.setLast(customer.getLast());
            customerUpdate.setGender(customer.getGender());
            customerUpdate.setJob(customer.getJob());
            customerUpdate.setDob(customer.getDob());
            customerRepository.save(customerUpdate);
            return customerUpdate;
        } else {
            throw new RecordNotFoundException("Record not found with id : " + customer.getCustomerID());
        }
    }

    public void deleteCustomer(long customerID) throws RecordNotFoundException {
        Optional<Customer> customerDb = this.customerRepository.findById(customerID);

        if (customerDb.isPresent()) {
            this.customerRepository.delete(customerDb.get());
        } else {
            throw new RecordNotFoundException("Record not found with id : " + customerID);
        }
    }
}


