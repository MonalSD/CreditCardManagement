package com.creditcardmanagement.CreditCardManagement;

import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.exception.RecordExistsException;
import com.creditcardmanagement.CreditCardManagement.exception.RecordNotFoundException;
import com.creditcardmanagement.CreditCardManagement.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CreditCardManagementApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CreditCardManagementApplication.class, args);
		CustomerService employeeService = context.getBean(CustomerService.class);
		try
		{
			System.out.println(employeeService.addCustomer(
					new Customer("3553",89,"Shalini","Singh","F","SDE","2000/09/02")));
		}
		catch (RecordExistsException e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println(employeeService.getCustomerCount());

		try
		{
			System.out.println(employeeService.getCustomerId("64d351996d8633aa94378dfe"));
		}
		catch (RecordNotFoundException e)
		{
			throw new RuntimeException(e);
		}


	}

}
