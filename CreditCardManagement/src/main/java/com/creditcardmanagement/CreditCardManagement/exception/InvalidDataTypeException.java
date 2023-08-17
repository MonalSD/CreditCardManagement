package com.creditcardmanagement.CreditCardManagement.exception;

public class InvalidDataTypeException extends RuntimeException{
    public InvalidDataTypeException(String fieldName, String value) {
        super("Invalid data type for field '" + fieldName + "': " + value);
    }
}
