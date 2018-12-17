package com.luv2code.springsecurity.demo.entity;


public class PanelCandidates {
	
	private int intrPanelId;
	private String panel;
	private int candidateId;
	private String candidateName;
	private String interviewRound;
	private String experience;
	private String comments;
	private int rating;
	private String iStatus;
	private int prvStatus;
	
	
	public String getPanel() {
		return panel;
	}
	public void setPanel(String panel) {
		this.panel = panel;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getiStatus() {
		return iStatus;
	}
	public void setiStatus(String iStatus) {
		this.iStatus = iStatus;
	}
	public int getIntrPanelId() {
		return intrPanelId;
	}
	public void setIntrPanelId(int intrPanelId) {
		this.intrPanelId = intrPanelId;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getInterviewRound() {
		return interviewRound;
	}
	public void setInterviewRound(String interviewRound) {
		this.interviewRound = interviewRound;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public int getPrvStatus() {
		return prvStatus;
	}
	public void setPrvStatus(int prvStatus) {
		this.prvStatus = prvStatus;
	}
	
}
