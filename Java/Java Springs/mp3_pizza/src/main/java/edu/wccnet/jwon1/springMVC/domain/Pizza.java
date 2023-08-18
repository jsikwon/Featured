package edu.wccnet.jwon1.springMVC.domain;

import java.util.ArrayList;

public class Pizza {
	
	private String size;
	private ArrayList<String> toppings = new ArrayList<String>();
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public ArrayList<String> getToppings() {
		return toppings;
	}
	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}

}
