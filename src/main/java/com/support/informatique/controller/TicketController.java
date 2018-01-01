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

import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;
import com.support.informatique.service.TicketService;
import com.support.informatique.service.UserService;

	@Controller
	public class TicketController {

		@Autowired
		private TicketService ticketService;
		@Autowired
		private UserService userService;
		
		
		@RequestMapping("/tickets")
		public String tickets(ModelMap model) {
			
			model.addAttribute("tickets",ticketService.findAll() );
			return "tests/tickets";
		}
		 
	    @RequestMapping(value = { "/newTicket" }, method = RequestMethod.GET)
	    public String newTicket(ModelMap model,HttpServletRequest request) {
	        Ticket produit = new Ticket();
	        model.addAttribute("ticket", produit);
	        model.addAttribute("edit", false);
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        
	        if (request.isUserInRole("USER")) {
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());
				  return "/user/ticket";
				  	
			  } else if (request.isUserInRole("ADMIN"))
			  {	
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());	
				  return "/admin/ticket"; 
				  
			  }
			  else if (request.isUserInRole("TECH"))
			  {
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());
				  return "/tech/ticket"; 
				  	
			  }
			return "/403";
	    }
	 
	    
	    @RequestMapping(value = { "/newTicket" }, method = RequestMethod.POST)
	    public String saveTicket(@Valid Ticket ticket, BindingResult result,
	            ModelMap model,HttpServletRequest request) {
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (request.isUserInRole("USER")) {
		        if (result.hasErrors()) {
		            return "user/ticket";
		        }
		        UserDetails userDetail = (UserDetails) auth.getPrincipal();
				User user = new User();
				user = userService.findByUsername(userDetail.getUsername());
				ticket.setUser(user);
		        ticketService.save(ticket);	        
		        return "redirect:user/ticket";   
	
				  	
			  } 
		    else if (request.isUserInRole("ADMIN"))
			  {	
	
			        if (result.hasErrors()) {
			            return "admin/ticket";
			        }
			        
			        UserDetails userDetail = (UserDetails) auth.getPrincipal();
					User user = new User();
					user = userService.findByUsername(userDetail.getUsername());
					ticket.setUser(user);
			        ticketService.save(ticket);
			        
			        return "redirect:admin/ticket";   
				  
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			        if (result.hasErrors()) {
			            return "tech/ticket";
			        }
			        
			        UserDetails userDetail = (UserDetails) auth.getPrincipal();
					User user = new User();
					user = userService.findByUsername(userDetail.getUsername());
					ticket.setUser(user);
			        ticketService.save(ticket);
			        
			        return "redirect:tech/ticket";   
	
				  	
			  }
			return "/403";

		
	}
	}
