package com.cognizant.loan.model;

public class Loan {
   private String number;
   private String type;
   private double loan;
   private double emi;
   private int tenure;
   
   
   public Loan(String num,String type,double loan,double emi,int ten) {
	   this.number=num;
	   this.type=type;
	   this.loan=loan;
	   this.emi=emi;
	   this.tenure=ten;
   }
   
   public String getNumber() {
	   return number;
   }
   public String getType() {
	   return type;
   }
   public double getLoan() {
	   return loan;
   }
   public double getEmi() {
	   return  emi;
   }
   public int getTenure() {
	   return tenure;
   }
}
