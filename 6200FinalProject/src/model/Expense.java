package model;

import java.util.Date;

public class Expense {
   int expenseId;//multiple ids, each expense item has own expenseId
   UserProfile userId;//only one
   String description;
   String receipt;
   Date date;
   double amount;
   ExpenseType typeName;
   

   public Expense() {
	   this.receipt = receipt;
	   this.date = date;
	   this.amount = amount;
	   this.typeName = typeName;
   }
   
   
   public Expense(int expenseId, UserProfile userId) {
	   this.expenseId = expenseId;
	   this.description = description;
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




}
