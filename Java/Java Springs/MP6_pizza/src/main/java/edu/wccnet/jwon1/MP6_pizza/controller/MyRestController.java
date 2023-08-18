package edu.wccnet.jwon1.MP6_pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.jwon1.MP6_pizza.Service.CustomerService;
import edu.wccnet.jwon1.MP6_pizza.Service.OrderService;
import edu.wccnet.jwon1.MP6_pizza.entity.Customer;
import edu.wccnet.jwon1.MP6_pizza.entity.Order;

@RestController
@RequestMapping("/api")
public class MyRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers(null);
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		for (Customer customer : getCustomers()) {
			if(customer.getId() == customerId)
				return customer;
		}
		throw new NotFoundException("Customer id not found. id: " + customerId);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	@GetMapping("/orders")
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getOrder(@PathVariable int orderId) {
		for (Order order : getOrders()) {
			if(order.getId() == orderId)
				return order;
		}
		throw new NotFoundException("Order id not found. id: " + orderId);
		
	}
	
	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order order) {
		order.setId(0);
		orderService.saveOrder(order);
		return order;
	}
	
	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return order;
	}
	
	@DeleteMapping("/orders/{customerId}")
	public void deleteOrder(@PathVariable int customerId) {
		orderService.deleteOrder(customerId);
	}
	@ExceptionHandler
	public ResponseEntity<MyAPIErrorResponse> handleException(NotFoundException e){
		MyAPIErrorResponse error = new MyAPIErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<MyAPIErrorResponse> handleException(Exception e){
		MyAPIErrorResponse error = new MyAPIErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
