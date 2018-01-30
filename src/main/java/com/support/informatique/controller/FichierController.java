package com.support.informatique.controller;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.support.informatique.entities.Fichier;
import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;
import com.support.informatique.service.FichierService;
import com.support.informatique.service.TicketService;

@Controller
public class FichierController {
	@Autowired
	private FichierService fichierService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	ServletContext servletContext;
//	


	

	@RequestMapping(value = { "add-{idTicket}" }, method = RequestMethod.POST)
	public String addFichier(@RequestParam("file") MultipartFile file,HttpServletRequest request,@PathVariable int idTicket, RedirectAttributes redirectAttrs) throws IOException {
		if(file.getSize() > 2000000) {
			redirectAttrs.addFlashAttribute("tooFAT", "La taille du fichier est trop élevée, 2Mo Maximum");
			return "redirect:/read-{idTicket}-Ticket";
		}else {
		Fichier fichier = new Fichier();
		fichier.setTicket(ticketService.findOne(idTicket));
		fichier.setNomOrigine(file.getOriginalFilename());
		fichier.setFichierJoint(file.getBytes());
		fichierService.save(fichier);
		return "redirect:/read-{idTicket}-Ticket";
		}
    }

	@RequestMapping(value = { "image/{idFichier}" }, method = RequestMethod.GET)
	public void getFichier(@PathVariable int idFichier, HttpServletResponse response) throws IOException {
		Fichier fichierD = fichierService.findOne(idFichier);
		response.setContentType("octet/stream"); 
		if (fichierD != null) {
            response.getOutputStream().write(fichierD.getFichierJoint());
		} 
	}
 
    @RequestMapping(value = {"delete-{idFichier}-Fichier"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Fichier fichier,@PathVariable int idFichier) {
    	Fichier fichierD = fichierService.findOne(idFichier);
    	int a = fichierD.getTicket().getIdTicket();
    	fichierService.deletebyId(idFichier);
        return "redirect:/read-"+a+"-Ticket";
    }
}
