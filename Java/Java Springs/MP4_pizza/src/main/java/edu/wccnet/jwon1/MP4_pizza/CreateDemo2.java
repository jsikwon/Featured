package edu.wccnet.jwon1.MP4_pizza;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Pizza.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Customer jun = session.get(Customer.class, 1);
			
			Pizza pizza1 = new Pizza("L", "Pepperoni, Onion");
			Order order = new Order(jun);
			order.add(pizza1);
			
			
			session.persist(order);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
