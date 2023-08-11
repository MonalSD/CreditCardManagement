package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.RecordExistsException;
import com.creditcardmanagement.CreditCardManagement.exception.RecordNotFoundException;
import com.creditcardmanagement.CreditCardManagement.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Insert an employee.
    public Customer insertCustomer(Customer customer) throws RecordExistsException {
        if(customerRepository.existsById(customer.getCustomerID()))
            throw new RecordExistsException("Customer with "+customer.getCustomerID()+"already exists");
        long count = this.customerRepository.count();
        customer.setCustomerID(count+1);
        Customer savedCustomer = customerRepository.save(customer);
        System.out.printf("There are now %d employees\n", customerRepository.count());
        return  savedCustomer;
    }

    // Get all employees.
    public List<Customer> getAllCustomer()
    {
        return this.customerRepository.findAll();
    }
    public Customer getCustomerById(long custid) throws RecordNotFoundException {
        return customerRepository.findById(custid)
                .orElseThrow(()->new RecordNotFoundException("Customer with "+custid+" does not exist"));
    }

    //Update Customer
    public void updateCustomer( Customer custToUpdate) throws RecordNotFoundException {
        System.out.println("UPDATE "+custToUpdate.getCustomerID());
        if(! customerRepository.existsById(custToUpdate.getCustomerID()))
            throw new RecordNotFoundException("Customer with "+custToUpdate.getCustomerID()+" does not exist");
        customerRepository.save(custToUpdate);
    }

    //Delete Customer
    public void deleteCustomer(long customerID) throws RecordNotFoundException {

        if(customerRepository.existsById(customerID))
            throw new RecordNotFoundException("employee with "+customerID+" does not exist");
        customerRepository.deleteById(customerID);
    }
}


