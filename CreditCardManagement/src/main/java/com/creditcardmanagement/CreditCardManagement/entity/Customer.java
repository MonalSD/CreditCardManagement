package com.creditcardmanagement.CreditCardManagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("customer")
public class Customer {



    //private String _id;
    @Id
    ObjectId id;
    @Field("customer_id")
    private int customerId;
    private String first;
    private String last;
    private String gender;
    private String job;
    private String dob;

    public Customer() {
        // Empty no-arg constructor.
    }

    public Customer(ObjectId id,int customerId, String first, String last, String gender, String job, String dob) {
        this.id = id;
        this.customerId = customerId;
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
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerID) {
        this.customerId = customerId;
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
        return String.format("Customer [id = %s, customerId=%s, first=%s, last=%s, gender=%s, job=%s, dob=%s]", id, customerId, first, last, gender, job, dob);
    }
}


