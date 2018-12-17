package com.luv2code.springsecurity.demo.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springsecurity.demo.dao.JobReqService;
import com.luv2code.springsecurity.demo.entity.Candidate;
import com.luv2code.springsecurity.demo.entity.InterviewPanel;

@Controller
@RequestMapping(value="/candidate")
public class CandidateController {

	@Autowired
	private JobReqService jrService;
	
	@GetMapping("/cform")
	public String getCandidateForm(@RequestParam("jobname") String jobreqid ,Model model) {
		Candidate candidate = new Candidate();
		candidate.setJobreqid(jobreqid);
		model.addAttribute("cdata", candidate);
		return "cform";
	}
	
	@GetMapping("/cUpd")
	public String updCandidateForm(@RequestParam("candId") int candId, Model model) {
		
		Candidate cand = jrService.getCandidateRecord(candId);
		model.addAttribute("cdata",cand);
		
		return "cform";
	}
	
	@PostMapping("/addCandidate")
	public String addCandidate(@Valid @ModelAttribute("cdata") Candidate candidate, BindingResult br,
			RedirectAttributes ra) 
	{
		
		if (br.hasErrors()) {
			System.out.println(br);
			return "cform";
		}
		
		jrService.addCandidate(candidate);
		ra.addAttribute("jobname", candidate.getJobreqid());
		
		return "redirect: cList";
	}
	
	@GetMapping("/cList")
	public String candidateList(@RequestParam("jobname") String jobname, Model model) {
		List<Candidate> canlist = jrService.getListofJobCan(jobname);
		List<String> jobreqidList = jrService.getJobReqidList();
		model.addAttribute("clist",canlist);
		model.addAttribute("jobreqlist",jobreqidList);
		Candidate candidate = new Candidate();
		candidate.setJobname(jobname);
		model.addAttribute("candidate",candidate);
		return "clist";
	}
	
	@GetMapping("/addIntrPanel")
	public String addIntrPanel(@RequestParam("candId") int candId ,Model model) {
		// get the candidate details to be passed on to jsp page
		List<String> panelList = jrService.getIntrPanel();
		
		InterviewPanel interviewPanel = jrService.getCandIntrRecord(candId);
		if(interviewPanel.getCandidateId() == 0)
			interviewPanel.setCandidateId(candId);
		
		model.addAttribute("j_intrPanel",interviewPanel);
		model.addAttribute("j_ipList",panelList);
		return "addPanel";
	}
}
