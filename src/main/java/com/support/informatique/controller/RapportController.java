package com.support.informatique.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Conversation;
import com.support.informatique.entities.Rapport;
import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;
import com.support.informatique.service.RapportService;
import com.support.informatique.service.TicketService;
import com.support.informatique.service.UserService;

@Controller
public class RapportController {
	 
	
	 @Autowired
	 private RapportService rapportService;
	 @Autowired
	 private TicketService ticketService;
	 @Autowired
	 private UserService userService;
	 @RequestMapping(value = { "/newRapport" }, method = RequestMethod.GET)
	    public String newTicket(ModelMap model,HttpServletRequest request) {
	        Rapport rapport = new Rapport();
	        model.addAttribute("rapport", rapport);
	        model.addAttribute("edit", false);
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        
	         if (request.isUserInRole("ADMIN"))
			  {	
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());	
				  return "admin/rapport"; 
				  
			  }
			  else if (request.isUserInRole("TECH"))
			  {
				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
					model.addAttribute("username", userDetail.getUsername());
				  return "tech/rapport"; 
				  	
			  }
			return "/403";
	    }
	 @RequestMapping(value = { "/newRapport" }, method = RequestMethod.POST)
	    public String saveTicket(@Valid Rapport rapport, BindingResult result,ModelMap model,HttpServletRequest request) {
	    	if (request.isUserInRole("ADMIN"))
			  {	
			        if (result.hasErrors()) {
			            return "admin/rapport";
			        }
					rapportService.save(rapport);
			        return "redirect:admin/rapport";   
				  
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			        if (result.hasErrors()) {
			            return "tech/rapport";
			        }
			        rapportService.save(rapport);
			        return "redirect:tech/rapport";   
	
				  	
			  }
			return "/403";
	 }
	    @RequestMapping(value = { "/add-{idTicket}-Rapport" }, method = RequestMethod.GET)
	    public String addRapport(@PathVariable int idTicket, ModelMap model,HttpServletRequest request) {
	    	Rapport rapport = new Rapport();
	    	model.addAttribute("rapport", rapport);
	        model.addAttribute("idTicket", idTicket);
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
	    	if (request.isUserInRole("ADMIN"))
			  {	
			        return "/admin/rapport";   
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			        return "/tech/rapport";   
			  }
			return "/403";
			}
	    @RequestMapping(value = { "/add-{idTicket}-Rapport" }, method = RequestMethod.POST)
	    public String updateUser(@Valid Rapport rapport, BindingResult result,
	            ModelMap model, @PathVariable int idTicket,HttpServletRequest request) {
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    	User user = userService.findByUsername(userDetail.getUsername());
	    	Ticket ticket = ticketService.findOne(idTicket);
	    	rapport.setTicket(ticket);
	    	rapport.setUser(user);
	        rapportService.save(rapport);        
	    	if (request.isUserInRole("ADMIN"))
			  {	
			        if (result.hasErrors()) {
			            return "admin/rapport";
			        }
			        return "redirect:admin/ticket";   
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			        if (result.hasErrors()) {
			            return "tech/rapport";
			        }
			        return "redirect:tech/ticket";   
			  }
			return "/403";
			}
	    @RequestMapping(value = {"delete-{idRapport}-Rapport"}, method = RequestMethod.GET)
	    public String deleteTicket(@Valid Rapport rapport,@PathVariable int idRapport, BindingResult result,HttpServletRequest request) {
	    	rapportService.delete(rapportService.findOne(idRapport));
	    	if (request.isUserInRole("ADMIN"))
			  {	
			        if (result.hasErrors()) {
			            return "admin/rapport";
			        }
			        return "redirect:admin/report";   
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			        if (result.hasErrors()) {
			            return "tech/rapport";
			        }
			        return "redirect:tech/report";   
			  }
			return "/403";
			}
	    
	@RequestMapping(value = { "/read-{idRapport}-Rapport" }, method = RequestMethod.GET)
	public String readTicket(@PathVariable int idRapport,
	        ModelMap model,HttpServletRequest request) {
	    Rapport rapport= rapportService.findOne(idRapport);
	    model.addAttribute("rapport", rapport);
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		    if (request.isUserInRole("USER")) {
		            return "user/rrapport";
			  } 
		    else if (request.isUserInRole("ADMIN"))
			  {	
			            return "admin/rrapport";
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			            return "tech/rrapport";
			  }
			return "/403";
	}
	
    @RequestMapping(value = { "/edit-{idRapport}-Rapport" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idRapport,
            ModelMap model,HttpServletRequest request) {
        Rapport rapport = rapportService.findOne(idRapport);
        model.addAttribute("rapport", rapport);
        model.addAttribute("edit", true);
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
		    if (request.isUserInRole("USER")) {
		            return "user/report";
			  } 
		    else if (request.isUserInRole("ADMIN"))
			  {	
			            return "admin/rapport";
			  }
			  else if (request.isUserInRole("TECH"))
			  {		  
			            return "tech/rapport";
			  }
			return "/403";
    }
    @RequestMapping(value = { "/edit-{idRapport}-Rapport" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Rapport rapport, BindingResult result,
            ModelMap model, @PathVariable int idRapport,HttpServletRequest request) {
	    if (request.isUserInRole("USER")) {
	        if (result.hasErrors()) {
	            return "/user/ticket";
	        }
	        rapport.setUser(rapport.getUser());
	        rapportService.save(rapport);
	        return "/edit-{idRapport}-Rapport";
		  } 
	    else if (request.isUserInRole("ADMIN"))
		  {	
	        if (result.hasErrors()) {
	            return "/admin/report";
	        }
	        Rapport oldRapport = rapportService.findOne(idRapport);
	        rapport.setTicket(oldRapport.getTicket());
	        rapport.setUser(oldRapport.getUser());
	        rapportService.save(rapport);
	        return "redirect:read-{idRapport}-Rapport";
		  }
		  else if (request.isUserInRole("TECH"))
		  {		  
		        if (result.hasErrors()) {
		            return "/edit-{idTicket}-Ticket";
		        }
		        
		        Rapport oldRapport = rapportService.findOne(idRapport);
		        rapport.setUser(oldRapport.getUser());
		        rapportService.save(rapport);
		        return "redirect:read-{idRapport}-Rapport";
		  }
		return "/403";
    }
	
}
	    //END
