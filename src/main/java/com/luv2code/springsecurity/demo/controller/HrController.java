package com.luv2code.springsecurity.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springsecurity.demo.dao.JobReqService;
import com.luv2code.springsecurity.demo.entity.JobReq;

@Controller
@RequestMapping("/hr")
public class HrController {
	
	@Autowired
	private JobReqService jrService;
	
	@PostMapping("/update")
	public String hrUpdate(@ModelAttribute("jobreq") JobReq jobreq, RedirectAttributes ra) {
		jobreq.setJobstatus("Pending Approver");
		jobreq.setFinAppr("finance");
		jobreq.setMgmAppr("management");
		
		jrService.updateJobReq(jobreq);
				
		ra.addAttribute("jobstatus", "ALL");
		return "redirect: /hrmsapp/listJobReq";
	}
}
