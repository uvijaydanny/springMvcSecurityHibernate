package com.luv2code.springsecurity.demo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthDAOImpl implements UserAuthDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<String> getIntrPanel() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select a.userAuth.username from authorities a where authority in ('ROLE_PANEL','ROLE_MANAGER','ROLE_HR')");
		List<String> intrPanelList = query.list();
		return intrPanelList;
	}

}
