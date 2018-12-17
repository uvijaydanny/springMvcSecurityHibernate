package com.luv2code.springsecurity.demo.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springsecurity.demo.dao.JobReqService;
import com.luv2code.springsecurity.demo.entity.JobReq;
import com.luv2code.springsecurity.demo.entity.UserDetails;

@Controller
public class HrmsController {

	@Autowired
	private JobReqService jobReqService;
	
	@GetMapping("/")
	public String homePage(Model model, RedirectAttributes ra) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
		
		boolean isPanel = false;
		for (GrantedAuthority ga: authorities) {
	    	isPanel = ga.getAuthority().equals("ROLE_PANEL");
	    	if(isPanel)
	    	break;
		}
		if (isPanel) {
			ra.addAttribute("panel",name);
			ra.addAttribute("interviewRound","ALL");
			return "redirect: /hrmsapp/intrPanel/candList";
		}
	    	
		ra.addAttribute("jobstatus", "ALL");
		return "redirect:listJobReq";
	}
	
	@PostMapping("/create")
	public String createJob(@Valid @ModelAttribute("jobreq") JobReq jobReq, BindingResult br, Model model
			, RedirectAttributes ra) {
		
		if(br.hasErrors()) {
			return "home";
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		jobReq.setReqName(name);
		jobReq.setJobstatus("HR");
		int reqId = jobReqService.getMaxJobReqId();
		String jobidname = "JOB_REQ_ID_" + String.valueOf(reqId);
		jobReq.setJobreqid(jobidname);
		
		jobReqService.createJobReq(jobReq);
		
		ra.addAttribute("jobstatus", "ALL");
		return "redirect: listJobReq";
	}
	
	@GetMapping("/reqJobPos")
	public String reqJobPos(Model model) {
		model.addAttribute("jobreq", new JobReq());
		return "home";
	}
	
	@GetMapping("/listJobReq")
	public String listJobReq(@ModelAttribute("jobreq") JobReq jobreq,@RequestParam("jobstatus") String jobstatus, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
	    boolean isManager = false, isFinance=false, isMgm= false, isAdmin=false;
	    String designation = "ROLE_EMPLOYEE";
	    for (GrantedAuthority ga: authorities) {
	    	isAdmin = ga.getAuthority().equals("ROLE_ADMIN");
	    	isManager = ga.getAuthority().equals("ROLE_MANAGER") || ga.getAuthority().equals("ROLE_HR");
	    	isFinance = ga.getAuthority().equals("ROLE_FINANCE");
	    	isMgm = ga.getAuthority().equals("ROLE_MANAGEMENT");
	    	if (isAdmin) {
	    		designation = "ROLE_ADMIN";
	    		break;
	    	}
	    	if (isManager) {
	    		designation = "ROLE_MANAGER";
	    		break;
	    	}
	    	if (isFinance) {
	    		designation = "ROLE_FINANCE";
	    		break;
	    	}
	    	if (isMgm) {
	    		designation = "ROLE_MANAGEMENT";
	    		break;
	    	}
	    }
	    
		List<JobReq> listJR = jobReqService.listUserJobReq(name,designation,jobstatus);
		model.addAttribute("jobReq", listJR);
		return "jobreq";
	}
	
	@GetMapping("/admin/editjob")
	public String editJob(@RequestParam("reqId") int reqId, Model model) {
		JobReq jobreq = jobReqService.getJobDetails(reqId);
		model.addAttribute("jobreq", jobreq);
		return "editJob";
	}
	
	@GetMapping("/getUserForm")
	public String getUserForm(Model model) {
		model.addAttribute("j_userauth",new UserDetails());
		return "authusers/getUserForm";
	}
	
	@PostMapping("/addUser")
	public String addUser(@Valid @ModelAttribute("j_userauth") UserDetails userdetails, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "authusers/getUserForm";
		}
		jobReqService.addUsersAuthorizationDetails(userdetails);
		List<UserDetails> ud = jobReqService.getUserAuthDetails();
		model.addAttribute("j_userlist",ud);
		return "authusers/userslist";
	}
	
	@GetMapping("/userList")
	public String userList(Model model) {
		List<UserDetails> ud = jobReqService.getUserAuthDetails();
		model.addAttribute("j_userlist",ud);
		return "authusers/userslist"; 
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "login-page";
	}
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
}
