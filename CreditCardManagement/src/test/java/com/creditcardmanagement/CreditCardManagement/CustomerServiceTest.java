package com.creditcardmanagement.CreditCardManagement;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.CustomerAlreadyExists;
import com.creditcardmanagement.CreditCardManagement.exception.CustomerNotFound;
import com.creditcardmanagement.CreditCardManagement.repo.CustomerRepository;
import com.creditcardmanagement.CreditCardManagement.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCustomer_Success() throws CustomerAlreadyExists {
        Customer customer = new Customer();
        customer.setCustomerId(1001);
        customer.setFirst("Monal");
        customer.setLast("Singh");

        when(customerRepository.existsByCustomerId(1001)).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer result = customerService.addCustomer(customer);

        assertEquals(1001, result.getCustomerId());
        assertEquals("Monal", result.getFirst());
        assertEquals("Singh", result.getLast());

        verify(customerRepository, times(1)).existsByCustomerId(1001);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void testAddCustomer_CustomerAlreadyExists() {
        Customer customer = new Customer();
        customer.setCustomerId(1002);
        customer.setFirst("Monal");
        customer.setLast("S");

        when(customerRepository.existsByCustomerId(1002)).thenReturn(true);

        assertThrows(CustomerAlreadyExists.class, () -> customerService.addCustomer(customer));

        verify(customerRepository, times(1)).existsByCustomerId(1002);
        verify(customerRepository, never()).save(any(Customer.class));
    }

    @Test
    void testGetAllCustomer() {
        List<Customer> customerList = Collections.singletonList(new Customer());
        when(customerRepository.findAll()).thenReturn(customerList);

        List<Customer> result = customerService.getAllCustomer();

        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testUpdateCustomer_Success() {
        Customer existingCustomer = new Customer();
        existingCustomer.setCustomerId(1002);
        existingCustomer.setFirst("Monal");
        existingCustomer.setLast("S");

        Customer updatedCustomer = new Customer();
        updatedCustomer.setFirst("Nayan");
        updatedCustomer.setLast("Taori");

        when(customerRepository.findByCustomerId(1002)).thenReturn(existingCustomer);
        when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);

        Customer result = customerService.updateCustomer(1002, updatedCustomer);

        assertEquals("Nayan", result.getFirst());
        assertEquals("Taori", result.getLast());
        assertEquals(1002, result.getCustomerId());

        verify(customerRepository, times(1)).findByCustomerId(1002);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void testUpdateCustomer_CustomerNotFound() {
        when(customerRepository.findByCustomerId(1002)).thenReturn(null);

        assertThrows(CustomerNotFound.class, () -> customerService.updateCustomer(1002, new Customer()));

        verify(customerRepository, times(1)).findByCustomerId(1002);
        verify(customerRepository, never()).save(any(Customer.class));
    }

    @Test
    void testDeleteCustomer_Success() {
        Customer existingCustomer = new Customer();
        existingCustomer.setCustomerId(1002);
        existingCustomer.setFirst("Monal");
        existingCustomer.setLast("S");

        when(customerRepository.findByCustomerId(1002)).thenReturn(existingCustomer);

        customerService.deleteCustomer(1002);

        verify(customerRepository, times(1)).findByCustomerId(1002);
        verify(customerRepository, times(1)).delete(existingCustomer);
    }

    @Test
    void testDeleteCustomer_CustomerNotFound() {
        when(customerRepository.findByCustomerId(1002)).thenReturn(null);

        assertThrows(CustomerNotFound.class, () -> customerService.deleteCustomer(1002));

        verify(customerRepository, times(1)).findByCustomerId(1002);
        verify(customerRepository, never()).delete(any(Customer.class));
    }

    @Test
    void testGetCustomerById_Success() {
        Customer customer = new Customer();
        customer.setCustomerId(1002);
        customer.setFirst("Monal");
        customer.setLast("S");

        when(customerRepository.findByCustomerId(1002)).thenReturn(customer);

        Customer result = customerService.getCustomerById(1002);

        assertNotNull(result);
        assertEquals("Monal", result.getFirst());
        assertEquals("S", result.getLast());
        assertEquals(1002, result.getCustomerId());

        verify(customerRepository, times(1)).findByCustomerId(1002);
    }

    @Test
    void testGetCustomerById_CustomerNotFound() {
        when(customerRepository.findByCustomerId(1002)).thenReturn(null);

        assertThrows(CustomerNotFound.class, () -> customerService.getCustomerById(1002));

        verify(customerRepository, times(1)).findByCustomerId(1002);
    }

}
