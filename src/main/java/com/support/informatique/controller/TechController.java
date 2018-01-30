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

import com.support.informatique.service.ImprimanteService;
import com.support.informatique.service.MarqueService;
import com.support.informatique.service.MaterielService;
import com.support.informatique.service.OrdinateurService;
import com.support.informatique.service.RapportService;
import com.support.informatique.service.TachesService;
import com.support.informatique.service.TelephoneService;
import com.support.informatique.service.TicketService;

@Controller
public class TechController {
	@Autowired
	TicketService ticketService;
	@Autowired
	TachesService tacheService;
	@Autowired
	RapportService rapportService;
	@Autowired
	private MaterielService materielService;
	@Autowired
	private OrdinateurService ordinateurService;
	@Autowired
	private TelephoneService telephoneService;
	@Autowired
	private ImprimanteService imprimanteService;
	@Autowired
	private MarqueService marqueService;
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
	@RequestMapping("/tech/marques")
	public String marque(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("marques",marqueService.findAll());
		return "tech/marques";
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
	@RequestMapping("/tech/parcs")
	public String parc(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("materiels",materielService.findAll());
		return "/tech/parcs";
	}
	@RequestMapping("/tech/ordinateurs")
	public String ordinateurs(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("ordinateurs",ordinateurService.findAll());
		return "/tech/ordinateurs";
	}
	@RequestMapping("/tech/telephones")
	public String telephones(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("telephones",telephoneService.findAll());
		return "/tech/telephones";
	}
	@RequestMapping("/tech/imprimantes")
	public String imprimantes(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("imprimantes",imprimanteService.findAll());
		return "/tech/imprimantes";
	}
}
