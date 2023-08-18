package edu.wccnet.jwon1.MP5_pizza.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.jwon1.MP5_pizza.dao.OrderDAO;
import edu.wccnet.jwon1.MP5_pizza.entity.Order;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	@Transactional
	@Override
	public List<Order> getOrders(int customerId) {
		// TODO Auto-generated method stub
		return orderDAO.getOrders(customerId);
	}

	@Transactional
	public void saveOrder(Order order) {
		orderDAO.saveOrder(order);
		
	}

	@Transactional
	public Order getOrder(int id) {
		return orderDAO.getOrder(id);
	}

	@Transactional
	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
		
	}

	
}
