package edu.wccnet.jwon1.MP5_pizza.Service;

import java.util.List;

import edu.wccnet.jwon1.MP5_pizza.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(String sort);
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int id);
}
