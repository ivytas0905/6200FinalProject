package model;

import java.util.ArrayList;

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
    
//    public void addNewExpense(expenseId,userId) {
//    	Expense e = new Expense(expenseId, userId);
//    	expenselist.add(e);
//    		
//    }
//    public void deleteExpense() {
//    	Expense e = new Expense();
//    	expenselist.remove(e);
//    }
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

}
