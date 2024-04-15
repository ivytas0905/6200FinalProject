package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Record {
	//Expense expenseId;
	ArrayList<Expense> expenselist;
	ArrayList<Income> incomelist;
	ArrayList<Lialibility> monthlyMortgage;
	
	
     public Record() {
		expenselist = new ArrayList<>();
		incomelist = new ArrayList<>();	
		monthlyMortgage = new ArrayList<>();	
	}


	public ArrayList<Expense> getExpenselist() {
		return expenselist;
	}


	public void setExpenselist(ArrayList<Expense> expenselist) {
		this.expenselist = expenselist;
	}


	public ArrayList<Income> getIncomelist() {
		return incomelist;
	}


	public void setIncomelist(ArrayList<Income> incomelist) {
		this.incomelist = incomelist;
	}


	public ArrayList<Lialibility> getMonthlyMortgage() {
		return monthlyMortgage;
	}


	public void setMonthlyMortgage(ArrayList<Lialibility> monthlyMortgage) {
		this.monthlyMortgage = monthlyMortgage;
	}
    
    public Expense addNewExpense(int expenseId, UserProfile userId,double amount, Date date,String description) {
    	Expense e = new Expense(expenseId, userId,amount, date, description);
    	expenselist.add(e);
    	return e;
    		
    }
    public Income addNewIncome(int incomeId, UserProfile userId,double amount, Date date,String description,IncomeType typeName) {
    	 Income i = new Income(incomeId, amount, date, description,typeName);
    	 incomelist.add(i);
    	 return i;
    }
    
    public void deleteExpense(int expenseId, UserProfile userId,double amount, Date date,String description) {
    	Expense e = new Expense(expenseId, userId,amount, date, description);
    	expenselist.remove(e);
    }
    
    public void deleteIncome(int incomeId, UserProfile userId,double amount, Date date,String description, IncomeType typeName) {
    	Income e = new Income(incomeId, amount, date, description, typeName);
    	expenselist.remove(e);
    }
    
    
    public boolean modifyExpenseAmount(int expenseId,double newAmount) {
    	for (Expense e: expenselist) {
    		if(e.getExpenseId()==expenseId) {
    			return true;
    		}
    	}
        return false;
    }
    
    public boolean modifyIncomeAmount(int incomeId,double newAmount) {
    	for(Income i: incomelist) {
    		if(i.getIncomeId() == incomeId) {
    			return true;
    		}
    	}
        return false;
    }
    public List<Expense> searchExpenses(Integer expenseId, Date date,Double amount,String description){
    
    	return expenselist.stream()
    			.filter(e ->(expenseId == null ||e.getExpenseId() == expenseId)
    			&&(date == null || e.getDate().equals(date))
    			&&(amount == null || e.getAmount()== amount)
                &&(description == null || e.getDescription().contains(description)))
    			.collect(Collectors.toList());
    
    
    }
    public List<Income> searchIncomes(Integer incomeId, Date date,Double amount,String description){
   
    	return incomelist.stream()
    			.filter(e ->(incomeId== null ||e.getIncomeId() == incomeId)
    			&&(date == null || e.getDate().equals(date))
    			&&(amount == null || e.getAmount()== amount)
                &&(description == null || e.getDescription().contains(description)))
    			.collect(Collectors.toList());
    
    
    }
    
    
    public void generateExpenseReport(ArrayList<Expense> expenses) {
    	ArrayList<Expense> expenselist = expenses;
    	ExpenseComparator comparator = new ExpenseComparator();
    	Collections.sort(expenselist, comparator);
    	System.out.println("Expense Report:");
    	System.out.println("---------------");
    	
    	double totalExpense = 0;
    	for(Expense e: expenselist) {
    		totalExpense += e.getAmount();
    	}
        System.out.printf("Total expense: %.2f%n", totalExpense);
    }
    
    public void generateIncomeReport(ArrayList<Income> incomes) {
    	ArrayList<Income> incomelist = incomes;
    	IncomeComparator comparator = new IncomeComparator();
    	Collections.sort(incomelist, comparator);
    	System.out.println("Income Report:");
    	System.out.println("---------------");
    	
    	double totalIncome = 0;
    	for(Income i: incomelist) {
    		totalIncome += i.getAmount();
    	}
    	System.out.printf("Total expense: %.2f%n", totalIncome);
    }
    
    public double calculateBalance(UserProfile userId, String un, String pw,Date startingOfMonth, Date endingOfMonth) {
        UserProfile up = new UserProfile(un,pw);
        boolean isValid = up.isValidUser("username", "password");
    	double sum = 0;
    	if (!isValid) {
    		return 0;
    	}
    	for(Expense e: expenselist) {
    		if(e != null && e.getDate().compareTo(startingOfMonth)>= 0 && e.getDate().compareTo(endingOfMonth)<= 0) {
    			sum += e.getAmount();
    		}
    	}
    	double incomeSum = 0;
        for(Income i: incomelist) {
        	if(i != null&& i.getDate().compareTo(startingOfMonth)>= 0 && i.getDate().compareTo(endingOfMonth)<= 0) {
        		incomeSum += i.getAmount();
        	}
        }
      double result = incomeSum - sum;
      return result;
    }
}
