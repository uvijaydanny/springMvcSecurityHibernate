package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Candidate;

@Repository
public class CandidateDAOImpl implements CandidateDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Candidate> getListofJobCan(String jobname) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Candidate where jobreqid like :jobreqid");
		if (jobname.equalsIgnoreCase("ALL")) {
			query.setParameter("jobreqid", "%%");
		}
		else
		query.setParameter("jobreqid", jobname);
		
		List<Candidate> can_list = (List<Candidate>) query.list();		
		return can_list;
		
		
	}

	@Override
	public void addCandidate(Candidate candidate) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(candidate);
		
	}

	@Override
	public List<String> getJobReqidList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select distinct jobreqid from Candidate");
		List<String> jobreqidList =  (List<String>) query.list();
		return jobreqidList;
	}

	@Override
	public Candidate getCandidateRecord(int candidateId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Candidate where candidateId = :candidateId");
		query.setParameter("candidateId", candidateId);
		Candidate cand = (Candidate) query.getSingleResult();
		
		return cand;
	}

}
