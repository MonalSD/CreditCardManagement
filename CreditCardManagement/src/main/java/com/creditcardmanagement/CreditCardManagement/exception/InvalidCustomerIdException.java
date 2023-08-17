package com.creditcardmanagement.CreditCardManagement.exception;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException(String message) {
        super(message);
    }
}
