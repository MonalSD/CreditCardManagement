package com.creditcardmanagement.CreditCardManagement.dto;

public class AmountSpending {
    private int customerId;

    private double amt;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
