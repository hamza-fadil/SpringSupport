package com.support.informatique.web;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.support.informatique.entities.Fichier;
import com.support.informatique.entities.Ticket;
import com.support.informatique.metier.FichierService;
import com.support.informatique.metier.TicketService;

@Controller
public class FichierController {
	@Autowired
	private FichierService fichierService;
	@Autowired
	private TicketService ticketService;
	
	
	
	@PostMapping("/fichier") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            
            Fichier fichier = new Fichier();
            fichier.setNomOrigine(file.getOriginalFilename()); 
            fichier.setFichierJoint(bytes);
    		Ticket ticket = new Ticket();
    		ticket = ticketService.findById(1);
            fichier.setTicket(ticket);
            fichierService.save(fichier);
            redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
	
	@RequestMapping("/fichiers")
	public String fichiers(ModelMap model) {
		
		model.addAttribute("fichiers",fichierService.findAll() );
		return "fichiers";
	}
	@RequestMapping(value = { "/fichier" })
    public String addFichier(ModelMap model) {
        return "fichier";
    }
//    @RequestMapping(value = { "/newFichier" })
//    public String newProduit(ModelMap model) throws IOException {
//		File file = new File("/home/siqaos/Documents/Polytechnique/image.jpg");
//		Ticket ticket = new Ticket();
//		ticket = ticketService.findById(1);
//		Fichier fichier = new Fichier();
//		byte[] picInBytes = new byte[(int) file.length()];
//		FileInputStream fileInputStream = new FileInputStream(file);
//		fileInputStream.read(picInBytes);
//		fileInputStream.close();
//		fichier.setFichierJoint(picInBytes);
//		fichier.setTicket(ticket);
//		fichierService.save(fichier);
//        return "redirect:/fichiers";
//    }
    @RequestMapping(value = { "/get-{idFichier}-Fichier" })
    public String getFichier(@PathVariable int idFichier,ModelMap model,HttpServletResponse response ) throws IOException {
    	Fichier nomfichier = fichierService.findOne(idFichier);
    	String filename = nomfichier.getNomOrigine();
    	response.setContentType("application/octet-stream");
    	response.setHeader("Content-Disposition","attachment;filename="+ filename );
		byte[] fichier = fichierService.findFichier(idFichier);
		InputStream in = new ByteArrayInputStream(fichier);
    	ServletOutputStream out = response.getOutputStream();
    	while(in.read(fichier, 0, 4096) != -1)
    	{
    		out.write(fichier, 0, 4096);
    	}
    	in.close();
    	out.flush();
    	out.close();
        model.addAttribute("tele", true);
		return "fichiers";
    }
 
    @RequestMapping(value = {"delete-{idFichier}-Fichier"}, method = RequestMethod.GET)
    public String deleteTicket(@Valid Fichier fichier,@PathVariable int idFichier) {
    	fichierService.deletebyId(idFichier);
    	return "redirect:/fichiers";
    }
}
