package com.support.informatique.controller;

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
	@RequestMapping("/materiels")
	public String materiels(ModelMap model) {
	
		model.addAttribute("materiels",materielService.findAll() );
		return "tests/materiels";
	}

    @RequestMapping(value = {"view-{idMateriel}-Materiel"}, method = RequestMethod.GET)
    public String viewTicket(@PathVariable int idMateriel,ModelMap model) {
    	Ordinateur ordinateur = ordinateurService.findById(idMateriel);
    	Imprimante imprimante = imprimanteService.findById(idMateriel);
    	Telephone telephone = telephoneService.findById(idMateriel);
    	if (ordinateur!=null) {
        	model.addAttribute("ordinateur", ordinateur);
        	model.addAttribute("ord", true);
        	return "tests/ordinateurs";
		} else if (imprimante!=null) {
			model.addAttribute("imprimante", imprimante);
        	model.addAttribute("imp", true);
        	return "tests/imprimantes";
		}
		else {
			model.addAttribute("telephone", telephone);
        	model.addAttribute("imp", true);
        	return "tests/telephones";
		}

    	
    }
}
