package com.luv2code.springsecurity.demo.controller;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
import com.luv2code.springsecurity.demo.entity.JobReq;

@Controller
@RequestMapping("/approver")
public class ApproverController {
	
	@Autowired
	private JobReqService jrService;
	
	@GetMapping("/editjob")
	public String editJob(@RequestParam("reqId") int reqId, Model model) {
		
		JobReq jobreq = jrService.getJobDetails(reqId);
		model.addAttribute("jobreq",jobreq);
		return "appr_editjob";
	}
	
	@PostMapping("/update")
	public String hrUpdate(@RequestParam("reqId") int reqId,@RequestParam("mastatus") String mastatus,
							RedirectAttributes ra) {
		System.out.println(reqId + "  =   " + mastatus);
		jrService.updateApprStatus(reqId,mastatus);
		ra.addAttribute("jobstatus", "ALL");
		return "redirect: /hrmsapp/listJobReq";
	}
	
	
}
