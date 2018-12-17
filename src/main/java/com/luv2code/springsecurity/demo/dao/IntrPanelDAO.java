package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.InterviewPanel;
import com.luv2code.springsecurity.demo.entity.PanelCandidates;

public interface IntrPanelDAO {

	public void addInterPanel(InterviewPanel ipanel);

	public InterviewPanel getCandIntrRecord(int candId);
	
	public List<PanelCandidates> listPanelCandidates(String panel, String irlevel);

	public InterviewPanel getInterviewPanelRec(int id);
}
