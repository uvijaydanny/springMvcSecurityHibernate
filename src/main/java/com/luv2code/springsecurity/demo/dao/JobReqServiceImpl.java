package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.Candidate;
import com.luv2code.springsecurity.demo.entity.InterviewPanel;
import com.luv2code.springsecurity.demo.entity.JobReq;
import com.luv2code.springsecurity.demo.entity.PanelCandidates;
import com.luv2code.springsecurity.demo.entity.UserDetails;

@Service
public class JobReqServiceImpl implements JobReqService {

	@Autowired
	private JobReqDAO jrDAO;
	@Autowired
	private CandidateDAO canDAO;
	
	@Autowired
	private UserAuthDAO uaDAO;
	
	@Autowired
	private IntrPanelDAO ipDAO;
	
	@Autowired 
	private UserDetailsDAO udDAO;
	
	@Override
	@Transactional
	public List<JobReq> listOfJobReq() {
		return jrDAO.listOfJobReq();
	}

	@Override
	@Transactional
	public void createJobReq(JobReq jobReq) {
		jrDAO.createJobReq(jobReq);
	}

	@Override
	@Transactional
	public JobReq getJobDetails(int reqId) {
		return jrDAO.getJobDetails(reqId);
	}

	@Override
	@Transactional
	public void updateJobReq(JobReq jobreq) {
		jrDAO.updateJobReq(jobreq);		
	}

	@Override
	@Transactional
	public List<JobReq> listUserJobReq(String userName,String designation, String jobstatus) {
		return jrDAO.listUserJobReq(userName,designation, jobstatus);
	}

	@Override
	@Transactional
	public void updateApprStatus(int reqId, String mastatus) {
		jrDAO.updateApprStatus(reqId, mastatus);
		
	}

	@Override
	@Transactional
	public int getMaxJobReqId() {
		// TODO Auto-generated method stub
		return jrDAO.getMaxJobReqId();
	}

	@Override
	@Transactional
	public List<Candidate> getListofJobCan(String jobname) {
		// TODO Auto-generated method stub
		return canDAO.getListofJobCan(jobname);
	}

	@Override
	@Transactional
	public void addCandidate(Candidate candidate) {
		canDAO.addCandidate(candidate);
		
	}

	@Override
	@Transactional
	public List<String> getJobReqidList() {
		
		return canDAO.getJobReqidList();
	}

	@Override
	@Transactional
	public void updateFmStatus(int reqId, String fmstatus) {
		
		jrDAO.updateFmStatus(reqId, fmstatus);
	}
	
	@Override
	@Transactional
	public void updateMmStatus(int reqId, String mmstatus) {
		
		jrDAO.updateMmStatus(reqId, mmstatus);
	}

	@Override
	@Transactional
	public List<String> getIntrPanel() {
		// TODO Auto-generated method stub
		return uaDAO.getIntrPanel();
	}

	@Override
	@Transactional
	public void addInterPanel(InterviewPanel ipanel) {
		
		ipDAO.addInterPanel(ipanel);
	}

	@Override
	@Transactional
	public InterviewPanel getCandIntrRecord(int candId) {
		// TODO Auto-generated method stub
		return ipDAO.getCandIntrRecord(candId);
	}

	@Override
	@Transactional
	public List<PanelCandidates> listPanelCandidates(String panel, String irlevel) {
		// TODO Auto-generated method stub
		return ipDAO.listPanelCandidates(panel, irlevel);
	}

	@Override
	@Transactional
	public InterviewPanel getInterviewPanelRec(int id) {
		// TODO Auto-generated method stub
		return ipDAO.getInterviewPanelRec(id);
	}

	@Override
	@Transactional
	public Candidate getCandidateRecord(int candidateId) {
		// TODO Auto-generated method stub
		return canDAO.getCandidateRecord(candidateId);
	}

	@Override
	@Transactional
	public void addUsersAuthorizationDetails(UserDetails userdetails) {
	
		udDAO.addUsersAuthorizationDetails(userdetails);
		
	}

	@Override
	@Transactional
	public List<UserDetails> getUserAuthDetails() {
		
		return udDAO.getUserAuthDetails();
	}

}
