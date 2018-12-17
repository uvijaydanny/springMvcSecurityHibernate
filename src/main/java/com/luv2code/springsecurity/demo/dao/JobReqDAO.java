package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.JobReq;

public interface JobReqDAO {

	public List<JobReq> listOfJobReq();
	public void createJobReq(JobReq jobReq);
	public JobReq getJobDetails(int reqId);
	public void updateJobReq(JobReq jobreq);
	public List<JobReq> listUserJobReq(String userName, String designation, String jobstatus);
	public void updateApprStatus(int reqId, String mastatus);
	public int getMaxJobReqId();
	public void updateFmStatus(int reqId, String fmstatus);
	public void updateMmStatus(int reqId, String mmstatus);
}
