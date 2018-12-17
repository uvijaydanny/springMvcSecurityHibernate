package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Authorities;
import com.luv2code.springsecurity.demo.entity.UserAuth;
import com.luv2code.springsecurity.demo.entity.UserDetails;
import com.luv2code.springsecurity.demo.entity.Users;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	private SessionFactory sf;
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void addUsersAuthorizationDetails(UserDetails userdetails) {
		
		Session session = sf.getCurrentSession();
		Users users = new Users();
		users.setUsername(userdetails.getUsername());
		users.setPassword(userdetails.getPassword());
		users.setEnabled(1);
		session.saveOrUpdate(users);
		
		String userRole = "ROLE_" + userdetails.getRoles();
		UserAuth ua = new UserAuth(userdetails.getUsername(),userRole);

		Authorities authorities = new Authorities();
		authorities.setUserAuth(ua);
		session.saveOrUpdate(authorities);
		
		UserAuth ua2 = new UserAuth(userdetails.getUsername(),"ROLE_EMPLOYEE");

		Authorities authorities2 = new Authorities();
		authorities2.setUserAuth(ua2);
		session.saveOrUpdate(authorities2);
		
		session.saveOrUpdate(userdetails);
		
	}

	@Override
	public List<UserDetails> getUserAuthDetails() {
		Session session = sf.getCurrentSession();
		
		Query query = session.createSQLQuery("select a.username, a.emailid, b.authority as roles from userdetails a, authorities b where a.username = b.username and b.authority <> 'ROLE_EMPLOYEE'")
		.setResultTransformer(Transformers.aliasToBean(UserDetails.class));
		
		List<UserDetails> udList = (List<UserDetails>) query.getResultList();
		
		/*List<Object[]> udList = em.createNativeQuery("select a.username, a.emailid, b.userauth.authority from userdetails a Join authorities b on a.username = b.userauth.username", "UserDetailsMapping").getResultList();
		udList.stream().forEach((record) -> {
		    UserDetails ud = (UserDetails)record[0];
		    Authorities auth = (Authorities) record[1];
		    // do something useful
		});*/
		
		
		return udList;
	}

}
