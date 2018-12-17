package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import javax.validation.Valid;

import com.luv2code.springsecurity.demo.entity.Candidate;
import com.luv2code.springsecurity.demo.entity.InterviewPanel;
import com.luv2code.springsecurity.demo.entity.JobReq;
import com.luv2code.springsecurity.demo.entity.PanelCandidates;
import com.luv2code.springsecurity.demo.entity.UserDetails;

public interface JobReqService {

	public List<JobReq> listOfJobReq();
	public void createJobReq(JobReq jobReq);
	public JobReq getJobDetails(int reqId);
	public void updateJobReq(JobReq jobreq);
	
	public List<JobReq> listUserJobReq(String name, String designation, String jobstatus);
	public void updateApprStatus(int reqId, String mastatus);
	public int getMaxJobReqId();
	public List<Candidate> getListofJobCan(String jobname);
	public void addCandidate(Candidate candidate);
	public List<String> getJobReqidList();
	public void updateFmStatus(int reqId, String mmstatus);
	public void updateMmStatus(int reqId, String mmstatus);
	public List<String> getIntrPanel();
	public void addInterPanel(InterviewPanel ipanel);
	public InterviewPanel getCandIntrRecord(int candId);
	public List<PanelCandidates> listPanelCandidates(String panel, String irlevel);
	public InterviewPanel getInterviewPanelRec(int id);
	public Candidate getCandidateRecord(int candidateId);
	public void addUsersAuthorizationDetails(UserDetails userdetails);
	public List<UserDetails> getUserAuthDetails();
}
