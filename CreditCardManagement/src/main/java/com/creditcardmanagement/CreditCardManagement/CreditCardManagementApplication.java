package com.creditcardmanagement.CreditCardManagement;


import com.creditcardmanagement.CreditCardManagement.entity.Customer;
import com.creditcardmanagement.CreditCardManagement.repo.CustomerRepository;
import com.creditcardmanagement.CreditCardManagement.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;
import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class CreditCardManagementApplication{
	static Logger logger = Logger.getLogger(CreditCardManagementApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(CreditCardManagementApplication.class, args);
		System.out.println("Application Loaded");
	}

}
