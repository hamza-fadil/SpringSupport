package com.support.informatique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Panne;
import com.support.informatique.service.PanneService;
@Controller
public class PanneController {
	@Autowired
	private PanneService panneService;
	
	
	
	@RequestMapping("/pannes")
	public String pannes(ModelMap model) {
		
		model.addAttribute("pannes",panneService.findAll() );
		return "tests/pannes";
	}
	 
    @RequestMapping(value = { "/newPanne" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Panne panne = new Panne();
        model.addAttribute("panne", panne);
        model.addAttribute("edit", false);
        return "tests/panne";
    }
 
    
    @RequestMapping(value = { "/newPanne" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Panne panne, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "tests/panne";
        }
        panneService.save(panne);
        
        return "redirect:/tests/pannes";   
    }
    
    /*
     * This method will provide the medium to update an existing Panne.
     */
    @RequestMapping(value = { "/edit-{idPanne}-Panne" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idPanne, ModelMap model) {
        Panne panne = panneService.findOne(idPanne);
        model.addAttribute("panne", panne);
        model.addAttribute("edit", true);
        return "tests/panne";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Panne in database. It also validates the panne input
     */
    @RequestMapping(value = { "/edit-{idPanne}-Panne" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Panne panne, BindingResult result,
            ModelMap model, @PathVariable int idPanne) {
 
        if (result.hasErrors()) {
            return "tests/panne";
        }
 
       
 
        panneService.save(panne);
 
        
        return "redirect:/pannes";
    }
    @RequestMapping(value = {"delete-{idPanne}-Panne"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Panne panne,@PathVariable int idPanne) {
    	panneService.deletebyId(idPanne);
    	return "redirect:/pannes";
    }
}
