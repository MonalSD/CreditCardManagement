package com.creditcardmanagement.CreditCardManagement.controller;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.RecordExistsException;
import com.creditcardmanagement.CreditCardManagement.exception.RecordNotFoundException;
import com.creditcardmanagement.CreditCardManagement.service.CustomerService;
import com.creditcardmanagement.CreditCardManagement.utility.StatusMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/customer") //root mapping
@Tag(name="CUSTOMER-CONTROLLER")
public class CustomerRestController
{
    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/customer/greet/get", method = RequestMethod.GET)
    public String greet()
    {
        return "Hey";
    }

    @GetMapping("/{customerID}")
    public Customer getCustomerByID(@PathVariable long customerID)
    {
        try
        {
            return this.customerService.getCustomerById(customerID);
        }
        catch(RecordNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer)
    {
        try {
            Customer customer1 = this.customerService.insertCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
        } catch (RecordExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<Object> updateEmployee(@RequestBody Customer customer)
    {
        Map<StatusMessages, String> map = new HashMap<>();
        try {
            this.customerService.updateCustomer(customer);
            map.put(StatusMessages.SUCCESS, "Customer updated successfully");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
        } catch (RecordNotFoundException e) {
            map.put(StatusMessages.FAILURE, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
        }
    }

    @DeleteMapping("/{customerID}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable long customerID)
    {
        Map<StatusMessages , String> map = new HashMap<>();
        try {
            map.put(StatusMessages.SUCCESS, "Employee deleted successfully");
            this.customerService.deleteCustomer(customerID);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
        } catch (RecordNotFoundException e) {
            map.put(StatusMessages.FAILURE, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
        }
    }
}
