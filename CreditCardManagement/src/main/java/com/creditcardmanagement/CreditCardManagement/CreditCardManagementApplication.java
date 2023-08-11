package com.creditcardmanagement.CreditCardManagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class CreditCardManagementApplication {
	Logger logger = Logger.getLogger(CreditCardManagementApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(CreditCardManagementApplication.class, args);
	}
}
