package edu.wccnet.jwon1.MP6_pizza.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.jwon1.MP6_pizza.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer(String sort) {
		Session session = sessionFactory.getCurrentSession();
		if(sort == null) {
			sort = "last_name";
		}
		Query<Customer> query = session.createQuery("from Customer c order by " + sort, Customer.class);
		return query.getResultList();
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	
	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("delete from Customer where id = :id", Customer.class);
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
