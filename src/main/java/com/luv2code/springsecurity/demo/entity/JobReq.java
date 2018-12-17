package com.luv2code.springsecurity.demo.entity;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="JobReq")
@Table(name="jobreq")
public class JobReq {

	@Id
	@GeneratedValue
	private int reqId;
	
	private String jobreqid;
	
	private String reqName;
	
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot be blank")
	private String reqDept;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date reqDate;
	
	@NotBlank(message="cannot be blank")
	private String posTitle;
	
	@NotBlank(message="cannot be blank")
	private String jobDesc;
	
	@NotBlank(message="cannot be blank")
	private String jobResp;
	
	@NotBlank(message="cannot be blank")
	private String skills;
	
	@NotBlank(message="cannot be blank")
	private String reqEdu;
	
	@NotBlank(message="cannot be blank")
	private String jobExp;
	
	@NotBlank(message="cannot be blank")
	private String comments;
	
	@NotNull(message="cannot br null")
	private Integer vacancies;
	
	private String mgrAppr;
	
	private String mastatus;
	
	@Transient
	private LinkedHashMap<String, String> mgrApprover;
	
	private String mgrComm;
	
	private String finAppr;
	
	private String fastatus;
	
	private String finComm;
	
	private String mgmAppr;
	
	private String mmstatus;
	
	private String mgmComm;
	
	private String empType;
	
	private String jobstatus;
	
	@Transient
	private LinkedHashMap<String, String> pendingStatus;
	@Transient
	private String Status;
		
	@Transient
	private LinkedHashMap<String, String> department;
	
	public JobReq() {
		
		this.department = new LinkedHashMap<String,String>();
		this.department.put("IT", "Information Technology");
		this.department.put("CALL", "IT Call Support");
		this.department.put("ADMIN", "Administration");
		this.department.put("HR", "Human Resource");
		this.department.put("MISC", "Miscelaneous");
		
		this.mgrApprover = new LinkedHashMap<String, String>();
		this.mgrApprover.put("vijay", "Vijay Danny");
		this.mgrApprover.put("hrmanager", "HR Manager");
		this.mgrApprover.put("finance", "Finance Head");
		this.mgrApprover.put("management", "Management");
		
		pendingStatus = new LinkedHashMap<String, String>();
		pendingStatus.put("ALL", "ALL");
		pendingStatus.put("HR", "HR");
		pendingStatus.put("PA", "Pending Approval");
		pendingStatus.put("CA", "Candidate Approval");
		pendingStatus.put("Rejected", "REJECTED");
		pendingStatus.put("Approved", "APPROVED");
	}
	
	public String getMgmAppr() {
		return mgmAppr;
	}

	public void setMgmAppr(String mgmAppr) {
		this.mgmAppr = mgmAppr;
	}

	public String getMmstatus() {
		return mmstatus;
	}

	public void setMmstatus(String mmstatus) {
		this.mmstatus = mmstatus;
	}

	public String getMgmComm() {
		return mgmComm;
	}

	public void setMgmComm(String mgmComm) {
		this.mgmComm = mgmComm;
	}

	public String getJobreqid() {
		return jobreqid;
	}

	public void setJobreqid(String jobreqid) {
		this.jobreqid = jobreqid;
	}

	public String getMastatus() {
		return mastatus;
	}

	public void setMastatus(String mastatus) {
		this.mastatus = mastatus;
	}

	public String getFastatus() {
		return fastatus;
	}

	public void setFastatus(String fastatus) {
		this.fastatus = fastatus;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public LinkedHashMap<String, String> getPendingStatus() {
		return pendingStatus;
	}

	public String getJobstatus() {
		return jobstatus;
	}

	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}


	public LinkedHashMap<String, String> getMgrApprover() {
		return mgrApprover;
	}

	public LinkedHashMap<String, String> getDepartment() {
		return department;
	}

	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getReqName() {
		return reqName;
	}
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	public String getReqDept() {
		return reqDept;
	}
	public void setReqDept(String reqDept) {
		this.reqDept = reqDept;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public String getPosTitle() {
		return posTitle;
	}
	public void setPosTitle(String posTitle) {
		this.posTitle = posTitle;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getJobResp() {
		return jobResp;
	}
	public void setJobResp(String jobResp) {
		this.jobResp = jobResp;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getReqEdu() {
		return reqEdu;
	}
	public void setReqEdu(String reqEdu) {
		this.reqEdu = reqEdu;
	}
	public String getJobExp() {
		return jobExp;
	}
	public void setJobExp(String jobExp) {
		this.jobExp = jobExp;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getVacancies() {
		return vacancies;
	}
	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}
	public String getMgrAppr() {
		return mgrAppr;
	}
	public void setMgrAppr(String mgrAppr) {
		this.mgrAppr = mgrAppr;
	}
	public String getMgrComm() {
		return mgrComm;
	}
	public void setMgrComm(String mgrComm) {
		this.mgrComm = mgrComm;
	}
	public String getFinAppr() {
		return finAppr;
	}
	public void setFinAppr(String finAppr) {
		this.finAppr = finAppr;
	}
	public String getFinComm() {
		return finComm;
	}
	public void setFinComm(String finComm) {
		this.finComm = finComm;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	
}
