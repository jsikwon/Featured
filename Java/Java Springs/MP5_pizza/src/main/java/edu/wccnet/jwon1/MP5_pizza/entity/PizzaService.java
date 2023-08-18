package edu.wccnet.jwon1.MP5_pizza.entity;

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
		toppingList.put("Bacon", "Bacon");
		toppingList.put("Sausage", "Sausage");
		toppingList.put("Ham", "Ham");
		toppingList.put("Pepperoni", "Pepperoni");
		toppingList.put("Onion", "Onion");
		toppingList.put("Hot Peppers", "Hot Peppers");
		toppingList.put("Olives", "Olives");
		toppingList.put("Tomato", "Tomato");
		toppingList.put("Pineapple", "Pineapple");
		toppingList.put("Mushroom", "Mushroom");
		
		return toppingList;
	}
	
	public Map<String, String> populateState(){
		Map<String, String> stateList = new LinkedHashMap<String, String>();
		stateList.put("MI", "MI");
		stateList.put("OH", "OH");
		stateList.put("IN", "IN");
		stateList.put("IL", "IL");
		stateList.put("WI", "WI");
		
		return stateList;
	}
	
}
