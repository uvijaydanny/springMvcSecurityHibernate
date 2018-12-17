package com.luv2code.springsecurity.demo.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.luv2code.springsecurity.demo.entity.JobReq;

@Controller
@RequestMapping(value="/finmgmt")
public class FinMgmtController {

	@Autowired
	private JobReqService jrService;
	
	@GetMapping("/editjob")
	public String editJob(@RequestParam("reqId") int reqId, Model model) {
		
		JobReq jobreq = jrService.getJobDetails(reqId);
		model.addAttribute("jobreq",jobreq);
		return "fm/fm_editjob";
	}
	
	@PostMapping("/update")
	public String hrUpdate(@RequestParam("reqId") int reqId,@RequestParam("mmstatus") String mmstatus,
							RedirectAttributes ra) {
		
		// Check if the logged In user is Finance or Management Approver to invoke the correct DAO method
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
	    boolean isMGM=false, isFinance=false;
	    for (GrantedAuthority ga: authorities) {
	    	isMGM = ga.getAuthority().equals("ROLE_MANAGEMENT");
	    	isFinance = ga.getAuthority().equals("ROLE_FINANCE");
	    	
	    	if(isMGM || isFinance) break;
	    }	
		
	    if (isMGM)
		jrService.updateMmStatus(reqId,mmstatus);
	    else if (isFinance)
	    jrService.updateFmStatus(reqId,mmstatus);
	    
		ra.addAttribute("jobstatus", "ALL");
		return "redirect: /hrmsapp/listJobReq";
	}
	
}
