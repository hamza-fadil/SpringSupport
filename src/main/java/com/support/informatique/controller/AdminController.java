package com.support.informatique.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;
import com.support.informatique.service.TicketService;
import com.support.informatique.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private TicketService ticketService;
	@RequestMapping("/admin/index")
	public String users(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
		return "/admin/index";
	}
	
	@RequestMapping(value="/admin/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/";
		}
	
    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.GET)
    public String editUsers(@PathVariable int idUser, ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
        User user = userService.findOne(idUser);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "/admin/user";
    }
     

    @RequestMapping(value = { "/edit-{idUser}-User" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable int idUser) {
    	
        if (result.hasErrors()) {
            return "/admin/user";
        }
        userService.save(user);        
        return "redirect:admin/users";
 }

	@RequestMapping("/admin/tests")
	public String tests(ModelMap model) {
		  
		return "/tests/welcome";
	}
	@RequestMapping("/admin/users")
	public String Users(ModelMap model) {
		model.addAttribute("users",userService.findAll() );
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		  }
		return "/admin/users";
	}
	@RequestMapping("/admin/ticket")
	public String Tickets(ModelMap model) {
		model.addAttribute("tickets",ticketService.findAll() );
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	  
		return "/admin/tickets";
	}
	@RequestMapping("/admin/parc")
	public String materiel(ModelMap model) {
		  
		return "/admin/materiels";
	}
    /*
     * This method will provide the medium to update an existing Produit.
     */
    @RequestMapping(value = { "/edit-{idTicket}-Ticket" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idTicket, ModelMap model) {
        Ticket ticket = ticketService.findOne(idTicket);
        model.addAttribute("ticket", ticket);
        model.addAttribute("edit", true);
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
        return "tests/ticket";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Produit in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{idTicket}-Ticket" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Ticket ticket, BindingResult result,
            ModelMap model, @PathVariable int idTicket) {
 
        if (result.hasErrors()) {
            return "/admin/ticket";
        }
 
       
 
        ticketService.save(ticket);
 
        
        return "redirect:admin/tickets";
    }
    @RequestMapping(value = {"delete-{idTicket}-Ticket"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Ticket ticket,@PathVariable int idTicket) {
    	ticketService.deletebyId(idTicket);
    	return "redirect:admin/tickets";
    }
}
