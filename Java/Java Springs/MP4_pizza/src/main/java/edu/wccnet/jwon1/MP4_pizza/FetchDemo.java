package edu.wccnet.jwon1.MP4_pizza;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchDemo {

	public static void main(String[] args) {
		Scanner kbInput = new Scanner(System.in);
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Pizza.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			String customerHql = "from Customer c";
			Query<Customer> customerQuery = session.createQuery(customerHql, Customer.class);
			List<Customer> customerResults = customerQuery.list();
			for (Customer customer : customerResults) {
				System.out.println(customer);
			}
			System.out.println("Please pick a customer ID: ");
			
			
			Query<Customer> query = session
					.createQuery("from Customer c "
							+ "where c.id = :customerId", Customer.class);
			query.setParameter("customerId", kbInput.nextInt());
			Customer customer = query.getSingleResult();
			System.out.println(customer.getOrder());
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
