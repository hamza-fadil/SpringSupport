package com.support.informatique.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Imprimante;
import com.support.informatique.entities.Ordinateur;
import com.support.informatique.entities.Telephone;
import com.support.informatique.service.ImprimanteService;
import com.support.informatique.service.MaterielService;
import com.support.informatique.service.OrdinateurService;
import com.support.informatique.service.TelephoneService;

@Controller
public class MaterielController {
	@Autowired
	private MaterielService materielService;
	@Autowired
	private OrdinateurService ordinateurService;
	@Autowired
	private ImprimanteService imprimanteService;
	@Autowired
	private TelephoneService telephoneService;

    @RequestMapping(value = {"/view-{idMateriel}-Materiel"}, method = RequestMethod.GET)
    public String viewTicket(@PathVariable int idMateriel,ModelMap model,HttpServletRequest request) {
    	Ordinateur ordinateur = ordinateurService.findById(idMateriel);
    	Imprimante imprimante = imprimanteService.findById(idMateriel);
    	Telephone telephone = telephoneService.findById(idMateriel);
    	if (ordinateur!=null) {
        	model.addAttribute("ordinateur", ordinateur);
        	model.addAttribute("ord", true);
    	    if (request.isUserInRole("ADMIN"))
  		  {	  		        
  		        return "redirect:admin/ordinateurs";   
  		  }
  		  else if (request.isUserInRole("TECH"))
  		  {
  		        return "redirect:tech/ordinateurs";   
  		  }
		} else if (imprimante!=null) {
			model.addAttribute("imprimante", imprimante);
        	model.addAttribute("imp", true);
    	    if (request.isUserInRole("ADMIN"))
  		  {	  		        
  		        return "redirect:admin/imprimantes";   
  		  }
  		  else if (request.isUserInRole("TECH"))
  		  {
  		        return "redirect:tech/imprimantes";   
  		  }
		}
		else {
			model.addAttribute("telephone", telephone);
        	model.addAttribute("tel", true);
    	    if (request.isUserInRole("ADMIN"))
  		  {	  		        
  		        return "redirect:admin/telephones";   
  		  }
  		  else if (request.isUserInRole("TECH"))
  		  {
  		        return "redirect:tech/telephones";   
  		  }		}
		return "/403";
    }
    @RequestMapping(value = {"delete-{idMateriel}-Materiel"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Ordinateur ordinateur,@PathVariable int idMateriel,HttpServletRequest request) {
    	materielService.delete(idMateriel);
	    if (request.isUserInRole("ADMIN"))
		  {	
		        return "redirect:admin/parcs";   
		  }
		  else if (request.isUserInRole("TECH"))
		  {
		        return "redirect:tech/parcs";   
		  }
		return "/403";
    }

//	 @RequestMapping(value = { "/newOrdinateur" }, method = RequestMethod.GET)
//	    public String newTicket(ModelMap model,HttpServletRequest request) {
//	        Ordinateur ordinateur = new Ordinateur();
//	        model.addAttribute("ordinateur", ordinateur);
//	        model.addAttribute("edit", false);
//	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	        
//	         if (request.isUserInRole("ADMIN"))
//			  {	
//				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
//					model.addAttribute("username", userDetail.getUsername());	
//				  return "/admin/ordinateur"; 
//				  
//			  }
//			  else if (request.isUserInRole("TECH"))
//			  {
//				  UserDetails userDetail = (UserDetails) auth.getPrincipal();
//					model.addAttribute("username", userDetail.getUsername());
//				  return "/tech/ordinateur"; 
//				  	
//			  }
//			return "/403";
//	    }
//	 @RequestMapping(value = { "/newOrdinateur" }, method = RequestMethod.POST)
//	    public String saveTicket(@Valid Ordinateur ordinateur, BindingResult result,
//	            ModelMap model,HttpServletRequest request) {
//		    if (request.isUserInRole("ADMIN"))
//			  {	
//			        if (result.hasErrors()) {
//			            return "admin/ordinateur";
//			        }     
//			        ordinateurService.save(ordinateur);
//			        
//			        return "redirect:admin/parcs";   
//				  
//			  }
//			  else if (request.isUserInRole("TECH"))
//			  {		  
//			        if (result.hasErrors()) {
//			            return "tech/ordinateur";
//			        }
//					ordinateurService.save(ordinateur);
//			        return "redirect:tech/parcs";   
//	
//				  	
//			  }
//			return "/403";
//
//		
//	}

}
