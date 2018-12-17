package com.luv2code.springsecurity.demo.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.luv2code.springsecurity.demo.entity.JobReq;
import com.luv2code.springsecurity.demo.entity.JobReqId;


@Repository
public class JobReqDAOImpl implements JobReqDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<JobReq> listOfJobReq() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<JobReq> query = session.createQuery("from JobReq",JobReq.class);
		List<JobReq> listJobReq = query.getResultList();
		return listJobReq;
	}

	@Override
	public void createJobReq(JobReq jobReq) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(jobReq);
		System.out.println("Record Created in JOBREQ");
	}

	@Override
	public JobReq getJobDetails(int reqId) {
		Session session = sessionFactory.getCurrentSession();
		JobReq jobreq = session.get(JobReq.class, reqId);
		return jobreq;
	}

	@Override
	public void updateJobReq(JobReq jobreq) {
		Session session = sessionFactory.getCurrentSession();
		session.update(jobreq);
	}

	@Override
	public List<JobReq> listUserJobReq(String userName,String designation, String jobstatus) {
		Session session = sessionFactory.getCurrentSession();		
		Query query;
		if (designation.equals("ROLE_ADMIN")){
			query = session.createQuery("from JobReq where reqName like :userName and jobstatus like :jobstatus order by reqId DESC");
			query.setParameter("userName", "%%");
			if (jobstatus.equals("ALL"))
				query.setParameter("jobstatus", "%%");
			else{
				
				query.setParameter("jobstatus", jobstatus);
			}
			List<JobReq> jobreq = (List<JobReq>) query.list();
			return jobreq;
		}
		if (designation.equals("ROLE_MANAGER")) {
			query = session.createQuery("from JobReq where mgrAppr like :userName and jobstatus like :jobstatus order by reqId DESC");
			query.setParameter("userName", userName);
			if (jobstatus.equals("ALL"))
				query.setParameter("jobstatus", "%%");
			else
				query.setParameter("jobstatus", jobstatus);
			
			List<JobReq> jobreq = (List<JobReq>) query.list();
			return jobreq;
		}
		if (designation.equals("ROLE_FINANCE")) {
			query = session.createQuery("from JobReq where finAppr like :userName and jobstatus like :jobstatus order by reqId DESC");
			query.setParameter("userName", userName);
			if (jobstatus.equals("ALL"))
				query.setParameter("jobstatus", "%%");
			else
				query.setParameter("jobstatus", jobstatus);
			
			List<JobReq> jobreq = (List<JobReq>) query.list();
			return jobreq;
		}
		if (designation.equals("ROLE_MANAGEMENT")) {
			query = session.createQuery("from JobReq where mgmAppr like :userName and jobstatus like :jobstatus order by reqId DESC");
			query.setParameter("userName", userName);
			if (jobstatus.equals("ALL"))
				query.setParameter("jobstatus", "%%");
			else
				query.setParameter("jobstatus", jobstatus);
			
			List<JobReq> jobreq = (List<JobReq>) query.list();
			return jobreq;
		}
		if (designation.equals("ROLE_EMPLOYEE")){
			query = session.createQuery("from JobReq where reqName like :userName and jobstatus like :jobstatus order by reqId DESC");
			query.setParameter("userName", userName);
			if (jobstatus.equals("ALL"))
				query.setParameter("jobstatus", "%%");
			else
				query.setParameter("jobstatus", jobstatus);
			
			List<JobReq> jobreq = (List<JobReq>) query.list();
			return jobreq;
		}
		
		
		return null;
	}

	@Override
	public void updateApprStatus(int reqId, String mastatus) {
		Session session = sessionFactory.getCurrentSession();
		JobReq jobreq = session.get(JobReq.class, reqId);
		if (jobreq.getFastatus() == null || jobreq.getMmstatus() == null){
			jobreq.setJobstatus("Pending Approval");
		}
		else if (jobreq.getFastatus().equals("AP") &&
				jobreq.getMmstatus().equals("AP") &&
				mastatus.equals("Accept")) {
			jobreq.setJobstatus("APPROVED");
		}
		else {
			jobreq.setJobstatus("Pending Approval");
		}
		
		if (mastatus.equals("Accept"))
		jobreq.setMastatus("AP");
		else {
		jobreq.setMastatus("RJ");
		jobreq.setJobstatus("REJECTED");
		}
		
		session.update(jobreq);
	}

	@Override
	public int getMaxJobReqId() {
		
		Session session = sessionFactory.getCurrentSession();
		JobReqId reqIdClass = session.get(JobReqId.class, "JOB_REQ_ID");
		int reqIdIncr = reqIdClass.getReqid();
		reqIdIncr++;
		reqIdClass.setReqid(reqIdIncr);
		session.update(reqIdClass);
		reqIdIncr--;
		
		return reqIdIncr;
	}

	@Override
	public void updateFmStatus(int reqId, String fastatus) {
		Session session = sessionFactory.getCurrentSession();
		JobReq jobreq = session.get(JobReq.class, reqId);
		
		if (jobreq.getFastatus() == null || jobreq.getMmstatus() == null){
			jobreq.setJobstatus("Pending Approval");
		}
		else if (jobreq.getMastatus().equals("AP") &&
				jobreq.getMmstatus().equals("AP") &&
				fastatus.equals("Accept")) {
			
			jobreq.setJobstatus("APPROVED");
		}
		else {
			jobreq.setJobstatus("Pending Approval");
		}
		
		if (fastatus.equals("Accept"))
		jobreq.setFastatus("AP");
		else {
		jobreq.setFastatus("RJ");
		jobreq.setJobstatus("REJECTED");
		}
		
		session.update(jobreq);
	}
	
	@Override
	public void updateMmStatus(int reqId, String mmstatus) {
		Session session = sessionFactory.getCurrentSession();
		JobReq jobreq = session.get(JobReq.class, reqId);
		System.out.println(jobreq.getMastatus());
		System.out.println(jobreq.getFastatus());
		System.out.println(mmstatus);
		if (jobreq.getFastatus() == null || jobreq.getMastatus() == null){
			jobreq.setJobstatus("Pending Approval");
		}
		else if (jobreq.getMastatus().equals("AP") &&
				jobreq.getFastatus().equals("AP") &&
				mmstatus.equals("Accept")) {
			
			jobreq.setJobstatus("APPROVED");
		}
		else {
			jobreq.setJobstatus("Pending Approval");
		}
		
		if (mmstatus.equals("Accept"))
		jobreq.setMmstatus("AP");
		else {
			jobreq.setMmstatus("RJ");
			jobreq.setJobstatus("REJECTED");
		}
		
		session.update(jobreq);
	}
	
}
