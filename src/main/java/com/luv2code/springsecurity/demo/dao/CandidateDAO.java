package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Candidate;

public interface CandidateDAO {

	public List<Candidate> getListofJobCan(String jobname);
	public void addCandidate(Candidate candidate);
	public List<String> getJobReqidList();
	public Candidate getCandidateRecord(int candidateId);
}
