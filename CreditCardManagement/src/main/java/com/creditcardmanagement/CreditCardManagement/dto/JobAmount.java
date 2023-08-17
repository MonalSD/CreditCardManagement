package com.creditcardmanagement.CreditCardManagement.dto;

public class JobAmount {
    private String Job;
    private double total_amt;

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
