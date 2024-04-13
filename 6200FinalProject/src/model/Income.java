package model;

import java.util.Date;
import java.util.Random;

public class Income extends Transaction{
    int incomeId;
   // double amount;
    //String description;
    Date date;
    IncomeType typeName;
	
    public Income(int incomeId, double amount, Date date, String description,IncomeType typeName) {
		super(amount, date, description);
		this.incomeId = incomeId;
		//this.amount = amount
		this.date = date;
		this.typeName = typeName;
	}
   
    public int getRandomIncomeId() {
    Random ranIncomeId = new Random(); 
    int ranId = ranIncomeId.nextInt(1000);
    return ranId;
    }

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return super.amount;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.description;
	}
    
    

}
