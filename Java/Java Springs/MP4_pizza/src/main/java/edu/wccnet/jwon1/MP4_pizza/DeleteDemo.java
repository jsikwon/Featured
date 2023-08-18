package edu.wccnet.jwon1.MP4_pizza;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteDemo {

	public static void main(String[] args) {
		Scanner kbInput = new Scanner(System.in);
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Pizza.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			String orderHql = "from Order o";
			Query<Order> orderQuery = session.createQuery(orderHql, Order.class);
			List<Order> orderResults = orderQuery.list();
			for (Order order : orderResults) {
				System.out.println(order);
			}
			
			System.out.println("Please pick an order ID: ");
			
			Order order = session.get(Order.class, kbInput.nextInt());
			session.remove(order);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}

	}

}
