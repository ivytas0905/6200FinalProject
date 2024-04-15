package model;

import java.util.Date;

public class Expense extends Transaction{
   int expenseId;//multiple ids, each expense item has own expenseId
   UserProfile userId;//only one
   //String description;
   String receipt;
  // Date date;
   //double amount;
   ExpenseType typeName;
   

   public Expense(double amount, UserProfile userId2, double amount2, Date date,String description) {
	 super(amount, date, description);
	   this.receipt = receipt;
	   this.userId = userId;
	   this.expenseId = expenseId;
	   //this.date = date;
	   this.amount = amount;
	   this.typeName = typeName;
   }
   
   
  public Expense(int expenseId, UserProfile userId,double amount, Date date,String description) {
   super(amount, date, description);
	   this.expenseId = expenseId;
	   //this.description = description;
	   this.userId = userId;
	   
   }
   

   
   @Override
   public String toString() {
	   return description;
   }
   
   public UserProfile getUserId() {
	   return userId;
   }
   public Date getDate() {
	   return date;
   }


@Override
public String getDescription() {
	
	return "Expense description";
}


@Override
public double getAmount() {
	// TODO Auto-generated method stub
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public int getExpenseId() {
	return expenseId;
}


}
