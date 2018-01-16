package com.support.informatique.controller;

	import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Taches;
import com.support.informatique.entities.User;
import com.support.informatique.service.TachesService;
import com.support.informatique.service.UserService;

	@Controller
	public class TachesController {

		@Autowired
		private TachesService tachesService;
		@Autowired
		private UserService userService;
		
		 
	    @RequestMapping(value = { "/newTaches" }, method = RequestMethod.GET)
	    public String newTicket(ModelMap model,HttpServletRequest request) {
	        Taches tache = new Taches();
	        model.addAttribute("tache", tache);
	        model.addAttribute("edit", false);
	        Iterable<User> user = userService.findTech("ROLE_TECH");
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        
	        if (request.isUserInRole("ADMIN"))
			  {	
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());
					model.addAttribute("users", user);
				  return "admin/tache"; 
				  
			  }
			  else if (request.isUserInRole("TECH"))
			  {
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());
					model.addAttribute("users", user);
				  return "tech/tache"; 
				  	
			  }
			return "/403";
	    }
	 
	    
	    @RequestMapping(value = { "/newTaches" }, method = RequestMethod.POST)
	    public String saveTicket(@Valid Taches tache, BindingResult result,
	            ModelMap model,HttpServletRequest request) {
		     if (request.isUserInRole("ADMIN"))
			  {	
			        if (result.hasErrors()) {
			            return "admin/tache";
			        }
					tache.setFaitTaches("0");
			        tachesService.save(tache);
			        return "redirect:admin/taches";   
				  
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			        if (result.hasErrors()) {
			            return "tech/tache";
			        }
					tache.setFaitTaches("0");
					tachesService.save(tache);
			        return "redirect:tech/taches";   
			  }
			return "/403";

		
	}
	}
