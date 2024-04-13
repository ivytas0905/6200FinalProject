package model;

import java.util.Comparator;

public class IncomeComparator implements Comparator<Income>{

	@Override
	public int compare(Income i1, Income i2) {
		
		return compare(i2, i1);
	}

}
