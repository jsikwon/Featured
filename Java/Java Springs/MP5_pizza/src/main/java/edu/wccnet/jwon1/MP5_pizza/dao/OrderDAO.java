package edu.wccnet.jwon1.MP5_pizza.dao;

import java.util.List;

import edu.wccnet.jwon1.MP5_pizza.entity.Order;

public interface OrderDAO {
	
	public List<Order> getOrders(int customerId);
	
	public void saveOrder(Order order);
	
	public Order getOrder(int id);
	
	public void deleteOrder(int id);
	

}
