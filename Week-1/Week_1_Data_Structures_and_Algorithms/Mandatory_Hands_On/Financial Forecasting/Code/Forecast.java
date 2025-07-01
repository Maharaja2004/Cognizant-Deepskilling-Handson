package FinancialForecasting;
import java.util.*;
public class Forecast {
   
	public static double calculate(double principle,double rate,int years) {
		
		if(years==0) {
			return principle;
		}
		else {
			return calculate(principle,rate,years-1)*(1+rate);
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the principal: ");
		double principal=sc.nextDouble();
		
		System.out.println("Enter the rate: ");
		double rate=sc.nextDouble();
		
		System.out.println("Enter the years:10");
		int years=sc.nextInt();
		
		double futurevalue=calculate(principal,rate,years);
		System.out.println("Predicted value:"+futurevalue);
	}
}
