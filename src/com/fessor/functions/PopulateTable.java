package com.fessor.functions;

import java.util.ArrayList;
import java.util.List;

public class PopulateTable {
	
	
	
	public static List<String> populateTableList(int size, int operation){
		
		List <String> numbers = NumberGenerator.populateList(size/2);
		List<String> equations = EquationDecoder.equationListMaker(size/2, operation);
		
		List<String> populatedRandomList = new ArrayList<String>();
		
		for (String number : numbers) {
			populatedRandomList.add(number);
		}
		
		for (String equation : equations) {
			populatedRandomList.add(equation);
		}
		
		for(int i=0;i<=size;i++){
			
			int arrIndex = (int)((double)populatedRandomList.size() * Math.random());
			String random = populatedRandomList.get(arrIndex);
			populatedRandomList.remove(arrIndex);	
			populatedRandomList.add(random);
		}
		
		return populatedRandomList;
	}
	
	

}
