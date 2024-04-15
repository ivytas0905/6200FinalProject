package model;

import java.util.Comparator;

public class ExpenseComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense e1, Expense e2) {
		
			return Double.compare(e2.amount, e1.amount);
	
	}
    


}
