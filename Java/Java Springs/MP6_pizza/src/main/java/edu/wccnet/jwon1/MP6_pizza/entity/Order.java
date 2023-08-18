package edu.wccnet.jwon1.MP6_pizza.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="pizza_order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@JsonManagedReference
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public Order(Customer customer) {
		this.customer = customer;
	}
	public void add(Pizza newPizza) {
		pizzas.add(newPizza);
		newPizza.setOrder(this);
	}
	public void remove(Pizza pizza) {
		pizzas.remove(pizza);
	}
	public Order() {
		
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", pizzas=" + pizzas + "]";
	}
	
	
}
