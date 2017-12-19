package com.support.informatique.web;
// Classe en attente de validation



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.support.informatique.entities.Imprimante;
import com.support.informatique.entities.Materiel;
import com.support.informatique.entities.Ordinateur;
import com.support.informatique.entities.Telephone;
import com.support.informatique.metier.ImprimanteService;
import com.support.informatique.metier.MarqueService;
import com.support.informatique.metier.MaterielService;
import com.support.informatique.metier.OrdinateurService;
import com.support.informatique.metier.TelephoneService;

@Controller
public class MaterielController {
	@Autowired
	private MaterielService materielService;
	@Autowired
	private OrdinateurService ordinateurService;
	@Autowired
	private MarqueService marqueService;
	@Autowired
	private ImprimanteService imprimanteService;
	@Autowired
	private TelephoneService telephoneService;
	@RequestMapping("/materiels")
	public String materiels(ModelMap model) {
	
		model.addAttribute("materiels",materielService.findAll() );
		return "materiels";
	}

    @RequestMapping(value = {"view-{idMateriel}-Materiel"}, method = RequestMethod.GET)
    public String viewTicket(@PathVariable int idMateriel,ModelMap model) {
    	Ordinateur ordinateur = ordinateurService.findById(idMateriel);
    	Imprimante imprimante = imprimanteService.findById(idMateriel);
    	Telephone telephone = telephoneService.findById(idMateriel);
    	if (ordinateur!=null) {
        	model.addAttribute("ordinateur", ordinateur);
        	model.addAttribute("ord", true);
        	return "ordinateurs";
		} else if (imprimante!=null) {
			model.addAttribute("imprimante", imprimante);
        	model.addAttribute("imp", true);
        	return "imprimantes";
		}
		else {
			model.addAttribute("telephone", telephone);
        	model.addAttribute("imp", true);
        	return "telephones";
		}

    	
    }
}
