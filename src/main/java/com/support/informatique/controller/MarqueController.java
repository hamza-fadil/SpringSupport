package com.support.informatique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Marque;
import com.support.informatique.service.MarqueService;
@Controller
public class MarqueController {
	@Autowired
	private MarqueService marqueService;
	
	
	
	@RequestMapping("/marques")
	public String marques(ModelMap model) {
		
		model.addAttribute("marques",marqueService.findAll() );
		return "tests/marques";
	}
	 
    @RequestMapping(value = { "/newMarque" }, method = RequestMethod.GET)
    public String marque(ModelMap model) {
        Marque marque = new Marque();
        model.addAttribute("marque", marque);
        model.addAttribute("edit", false);
        return "tests/marque";
    }
 
    
    @RequestMapping(value = { "/newMarque" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Marque marque, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "marque";
        }
        marqueService.save(marque);
        
        return "redirect:/tests/marques";   
    }
    
    /*
     * This method will provide the medium to update an existing Marque.
     */
    @RequestMapping(value = { "/edit-{idMarque}-Marque" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idMarque, ModelMap model) {
        Marque marque = marqueService.findOne(idMarque);
        model.addAttribute("marque", marque);
        model.addAttribute("edit", true);
        return "tests/marque";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Marque in database. It also validates the marque input
     */
    @RequestMapping(value = { "/edit-{idMarque}-Marque" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Marque marque, BindingResult result,
            ModelMap model, @PathVariable int idMarque) {
 
        if (result.hasErrors()) {
            return "tests/marque";
        }
 
       
 
        marqueService.save(marque);
 
        
        return "redirect:/tests/marques";
    }
    @RequestMapping(value = {"delete-{idMarque}-Marque"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Marque marque,@PathVariable int idMarque) {
    	marqueService.deletebyId(idMarque);
    	return "redirect:/tests/marques";
    }
}
