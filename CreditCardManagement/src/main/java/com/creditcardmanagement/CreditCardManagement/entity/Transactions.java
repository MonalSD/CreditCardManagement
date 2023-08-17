package com.creditcardmanagement.CreditCardManagement.entity;

import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("transaction")
public class Transactions {
    @Id
    private ObjectId id;
    @Field("customer_id")
    private int customerId;
    @Field("trans_num")
    @NotBlank(message = "Transaction number is required")
    private int transactionNum;
    @Field("trans_date_trans_time")
    private String  transDatetransTime;
    private long amt;
    @NotBlank(message = "Enter city")
    private String city;
    @NotBlank(message = "Enter state")
    private String state;
    @Field("city_population")
    private long cityPopulation;
    private String merchant;
    @NotBlank(message = "Enter category")
    private String category;
    private String first;
    private String last;
    @NotBlank(message = "Enter Gender")
    private String gender;
    @Field("Job")
    @NotBlank(message = "Enter Job")
    private String job;
    private String dob;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(int transactionNum) {
        this.transactionNum = transactionNum;
    }

    public String getTransDatetransTime() {
        return transDatetransTime;
    }

    public void setTransDatetransTime(String transDatetransTime) {
        this.transDatetransTime = transDatetransTime;
    }

    public long getAmt() {
        return amt;
    }

    public void setAmt(long amt) {
        this.amt = amt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(long cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Transactions(ObjectId id, int customerId, int transactionNum, String transDatetransTime, long amt, String city, String state, long cityPopulation, String merchant, String category, String first, String last, String gender, String job, String dob) {
        this.id = id;
        this.customerId = customerId;
        this.transactionNum = transactionNum;
        this.transDatetransTime = transDatetransTime;
        this.amt = amt;
        this.city = city;
        this.state = state;
        this.cityPopulation = cityPopulation;
        this.merchant = merchant;
        this.category = category;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", transactionNum=" + transactionNum +
                ", transDatetransTime='" + transDatetransTime + '\'' +
                ", amt=" + amt +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cityPopulation=" + cityPopulation +
                ", merchant='" + merchant + '\'' +
                ", category='" + category + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}

