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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="Candidate")
@Table(name="candidate")
public class Candidate {

	@Id @GeneratedValue
	private int candidateId;
	
	private String jobreqid;
	
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot by blanks")
	private String firstName;
	
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot by blanks")
	private String lastName;
	
	@Email(message="Invalid email")
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot by blanks")
	private String emailId;
	
	@Pattern(regexp="^[0-9]{10}",message="Only digits allowed" )
	@Size(min=10, max=12, message="Enter valid phone number")
	private String telephone;
	
	private String canResume;
	
	@NotBlank(message="cannot by blanks")
	private String onHold;
	@NotBlank(message="cannot by blanks")
	private String telStatus;
	@NotBlank(message="cannot by blanks")
	@NotBlank(message="cannot by blanks")
	private String tech1Status;
	@NotBlank(message="cannot by blanks")
	private String tech2Status;
	@NotBlank(message="cannot by blanks")
	private String mgrStatus;
	@NotBlank(message="cannot by blanks")
	private String hrStatus;
	@NotBlank(message="cannot by blanks")
	private String ofrRls;
	@NotBlank(message="cannot by blanks")
	private String ofrAccept;
	@NotBlank(message="cannot by blanks")
	private String bckgVerify;
	
	private String joinedOrg;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date joinDate;
	
	@Transient
	private LinkedHashMap<String, String> yesno;
	
	@Transient
	private String jobname;
	
	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getJobreqid() {
		return jobreqid;
	}

	public void setJobreqid(String jobreqid) {
		this.jobreqid = jobreqid;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCanResume() {
		return canResume;
	}

	public void setCanResume(String canResume) {
		this.canResume = canResume;
	}

	public String getOnHold() {
		return onHold;
	}

	public void setOnHold(String onHold) {
		this.onHold = onHold;
	}

	public String getTelStatus() {
		return telStatus;
	}

	public void setTelStatus(String telStatus) {
		this.telStatus = telStatus;
	}

	public String getTech1Status() {
		return tech1Status;
	}

	public void setTech1Status(String tech1Status) {
		this.tech1Status = tech1Status;
	}

	public String getTech2Status() {
		return tech2Status;
	}

	public void setTech2Status(String tech2Status) {
		this.tech2Status = tech2Status;
	}

	public String getMgrStatus() {
		return mgrStatus;
	}

	public void setMgrStatus(String mgrStatus) {
		this.mgrStatus = mgrStatus;
	}

	public String getHrStatus() {
		return hrStatus;
	}

	public void setHrStatus(String hrStatus) {
		this.hrStatus = hrStatus;
	}

	public String getOfrRls() {
		return ofrRls;
	}

	public void setOfrRls(String ofrRls) {
		this.ofrRls = ofrRls;
	}

	public String getOfrAccept() {
		return ofrAccept;
	}

	public void setOfrAccept(String ofrAccept) {
		this.ofrAccept = ofrAccept;
	}

	public String getBckgVerify() {
		return bckgVerify;
	}

	public void setBckgVerify(String bckgVerify) {
		this.bckgVerify = bckgVerify;
	}

	public String getJoinedOrg() {
		return joinedOrg;
	}

	public void setJoinedOrg(String joinedOrg) {
		this.joinedOrg = joinedOrg;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public LinkedHashMap<String, String> getYesno() {
		return yesno;
	}

	public Candidate() {
		yesno = new LinkedHashMap<String, String>();
		yesno.put("YES", "YES");
		yesno.put("NO", "NO");
		yesno.put("NA", "NA");
	}
	
	
}
