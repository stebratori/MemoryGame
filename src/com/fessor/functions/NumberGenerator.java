package com.fessor.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

	static Random random = new Random();
	
	public static List<String> populateList(int list_size){
		
		final List<String> list = new ArrayList<String>();
		
		for(int i=2;i<list_size+2;i++){
			list.add(""+i);
		}
		for(int i=2;i<list_size+2;i++){
			
			int arrIndex = (int)((double)list.size() * Math.random());
			String random = list.get(arrIndex);
			list.remove(arrIndex);	
			list.add(random);
		}
		
		return list;
		
		
	}
	
	public static String generateRandom(int result, int from, int to){
		
		int rand = random.nextInt(to - from)+from;
		
			if (rand == result){
				generateRandom(result,from,to);
			}	
			
		return rand+"";
		
	}
	
	public static String generateRandom(int result, String random1, int from, int to){
		
		int rand = random.nextInt(to - from)+from;
		if (rand == Integer.parseInt(random1) || rand == result){
			generateRandom(result, random1,from,to);
		}
		return rand+"";
		
	}

	public static String generateRandom(int result,String random1, String random2, int from, int to){
	
		int rand = random.nextInt(to - from)+from;
		if (rand == Integer.parseInt(random2) || rand == Integer.parseInt(random1) || rand == result){
			generateRandom(result,random1,random2,from,to);
		}
		return rand+"";
	
	
	}
	
}
