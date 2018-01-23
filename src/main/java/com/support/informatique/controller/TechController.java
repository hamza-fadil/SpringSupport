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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.service.RapportService;
import com.support.informatique.service.TachesService;
import com.support.informatique.service.TicketService;

@Controller
public class TechController {
	@Autowired
	TicketService ticketService;
	@Autowired
	TachesService tacheService;
	@Autowired
	RapportService rapportService;
	@RequestMapping("/tech/index")
	public String users(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		return "tech/index";
	}
	
	@RequestMapping(value="/tech/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/";
		}

	@RequestMapping("/tech/ticket")
	public String Tickets(ModelMap model) {
		model.addAttribute("tickets",ticketService.findAll() );
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());
		return "tech/tickets";
		
	}
	@RequestMapping("/tech/parc")
	public String materiel(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());
		return "tech/materiels";
	}
	@RequestMapping("/tech/taches")
	public String taches(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("taches", tacheService.findAll());
		return "/tech/taches";
	}
	@RequestMapping("/tech/report")
	public String report(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("rapports",rapportService.findAll());
		return "/tech/report";
	}
}
