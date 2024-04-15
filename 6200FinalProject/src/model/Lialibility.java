package model;

import java.util.Date;

public class Lialibility extends Transaction {
     double mortgageTotal;
     double rate;//year
     int term;
     
     
     
     public Lialibility(double amount, Date date, String description,double mt) {
    	 super(amount, date, description);
    	 mortgageTotal = mt;
    	 this.rate = rate;
    	 this.term = term;
    	 
     }
     public double getPrincipal() {
    	 return mortgageTotal;
     }
     public double getRate() {
    	 return rate;
     }
     public int getTerm() {
    	 return term;
     }
//     public double calculateMonthlyInterest() {
//    	 return 
//     }
     public double calculateMonthlyPayment(double mortgageTotal, int term, double rate) {
    	int n = term * 12;//number of payment
    	double r = rate/12;//monthly interest rate
        double futureValue = Math.pow(1+r,n);
        double monthlyTotalPayment = mortgageTotal * r * futureValue/(futureValue-1);
        return monthlyTotalPayment;
    			 
     }
@Override
public double getAmount() {
	// TODO Auto-generated method stub
	return mortgageTotal;
}
@Override
public String getDescription() {
	// TODO Auto-generated method stub
	return "mortgage";
}
    
}
