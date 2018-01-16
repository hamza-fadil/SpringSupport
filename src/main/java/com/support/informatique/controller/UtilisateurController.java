package com.support.informatique.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;
import com.support.informatique.service.TicketService;
import com.support.informatique.service.UserService;

@Controller
public class UtilisateurController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private UserService userService;
	@RequestMapping("/user/index")
	public String users(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		return "/user/index";
	}
	
	@RequestMapping(value="/user/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/";
		}
	@RequestMapping("/user/ticket")
	public String Tickets(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());
		User user = userService.findByUsername(userDetail.getUsername());
		model.addAttribute("tickets",ticketService.findByuserId(user));
		
		return "/user/tickets";
	}
	 @RequestMapping(value = {"view-{idTicket}-Ticket"}, method = RequestMethod.GET)
	    public String viewTicket(@PathVariable int idTicket,ModelMap model) {
	    	Ticket ticket = ticketService.findById(idTicket);
	        	model.addAttribute("tickets", ticket);
	        	return "user/tickets";
			

	    	
	    }
}
