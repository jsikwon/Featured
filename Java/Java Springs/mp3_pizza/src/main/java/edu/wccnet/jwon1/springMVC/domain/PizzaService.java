package edu.wccnet.jwon1.springMVC.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PizzaService {
	
	public Map<String, String> populateSize(){
		Map<String, String> sizeList = new LinkedHashMap<String, String>();
		sizeList.put("Small", "Small");
		sizeList.put("Medium", "Medium");
		sizeList.put("Large", "Large");
		sizeList.put("Party", "Party");
		
		return sizeList;
	}

	public Map<String, String> populateTopping(){
		Map<String, String> toppingList = new LinkedHashMap<String, String>();
		toppingList.put("Chicken", "Chicken");
		toppingList.put("Mushroom", "Mushroom");
		toppingList.put("Pepperoni", "Pepperoni");
		toppingList.put("Onion", "Onion");
		toppingList.put("Pineapple", "Pineapple");
		
		return toppingList;
	}
	
	public Map<String, String> populateState(){
		Map<String, String> stateList = new LinkedHashMap<String, String>();
		stateList.put("MI", "MI");
		stateList.put("NY", "NY");
		stateList.put("IL", "IL");
		stateList.put("OH", "OH");
		stateList.put("CA", "CA");
		
		return stateList;
	}
}
