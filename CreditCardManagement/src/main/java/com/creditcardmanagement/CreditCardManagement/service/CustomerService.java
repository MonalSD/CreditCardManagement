package com.creditcardmanagement.CreditCardManagement.service;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.RecordExistsException;
import com.creditcardmanagement.CreditCardManagement.exception.RecordNotFoundException;
import com.creditcardmanagement.CreditCardManagement.repo.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Insert an employee.
    public Customer insertCustomer(Customer customer) throws RecordExistsException {
        if(customerRepository.existsById(customer.getId()))
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
    public Customer getCustomerById(ObjectId id) throws RecordNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Customer with "+id+" does not exist"));
    }

    //Update Customer
    public void updateCustomer( Customer custToUpdate) throws RecordNotFoundException {
        System.out.println("UPDATE "+custToUpdate.getId());
        if(! customerRepository.existsById(custToUpdate.getId()))
            throw new RecordNotFoundException("Customer with "+custToUpdate.getId()+" does not exist");
        customerRepository.save(custToUpdate);
    }

    //Delete Customer
    public void deleteCustomer(ObjectId id) throws RecordNotFoundException {

        if(customerRepository.existsById(id))
            throw new RecordNotFoundException("employee with "+id+" does not exist");
        customerRepository.deleteById(id);
    }
}


