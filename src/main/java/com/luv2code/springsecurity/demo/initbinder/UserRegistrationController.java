package com.luv2code.springsecurity.demo.initbinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {
    @Autowired
    private UserService userService;


    @InitBinder("user")
    public void customizeBinding (WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "dateOfBirth",
                                    new CustomDateEditor(dateFormatter, true));
    }
    

    @RequestMapping(value="/reguser",method = RequestMethod.GET)
    public String handleGetRequest (Model model) {
        model.addAttribute("user", new User());
        return "user-registration";
    }

    @RequestMapping(value="/crtuser",method = RequestMethod.POST)
    public String handlePostRequest (@Valid @ModelAttribute("user") User user,
                                     BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "user-registration";
        }

        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "registration-done";
    }
}