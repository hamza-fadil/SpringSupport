package com.support.informatique.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
import com.support.informatique.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private TachesService tachesService;
	@Autowired
	private MaterielService materielService;
	@Autowired
	private OrdinateurService ordinateurService;
	@Autowired
	private TelephoneService telephoneService;
	@Autowired
	private ImprimanteService imprimanteService;
	@Autowired
	private RapportService rapportService;
	@Autowired
	private MarqueService marqueService;
	
	@RequestMapping("/admin/index")
	public String index(ModelMap model) {
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
	@RequestMapping("/admin/taches")
	public String taches(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("taches", tachesService.findAll());
		return "/admin/taches";
	}
	@RequestMapping("/admin/parcs")
	public String parc(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("materiels",materielService.findAll());
		return "/admin/parcs";
	}
	@RequestMapping("/admin/ordinateurs")
	public String ordinateurs(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("ordinateurs",ordinateurService.findAll());
		return "/admin/ordinateurs";
	}
	@RequestMapping("/admin/telephones")
	public String telephones(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("telephones",telephoneService.findAll());
		return "/admin/telephones";
	}
	@RequestMapping("/admin/imprimantes")
	public String imprimantes(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("imprimantes",imprimanteService.findAll());
		return "/admin/imprimantes";
	}
	@RequestMapping("/admin/newsletter")
	public String newsletter(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		return "/admin/newsletter";
	}
	@RequestMapping("/admin/report")
	public String report(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("rapports",rapportService.findAll());
		return "/admin/report";
	}
	@RequestMapping("/admin/marques")
	public String marque(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("marques",marqueService.findAll());
		return "admin/marques";
	}
	
}
