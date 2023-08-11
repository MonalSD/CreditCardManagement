package com.creditcardmanagement.CreditCardManagement;


import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class CreditCardManagementApplication {
	Logger logger = Logger.getLogger(CreditCardManagementApplication.class.getSimpleName());

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(CreditCardManagementApplication.class, args);
		CustomerService customerService = context.getBean(CustomerService.class);
		System.out.println("Application Loaded");


	}
}
