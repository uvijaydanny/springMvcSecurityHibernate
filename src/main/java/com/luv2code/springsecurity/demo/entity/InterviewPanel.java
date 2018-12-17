package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="interviewPanel")
@Table(name="interviewPanel")
public class InterviewPanel {

	@Id @GeneratedValue
	private int tableid;
	
	private int candidateId;
	
	private String telPanel;
	private String telComments;
	private int telRating;
	private String telStatus;
	
	private String tech1Panel;
	private String tech1Comments;
	private int tech1Rating;
	private String tech1Status;
	
	private String tech2Panel;
	private String tech2Comments;
	private int tech2Rating;
	private String tech2Status;
	
	private String mgrPanel;
	private String mgrComments;
	private int mgrRating;
	private String mgrStatus;
	
	private String hrPanel;
	private String hrComments;
	private int hrRating;
	private String hrStatus;
	public int getTableid() {
		return tableid;
	}
	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getTelPanel() {
		return telPanel;
	}
	public void setTelPanel(String telPanel) {
		this.telPanel = telPanel;
	}
	public String getTelComments() {
		return telComments;
	}
	public void setTelComments(String telComments) {
		this.telComments = telComments;
	}
	public int getTelRating() {
		return telRating;
	}
	public void setTelRating(int telRating) {
		this.telRating = telRating;
	}
	public String getTelStatus() {
		return telStatus;
	}
	public void setTelStatus(String telStatus) {
		this.telStatus = telStatus;
	}
	public String getTech1Panel() {
		return tech1Panel;
	}
	public void setTech1Panel(String tech1Panel) {
		this.tech1Panel = tech1Panel;
	}
	public String getTech1Comments() {
		return tech1Comments;
	}
	public void setTech1Comments(String tech1Comments) {
		this.tech1Comments = tech1Comments;
	}
	public int getTech1Rating() {
		return tech1Rating;
	}
	public void setTech1Rating(int tech1Rating) {
		this.tech1Rating = tech1Rating;
	}
	public String getTech1Status() {
		return tech1Status;
	}
	public void setTech1Status(String tech1Status) {
		this.tech1Status = tech1Status;
	}
	public String getTech2Panel() {
		return tech2Panel;
	}
	public void setTech2Panel(String tech2Panel) {
		this.tech2Panel = tech2Panel;
	}
	public String getTech2Comments() {
		return tech2Comments;
	}
	public void setTech2Comments(String tech2Comments) {
		this.tech2Comments = tech2Comments;
	}
	public int getTech2Rating() {
		return tech2Rating;
	}
	public void setTech2Rating(int tech2Rating) {
		this.tech2Rating = tech2Rating;
	}
	public String getTech2Status() {
		return tech2Status;
	}
	public void setTech2Status(String tech2Status) {
		this.tech2Status = tech2Status;
	}
	public String getMgrPanel() {
		return mgrPanel;
	}
	public void setMgrPanel(String mgrPanel) {
		this.mgrPanel = mgrPanel;
	}
	public String getMgrComments() {
		return mgrComments;
	}
	public void setMgrComments(String mgrComments) {
		this.mgrComments = mgrComments;
	}
	public int getMgrRating() {
		return mgrRating;
	}
	public void setMgrRating(int mgrRating) {
		this.mgrRating = mgrRating;
	}
	public String getMgrStatus() {
		return mgrStatus;
	}
	public void setMgrStatus(String mgrStatus) {
		this.mgrStatus = mgrStatus;
	}
	public String getHrPanel() {
		return hrPanel;
	}
	public void setHrPanel(String hrPanel) {
		this.hrPanel = hrPanel;
	}
	public String getHrComments() {
		return hrComments;
	}
	public void setHrComments(String hrComments) {
		this.hrComments = hrComments;
	}
	public int getHrRating() {
		return hrRating;
	}
	public void setHrRating(int hrRating) {
		this.hrRating = hrRating;
	}
	public String getHrStatus() {
		return hrStatus;
	}
	public void setHrStatus(String hrStatus) {
		this.hrStatus = hrStatus;
	}
	
	
	
	
}
