package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.InterviewPanel;
import com.luv2code.springsecurity.demo.entity.PanelCandidates;

@Repository
public class IntrPanelDAOImpl implements IntrPanelDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void addInterPanel(InterviewPanel ipanel) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ipanel);
	}

	@Override
	public InterviewPanel getCandIntrRecord(int candId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from interviewPanel where candidateId = :candidateId");
		query.setParameter("candidateId", candId);
		try {
		InterviewPanel ipanel = (InterviewPanel) query.getSingleResult();
		return ipanel;
		}
		catch(NoResultException nre){
		
		}
		return new InterviewPanel();
	}

	@Override
	public List<PanelCandidates> listPanelCandidates(String panel, String irlevel) {
		
		Session session = sessionFactory.getCurrentSession();
		List<PanelCandidates> pList = new ArrayList<PanelCandidates>();
		if (irlevel.equals("Telephone" ) || irlevel.equals("ALL")) {
		Query query = session
				.createSQLQuery("select b.tableid as intrPanelId, a.candidateId as candidateId, a.firstName as candidateName,'Telephone' as interviewRound,'' as experience, b.telComments as comments, b.telRating as rating, b.telStatus as iStatus, b.telRating as prvStatus from Candidate a, interviewPanel b where a.candidateId = b.candidateId and telPanel like :telPanel")
				.setResultTransformer(Transformers.aliasToBean(PanelCandidates.class));
		if(panel.equals("ALL"))
			query.setParameter("telPanel", "%%");
		else
			query.setParameter("telPanel", panel);
		
		pList.addAll((List<PanelCandidates>) query.getResultList());
		}
		
		if(irlevel.equals("Technical1" ) || irlevel.equals("ALL")) {
		Session session2 = sessionFactory.getCurrentSession();
		Query query2 =
		session2.createSQLQuery("select b.tableid as intrPanelId, a.candidateId as candidateId, a.firstName as candidateName,'Technical1' as interviewRound,'' as experience, b.tech1Comments as comments, b.tech1Rating as rating, b.tech1Status as iStatus,b.telRating as prvStatus from Candidate a, interviewPanel b where a.candidateId = b.candidateId and tech1Panel like :tech1Panel").
		setResultTransformer(Transformers.aliasToBean(PanelCandidates.class));
		if(panel.equals("ALL"))
			query2.setParameter("tech1Panel", "%%");
		else
			query2.setParameter("tech1Panel", panel);
		
		pList.addAll((List<PanelCandidates>)query2.getResultList());
		}
		
		if(irlevel.equals("Technical2" ) || irlevel.equals("ALL")) {
		Session session3 = sessionFactory.getCurrentSession();
		Query query3 =
		session3.createSQLQuery("select b.tableid as intrPanelId, a.candidateId as candidateId, a.firstName as candidateName,'Technical2' as interviewRound,'' as experience, b.tech2Comments as comments, b.tech2Rating as rating, b.tech2Status as iStatus,b.tech1Rating as prvStatus from Candidate a, interviewPanel b where a.candidateId = b.candidateId and tech2Panel like :tech2Panel").
		setResultTransformer(Transformers.aliasToBean(PanelCandidates.class));
		if(panel.equals("ALL"))
			query3.setParameter("tech2Panel", "%%");
		else
			query3.setParameter("tech2Panel", panel);
		
		pList.addAll((List<PanelCandidates>)query3.getResultList());
		}
		
		if(irlevel.equals("Managerial" ) || irlevel.equals("ALL")) {
		Session session4 = sessionFactory.getCurrentSession();
		Query query4 =
		session4.createSQLQuery("select b.tableid as intrPanelId, a.candidateId as candidateId, a.firstName as candidateName,'Managerial' as interviewRound,'' as experience, b.mgrComments as comments, b.mgrRating as rating, b.mgrStatus as iStatus, b.tech2Rating as prvStatus from Candidate a, interviewPanel b where a.candidateId = b.candidateId and mgrPanel like :mgrPanel").
		setResultTransformer(Transformers.aliasToBean(PanelCandidates.class));
		if(panel.equals("ALL"))
			query4.setParameter("mgrPanel", "%%");
		else
			query4.setParameter("mgrPanel", panel);
		
		pList.addAll((List<PanelCandidates>)query4.getResultList());
		}
		
		if(irlevel.equals("HR" ) || irlevel.equals("ALL")) {
		Session session5 = sessionFactory.getCurrentSession();
		Query query5 =
		session5.createSQLQuery("select b.tableid as intrPanelId, a.candidateId as candidateId, a.firstName as candidateName,'HR' as interviewRound,'' as experience, b.hrComments as comments, b.hrRating as rating, b.hrStatus as iStatus, b.mgrRating as prvStatus from Candidate a, interviewPanel b where a.candidateId = b.candidateId and hrPanel like :hrPanel").
		setResultTransformer(Transformers.aliasToBean(PanelCandidates.class));
		if(panel.equals("ALL"))
			query5.setParameter("hrPanel", "%%");
		else
			query5.setParameter("hrPanel", panel);
		
		pList.addAll((List<PanelCandidates>)query5.getResultList());
		}
		
		return pList;
	}

	@Override
	public InterviewPanel getInterviewPanelRec(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		InterviewPanel ipanel = session.get(InterviewPanel.class, id);
		
		return ipanel;
	}
	
}
