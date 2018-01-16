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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.service.ImprimanteService;
import com.support.informatique.service.MarqueService;
import com.support.informatique.entities.Imprimante;
@Controller
public class ImprimanteController {
	@Autowired
	private ImprimanteService imprimanteService;
	@Autowired
	private MarqueService marqueService;
	
	

 
    @RequestMapping(value = { "/newImprimante" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model,HttpServletRequest request) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Imprimante imprimante = new Imprimante();
        model.addAttribute("imprimante", imprimante);
        model.addAttribute("edit", false);
        model.addAttribute("marques",marqueService.findAll() );
        model.addAttribute("marque",marqueService.findName() );
        if (request.isUserInRole("ADMIN"))
		  {	
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());	
			  return "/admin/imprimante"; 
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addAttribute("username", userDetail.getUsername());
			  return "/tech/imprimante"; 
			  	
		  }
		return "/403";
   }
    
    @RequestMapping(value = { "/newImprimante" }, method = RequestMethod.POST)
    public String saveTicket(@Valid Imprimante imprimante, BindingResult result, ModelMap model,HttpServletRequest request) {
	    if (request.isUserInRole("ADMIN"))
		  {	
		        if (result.hasErrors()) {
		            return "admin/imprimante";
		        }     
		        imprimanteService.save(imprimante);
		        
		        return "redirect:admin/parcs";   
			  
		  }
		  else if (request.isUserInRole("TECH"))
		  {		  
		        if (result.hasErrors()) {
		            return "tech/imprimante";
		        }
				imprimanteService.save(imprimante);
		        return "redirect:tech/parcs";   
		  	
		  }
		return "/403";	
}

//    @RequestMapping(value = { "/edit-{idMateriel}-Imprimante" }, method = RequestMethod.GET)
//    public String editTicket(@PathVariable int idMateriel, ModelMap model) {
//        Imprimante imprimante = imprimanteService.findOne(idMateriel);
//        Marque selecteMarque = marqueService.findOne(idMateriel);
//        model.addAttribute("imprimante", imprimante);
//        model.addAttribute("edit", true);
//        model.addAttribute("marque", selecteMarque);
//        model.addAttribute("marques",marqueService.findAll() );
//        
//        return "tests/imprimante";
//    }
//     
//    @RequestMapping(value = { "/edit-{idMateriel}-Imprimante" }, method = RequestMethod.POST)
//    public String updateTicket(@Valid Imprimante imprimante, BindingResult result,
//            ModelMap model, @PathVariable int idMateriel) {
// 
//        if (result.hasErrors()) {
//            return "tests/imprimante";
//        }
// 
//       
// 
//        imprimanteService.save(imprimante);
//
//        
//        return "redirect:/tests/imprimantes";
//    }
    @RequestMapping(value = {"delete-{idMateriel}-Imprimante"}, method = RequestMethod.GET)
    public String deleteImprimante(@Valid Imprimante imprimante,@PathVariable int idMateriel) {
    	imprimanteService.delete(idMateriel);
    	return "redirect:/tests/imprimantes";
    }
}
