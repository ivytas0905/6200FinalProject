package model;

import java.util.ArrayList;
import java.util.List;

public class IncomeType {
     String typeName;
     List<String> typeNamelist;
     public IncomeType(String tm) {
    	 typeName = tm;
    	 List<String> typeNamelist = new ArrayList<>();
    	 typeNamelist.add("Salary");
    	 typeNamelist.add("Freelance");
    	 typeNamelist.add("Investment");
    	 typeNamelist.add("Gift");
     }
     
     public String getIncomeType() {
    	 return typeName;
     }
      
     


}
