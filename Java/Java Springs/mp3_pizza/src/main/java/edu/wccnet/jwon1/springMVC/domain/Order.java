package edu.wccnet.jwon1.springMVC.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Order {
	@Valid
	@NotNull
	private Customer customer;
	private Pizza pizza;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	

}
