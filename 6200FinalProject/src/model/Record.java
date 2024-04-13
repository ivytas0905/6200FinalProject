package model;

import java.util.ArrayList;
import java.util.Date;

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
    public void deleteExpense(int expenseId, UserProfile userId,double amount, Date date,String description) {
    	Expense e = new Expense(expenseId, userId,amount, date, description);
    	expenselist.remove(e);
    }
//    public void generateOrderReport(ArrayList<Order> orders){
//        ArrayList<Order> orderlist = orders;
//        OrderSummary ordersummary ;
//        
//        OrderSummaryComparator comparator = new OrderSummaryComparator();
//        
//        for(Order order: orderlist){
//            ordersummary = new OrderSummary(order);
//            ordersummarylist.add(ordersummary);
//        }
//        Collections.sort(ordersummarylist, comparator);
//    }
    
    public void generateExpenseReport(ArrayList<Expense> expenses) {
    	ArrayList<Expense> expenselist = expenses;
    	ExpenseComparator comparator = new ExpenseComparator();
    	
    	for(Expense e: expenselist) {
    		
    	}
    
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
