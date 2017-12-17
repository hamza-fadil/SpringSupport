package com.support.informatique.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Imprimante;
import com.support.informatique.metier.ImprimanteService;
@Controller
public class ImprimanteController {
	@Autowired
	private ImprimanteService imprimanteService;
	
	
	
	@RequestMapping("/imprimantes")
	public String imprimantes(ModelMap model) {
		
		model.addAttribute("imprimantes",imprimanteService.findAll() );
		return "imprimantes";
	}
	 
    @RequestMapping(value = { "/newImprimante" }, method = RequestMethod.GET)
    public String newProduit(ModelMap model) {
        Imprimante imprimante = new Imprimante();
        model.addAttribute("imprimante", imprimante);
        model.addAttribute("edit", false);
        return "imprimante";
    }
 
    
    @RequestMapping(value = { "/newImprimante" }, method = RequestMethod.POST)
    public String saveProduit(@Valid Imprimante imprimante, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "imprimante";
        }
        imprimanteService.save(imprimante);
        
        return "redirect:/imprimantes";   
    }
    
    /*
     * This method will provide the medium to update an existing Imprimante.
     */
    @RequestMapping(value = { "/edit-{idMateriel}-Imprimante" }, method = RequestMethod.GET)
    public String editTicket(@PathVariable int idMateriel, ModelMap model) {
        Imprimante imprimante = imprimanteService.findOne(idMateriel);
        model.addAttribute("imprimante", imprimante);
        model.addAttribute("edit", true);
        return "imprimante";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Imprimante in database. It also validates the imprimante input
     */
    @RequestMapping(value = { "/edit-{idMateriel}-Imprimante" }, method = RequestMethod.POST)
    public String updateTicket(@Valid Imprimante imprimante, BindingResult result,
            ModelMap model, @PathVariable int idMateriel) {
 
        if (result.hasErrors()) {
            return "imprimante";
        }
 
       
 
        imprimanteService.save(imprimante);
 
        
        return "redirect:/imprimantes";
    }
    @RequestMapping(value = {"delete-{idMateriel}-Imprimante"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Imprimante imprimante,@PathVariable int idMateriel) {
    	imprimanteService.delete(idMateriel);
    	return "redirect:/imprimantes";
    }
}
