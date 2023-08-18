package edu.wccnet.jwon1.MP4_pizza;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Pizza.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Customer jun = new Customer("Jun", "Won", "803 E. Kingsley St.", "Ann Arbor", "MI", "48104");
			Pizza pizza1 = new Pizza("L", "Bacon");
			Pizza pizza2 = new Pizza("M", "Pineapple");
			
			Customer victoria = new Customer("Victoria", "Rose", "2705 E. Morgan St.", "Ann Arbor", "MI", "48105");
			Pizza pizza3 = new Pizza("S", "Mushroom");
			
			Order order1 = new Order(jun);
			order1.add(pizza1);
			order1.add(pizza2);
			
			session.persist(order1);
			
			Order order2 = new Order(victoria);
			order2.add(pizza3);
			
			session.persist(order2);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
