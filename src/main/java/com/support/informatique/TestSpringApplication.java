package com.support.informatique;

import org.springframework.beans.factory.annotation.Autowired;

//
//import java.io.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.service.TicketService;

//import com.support.informatique.entities.Fichier;
//import com.support.informatique.entities.Marque;
//import com.support.informatique.entities.Materiel;
//import com.support.informatique.entities.Ordinateur;
//import com.support.informatique.entities.Ticket;
//import com.support.informatique.metier.ConversationService;
//import com.support.informatique.metier.FichierService;
//import com.support.informatique.metier.ImprimanteService;
//import com.support.informatique.metier.MarqueService;
//import com.support.informatique.metier.MaterielService;
//import com.support.informatique.metier.OrdinateurService;
//import com.support.informatique.metier.PanneService;
//import com.support.informatique.metier.ReparationService;
//import com.support.informatique.metier.TelephoneService;
//import com.support.informatique.metier.TicketService;
//import com.support.informatique.metier.UserService;




@SpringBootApplication
public class TestSpringApplication implements CommandLineRunner {
//
//	@Autowired
//	private UserService userMetierImpl;
//	@Autowired
//	private TicketService ticketMetierImpl;
//	@Autowired
//	private ReparationService reparationMetierImpl;
//	@Autowired
//	private PanneService panneMetierImpl;
//	@Autowired
//	private MaterielService materielMetierImpl;
//	@Autowired
//	private MarqueService marqueMetierImpl;
//	@Autowired
//	private FichierService fichierMetierImpl;
//	@Autowired
//	private ConversationService conversationMetierImpl;
//	@Autowired
//	private ImprimanteService imprimanteMetierImpl;
//	@Autowired
//	private TelephoneService telephoneMetierImpl;
//	@Autowired
//	private OrdinateurService ordinateurMetierImpl;
	@Autowired
	private TicketService ticketService;
	
	public static void main(String[] args) {
		SpringApplication.run(TestSpringApplication.class, args);
		
	}
	
