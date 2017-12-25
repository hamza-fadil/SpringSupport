package com.support.informatique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Reparation;
import com.support.informatique.service.ReparationService;
@Controller
public class ReparationController {
	@Autowired
	private ReparationService reparationService;
	
	
	
	@RequestMapping("/reparations")
	public String reparations(ModelMap model) {
		
		model.addAttribute("reparations",reparationService.findAll() );
		return "tests/reparations";
	}
	 
    @RequestMapping(value = { "/newReparation" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Reparation produit = new Reparation();
        model.addAttribute("reparation", produit);
        model.addAttribute("edit", false);
        return "tests/reparation";
    }
 
    
    @RequestMapping(value = { "/newReparation" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Reparation reparation, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "tests/reparation";
        }
        reparationService.save(reparation);
        
        return "redirect:/tests/reparations";   
    }
    
    /*
     * This method will provide the medium to update an existing Produit.
     */
    @RequestMapping(value = { "/edit-{idReparation}-Reparation" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idReparation, ModelMap model) {
        Reparation reparation = reparationService.findOne(idReparation);
        model.addAttribute("reparation", reparation);
        model.addAttribute("edit", true);
        return "tests/reparation";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Produit in database. It also validates the reparation input
     */
    @RequestMapping(value = { "/edit-{idReparation}-Reparation" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Reparation reparation, BindingResult result,
            ModelMap model, @PathVariable int idReparation) {
 
        if (result.hasErrors()) {
            return "tests/reparation";
        }
 
       
 
        reparationService.save(reparation);
 
        
        return "redirect:/tests/reparations";
    }
    @RequestMapping(value = {"delete-{idReparation}-Reparation"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Reparation reparation,@PathVariable int idReparation) {
    	reparationService.deletebyId(idReparation);
    	return "redirect:/tests/reparations";
    }
}
