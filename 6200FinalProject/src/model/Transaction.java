package model;

import java.util.Date;

public abstract class Transaction {
      double amount;
      Date date;
      String description;
	
      public Transaction(double amount, Date date, String description) {
		super();
		this.amount = amount;
		this.date = date;
		this.description = description;
	}

	public abstract double getAmount();
	

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	abstract public String getDescription();
		

	public void setDescription(String description) {
		this.description = description;
	}
   
      


}