	@Transactional
    @Override
    public void run(String... args) throws Exception {
//////		Creation d'utilisateurs
//		User user = new User();
//		user.setEmail("h.test@gmail.com");
//		user.setPassword("salut");
//		user.setTypeUser("test");
//		user.setUsername("test");
//		userMetierImpl.save(user);
//		userMetierImpl.findAll();
////		
////		
////		
//////		 Creation de tickets
//		Ticket ticket = new Ticket();
//		ticket.setContTicket("Bonjour ceci est un ticket svp aidez moi");
//		ticket.setTitreTicket("test");
//		ticket.setTypeTicket("U");
//		user = userMetierImpl.findById(1);
//		ticket.setUser(user);
//		ticketMetierImpl.save(ticket);
////
//////		Creation de conversation
//		ticket = ticketMetierImpl.findById(1);
//		Conversation conversation = new Conversation();
//		conversation.setContenuConversation("Bonjour, j'aimerais faire part d'un petit probleme, C'est extrement long et répétitif j'aimerais passer a autre chose merci");
//		conversation.setTicket(ticket);
//		conversationMetierImpl.save(conversation);
////		
//////		Creation de fichier
////		Ticket ticket = new Ticket();
//		ticket = ticketMetierImpl.findById(1);
//		Fichier fichier = new Fichier();
//		File file = new File("C:/est.jpg");
//		byte[] imageData = new byte[(int) file.length()];
//		Blob blob = new javax.sql.rowset.serial.SerialBlob(imageData);
//		try {
//		    FileInputStream fileInputStream = new FileInputStream(file);
//		    fileInputStream.read(imageData);
//		    fileInputStream.close();
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//		// System.out.println("Salut" + file.length()); // Debuggage pendant la creation de TinyBlob c'était frustrant
//		fichier.setFichierJoint(blob);
//		fichier.setTicket(ticket);
//		fichierMetierImpl.save(fichier);
////		
//////		Creation de Marque
//		Marque marque = new Marque();
//		marque.setNomMarque("HP");
//		marqueMetierImpl.save(marque);
//		Marque marque1 = new Marque();
//		marque1.setNomMarque("Dell");
//		marqueMetierImpl.save(marque1);
//		Marque marque2 = new Marque();
//		marque2.setNomMarque("Lenovo");
//		marqueMetierImpl.save(marque2);
////		


		
//		Creation de panne
//		Panne panne = new Panne();
//		panne.setNomPanne("Alimentation");
//		panne.setDescPanne("Alimentation defaillante");
//		Imprimante materielEnPanne = imprimanteMetierImpl.findById(4); // attention ID
//		System.out.println(materielEnPanne);
//		panne.setMateriel(materielEnPanne);
//		panneMetierImpl.save(panne);
////		Creation de reparation
//		Reparation reparation = new Reparation();
//		reparation.setMotifReparation("Probleme au niveau de l'alimentation");
//		reparation.setUser(user);
//		reparation.setPanne(panne);
//		reparationMetierImpl.save(reparation);
////	Creation d'imprimante classe fille
//	
//		Imprimante imprimante2 = new Imprimante();
//		imprimante2.setCopie(true);
//		imprimante2.setCouleurs(true);
//		imprimante2.setFax(false);
//		imprimante2.setScanner(true);
//		imprimante2.setFormat_papier("A4 A3");
//		imprimante2.setNom_imprimante("Desert");
//		imprimante2.setSerieMateriel("002F1");
//		imprimante2.setVitesse_impression(5);
//		Marque marque = marqueMetierImpl.findOne(1);
//		imprimante2.setMarque(marque);
//		imprimanteMetierImpl.save(imprimante2);
		
//		Creation de telephone classe fille Materiel
//		Telephone telephone = new Telephone();
//		Marque marque = marqueMetierImpl.findOne(2);
//		telephone.setMarque(marque);
//		telephone.setNbCompte(4);
//		telephone.setNbHotkey(8);
//		telephone.setPoe((byte) 0);
//		telephone.setSip((byte) 1);
//		telephone.setSerieMateriel("4402TEL");
//		telephoneMetierImpl.save(telephone);
		
//		Creation classe fille Ordinateur
//		Ordinateur ordinateur = new Ordinateur();
//		ordinateur.setEspaceDisque(500);
//		Marque marque = marqueMetierImpl.findOne(3);
//		ordinateur.setMarque(marque);
//		ordinateur.setProcesseur("Intel I5 5300U");
//		ordinateur.setRam("8");
//		ordinateur.setSystemeExploitation("Windows 10 Professionel 64Bits");
//		ordinateur.setSerieMateriel("T450S");
//		ordinateurMetierImpl.save(ordinateur);
//		
//		Suppression d'un utilisateur par ID
//		userMetierImpl.deletebyId(3);
		
//		Suppression d'une conversation par ID
//		conversationMetierImpl.deletebyId(1);
		
//		Suppression d'un fichier par ID
//		fichierMetierImpl.deletebyId(1);
		
//		Suppresion par id de la classe mere materiel elle supprime les classe fille ( l'heritage c'est cool)
//		materielMetierImpl.deletebyId(10);
		
//		Suppression d'une marque par ID
//		marqueMetierImpl.deletebyId(1);
		
//		Suppression d'une Ticket par ID
//		ticketMetierImpl.deletebyId(1);
		
//		Suppression d'une Panne par ID
//		panneMetierImpl.deletebyId(1);
		
//		Suppression d'une reparation par ID
//		reparationMetierImpl.deletebyId(1);
		
//		Mise  a jour de user
//		User user = userMetierImpl.findById(1);
//		user.setEmail("h.fadil9@gmail.com");
//		user.setPassword("123456");
//		userMetierImpl.save(user);
		
//		Mise a jour de ticket
//		Ticket ticket = ticketMetierImpl.findById(1);
//		ticket.setTitreTicket("Résolu");
//		ticketMetierImpl.save(ticket);

//		Mise a jour de Telephone
//		Telephone telephone = telephoneMetierImpl.findById(1);
//		telephone.setNbCompte(4);
//		telephoneMetierImpl.save(telephone);
		
//		Meme méthode pour toute les mises a jour de toute les tables
		
		
		//Selection par clé étrangére table Ticket avec FK idUser
//		User user = userMetierImpl.findById(1);
//		System.out.println(user.toString()); // Afficher
//		Ticket test =ticketMetierImpl.findByuserId(user);
//		System.out.println(test.toString());
		
		
//		Boolean bool = ordinateurMetierImpl.exists(2);
//		System.out.println(bool);
//		Débogage materiel
//		Iterable<Materiel> test =materielMetierImpl.findAll();
//		System.out.println(test.toString());
		
//		
//		File file = new File("/home/siqaos/Documents/Polytechnique/image.jpg");
//		Ticket ticket = new Ticket();
//		ticket = ticketMetierImpl.findById(1);
//		Fichier fichier = new Fichier();
//		byte[] picInBytes = new byte[(int) file.length()];
//		FileInputStream fileInputStream = new FileInputStream(file);
//		fileInputStream.read(picInBytes);
//		fileInputStream.close();
//		fichier.setFichierJoint(picInBytes);
//		fichier.setTicket(ticket);
//		fichierMetierImpl.save(fichier);
//		
//		byte[] fichier = fichierMetierImpl.findFichier(1);
//		File dest = new File("/home/siqaos/Documents/Polytechnique/test.jpg");
//		FileOutputStream fileOutputStream = new FileOutputStream(dest);
//		byte[] imgInBytes = fichier;
//		fileOutputStream.write(imgInBytes);
//		fileOutputStream.close();

}
}
