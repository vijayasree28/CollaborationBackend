package com.niit.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl() {
		System.out.println("UserDAOImpl--one");	
		}
 
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	
	
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}


	@Transactional
	public void delete(String userId) {
		User user = new User();
		user.setUserId(userId);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional
	public User get(String userId) {
		String hql = "from User where userId=" + userId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
	@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
		
	}
	
	@Transactional
	public boolean isValidUser(String userId, String password, boolean isAdmin) {
		String hql = "from User where userId= '" + userId + "' and " + " password ='" + password+"'and admin=" +isAdmin;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
