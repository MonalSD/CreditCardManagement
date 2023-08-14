package com.creditcardmanagement.CreditCardManagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

    //private String _id;
    @Id
    private ObjectId id;
    private long customerID =-1;
    private String first;
    private String last;
    private String gender;
    private String job;
    private String dob;

    public Customer() {
        // Empty no-arg constructor.
    }

    public Customer(int customerID, String first, String last, String gender, String job, String dob) {
        this.customerID = customerID;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }
    public Customer(String first, String last, String gender, String job, String dob) {

        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("Customer [customerID=%s, first=%s, last=%s, gender=%s, job=%s, dob=%s]", customerID, first, last, gender, job, dob);
    }
}


