package com.fessor.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EquationDecoder {

	static Random random = new Random();
	
	public static int equationDecoder(String equation){
		
		int lenght = equation.length();
		
		char firstChar,secondChar,operation;
		String sNumber1, sNumber2;
		int number1, number2;
		int result = 0;
		
		switch (lenght) {
		case 3:
			firstChar = equation.charAt(0);
			secondChar = equation.charAt(2);
			operation = equation.charAt(1);
			
			sNumber1=Character.toString(firstChar);
			sNumber2=Character.toString(secondChar);
			String sOperation=Character.toString(operation);
			
					
			number1 = Integer.parseInt(sNumber1);
			number2 = Integer.parseInt(sNumber2);
			
			
			if (sOperation.equals("+")){
				result = number1+number2;
			
			}
			
			if (sOperation.equals("-")){
				result = number2-number1;
			
			}
			break;

		case 4:
			
			//if first number
			
			
			
			break;
			
		case 5:
			break;	
		}
		
		return result;
		
	}

	public static String equationMaker(int result, int operation){
		
		
		int value1;
		int value2;
		double doubleRand;
		String output = "error";
		
		
			switch (operation) {
			case 1:
				value1 = random.nextInt(result-1)+1;
				value2 = result-value1;
				output = ""+value1+"+"+value2;
				break;
			
			case 2:
				doubleRand = 5 + (int)(Math.random() * ((result - 5) ));
				value1 = (int)doubleRand;
				value2 = result+value1;
				output = ""+value2+"-"+value1;
			break;

			default:
				break;
			}
			
		
		
		
		return output;
	}
	
	public static List<String> equationListMaker(int listSize, int operation){
		
		List<String> equationsList = new ArrayList<String>();
		
		for (int i = 2; i<listSize+2; i++){
			equationsList.add(equationMaker(i, operation));
		}
		
		for(int i=2;i<listSize+2;i++){
			
			int arrIndex = (int)((double)equationsList.size() * Math.random());
			String random = equationsList.get(arrIndex);
			equationsList.remove(arrIndex);	
			equationsList.add(random);
		}
		
		
		return equationsList;
		
	}
 
	













}
