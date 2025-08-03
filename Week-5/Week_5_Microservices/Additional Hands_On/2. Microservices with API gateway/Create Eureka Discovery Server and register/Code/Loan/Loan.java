package com.cognizant.loan.model;

public class Loan {
	private String number;
    private double amount;
    private int tenure;
    
    public Loan(String number,double amount,int tenure) {
        this.number=number;
        this.amount=amount;
        this.tenure=tenure;
    }

    public String getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public int getTenure() {
        return tenure;
    }
}
