package model;

import java.util.Random;

public class Income {
    int incomeId;
    double amount;
    String description;
    String date;
    IncomeType typeName;
	
    public Income(int incomeId, double amount, String date, IncomeType typeName) {
		
		this.incomeId = incomeId;
		this.amount = amount;
		this.date = date;
		this.typeName = typeName;
	}
   
    public int getRandomIncomeId() {
    Random ranIncomeId = new Random(); 
    int ranId = ranIncomeId.nextInt(1000);
    return ranId;
    }
    


}
