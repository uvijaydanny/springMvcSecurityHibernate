package com.luv2code.springsecurity.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springsecurity.demo.dao.JobReqService;
import com.luv2code.springsecurity.demo.entity.Candidate;
import com.luv2code.springsecurity.demo.entity.InterviewPanel;
import com.luv2code.springsecurity.demo.entity.PanelCandidates;

@Controller
@RequestMapping("/intrPanel")
public class PanelController {

	@Autowired
	private JobReqService jrService;

	@PostMapping("/updJob")
	public String  updjob(@ModelAttribute("j_intrPanel") InterviewPanel ipanel ,RedirectAttributes ra) {
	
		jrService.addInterPanel(ipanel);
		
		ra.addAttribute("jobname", "ALL");
		return "redirect: /hrmsapp/candidate/cList";	
	}
	
	@GetMapping("/candList")
	public String getPanelCandidates(@RequestParam("panel") String panel,
									 @RequestParam("interviewRound") String irlevel, 
									 Model model){
		
		List<PanelCandidates> listPanCand = jrService.listPanelCandidates(panel, irlevel);
		model.addAttribute("j_panelList",listPanCand);
		PanelCandidates pc = new PanelCandidates();
		pc.setInterviewRound(irlevel);
		model.addAttribute("j_panel",pc );
		model.addAttribute("panel",panel);
		return "inter_panel/panelCandList";
	}
	
	@PostMapping("/addReview")
	public String addReview(@ModelAttribute("j_panel") PanelCandidates pc, RedirectAttributes ra) {
		int id = pc.getIntrPanelId();
		InterviewPanel ipanel = jrService.getInterviewPanelRec(id);
		int candidateId = pc.getCandidateId();
		Candidate candidate = jrService.getCandidateRecord(candidateId);
		if(pc.getInterviewRound().equals("Telephone")){
			ipanel.setTelComments(pc.getComments());
			ipanel.setTelRating(pc.getRating());
			ipanel.setTelStatus(pc.getiStatus());
			candidate.setTelStatus("YES");
		}
		else if(pc.getInterviewRound().equals("Technical1")){
			ipanel.setTech1Comments(pc.getComments());
			ipanel.setTech1Rating(pc.getRating());
			ipanel.setTech1Status(pc.getiStatus());
			candidate.setTech1Status("YES");
		}
		else if(pc.getInterviewRound().equals("Technical2")){
			ipanel.setTech2Comments(pc.getComments());
			ipanel.setTech2Rating(pc.getRating());
			ipanel.setTech2Status(pc.getiStatus());
			candidate.setTech2Status("YES");
		}
		else if(pc.getInterviewRound().equals("Managerial")){
			ipanel.setMgrComments(pc.getComments());
			ipanel.setMgrRating(pc.getRating());
			ipanel.setMgrStatus(pc.getiStatus());
			candidate.setMgrStatus("YES");
		}
		else if(pc.getInterviewRound().equals("HR")){
			ipanel.setHrComments(pc.getComments());
			ipanel.setHrRating(pc.getRating());
			ipanel.setHrStatus(pc.getiStatus());
			candidate.setHrStatus("YES");
		}
		jrService.addInterPanel(ipanel);
		jrService.addCandidate(candidate);
		ra.addAttribute("panel", pc.getPanel());
		ra.addAttribute("interviewRound","ALL");
		return "redirect: candList";
	}
}

