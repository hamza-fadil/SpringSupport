package com.support.informatique.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	


	@RequestMapping("/")
	public String users(ModelMap model,HttpServletRequest request) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (request.isUserInRole("USER")) {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "redirect:/user/index";
			  	
		  } else if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "redirect:/admin/index"; 		  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "redirect:/tech/index"; 
			  	
		  }
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model,@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  if (error != null) {
		model.addAttribute("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addAttribute("msg", "You've been logged out successfully.");	
	  }
	  return "login";
	}
	

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";
	}
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap model) {


	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());
	  }
	  return "403";

	}
	@RequestMapping("/about")
	public String about(ModelMap model) {
		return "about";
	}
	@RequestMapping("/faq")
	public String faq(ModelMap model) {
		return "faq";
	}
	@RequestMapping("/howto")
	public String howto(ModelMap model) {
		return "howto";
	}


}