package edu.wccnet.jwon1.MP6_pizza.dao;

import java.util.List;

import edu.wccnet.jwon1.MP6_pizza.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomer(String sort);
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int id);
	

}
