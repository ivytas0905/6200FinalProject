package model;

public class Lialibility extends Expense {
     double mortgagePrincipal;
     double mortgageRate;
     
     
     public Lialibility(double mp) {
    	 super();
    	 mortgagePrincipal = mp;
    	 
     }
     public double getPrincipal() {
    	 return mortgagePrincipal;
     }
     public double getRate() {
    	 return mortgageRate;
     }
     
     

}
