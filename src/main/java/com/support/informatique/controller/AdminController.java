package com.support.informatique.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.support.informatique.entities.User;
import com.support.informatique.service.ImprimanteService;
import com.support.informatique.service.MarqueService;
import com.support.informatique.service.MaterielService;
import com.support.informatique.service.OrdinateurService;
import com.support.informatique.service.RapportService;
import com.support.informatique.service.TachesService;
import com.support.informatique.service.TelephoneService;
import com.support.informatique.service.TicketService;
import com.support.informatique.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private TachesService tachesService;
	@Autowired
	private MaterielService materielService;
	@Autowired
	private OrdinateurService ordinateurService;
	@Autowired
	private TelephoneService telephoneService;
	@Autowired
	private ImprimanteService imprimanteService;
	@Autowired
	private RapportService rapportService;
	@Autowired
	private MarqueService marqueService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@RequestMapping("/admin/index")
	public String index(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        System.out.println(timestamp);
		return "/admin/index";
	}
	@RequestMapping(value="/admin/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/";
		}
	@RequestMapping("/admin/users")
	public String Users(ModelMap model) {
		model.addAttribute("users",userService.findAll() );
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		  }
		return "/admin/users";
	}
	@RequestMapping("/admin/ticket")
	public String Tickets(ModelMap model) {
		model.addAttribute("tickets",ticketService.findAll() );
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	  
		return "/admin/tickets";
	}
	@RequestMapping("/admin/taches")
	public String taches(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("taches", tachesService.findAll());
		return "/admin/taches";
	}
	@RequestMapping("/admin/parcs")
	public String parc(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("materiels",materielService.findAll());
		return "/admin/parcs";
	}
	@RequestMapping("/admin/ordinateurs")
	public String ordinateurs(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("ordinateurs",ordinateurService.findAll());
		return "/admin/ordinateurs";
	}
	@RequestMapping("/admin/telephones")
	public String telephones(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("telephones",telephoneService.findAll());
		return "/admin/telephones";
	}
	@RequestMapping("/admin/imprimantes")
	public String imprimantes(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());	
			model.addAttribute("imprimantes",imprimanteService.findAll());
		return "/admin/imprimantes";
	}
	@RequestMapping(value="/admin/newsletter", method = RequestMethod.GET)
	public String newsletter(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		System.out.println("ouep");
		model.addAttribute("username", userDetail.getUsername());	
		return "/admin/newsletter";
		
	}

	@RequestMapping(value="admin/newsletter", method = RequestMethod.POST)
	public String sendMail(@RequestParam("mail") String mail,@RequestParam("grpUtilisateurs") String type,@RequestParam("titre") String titre) {
		final String usernameM = "s.informatique2018@gmail.com";
		final String password = "demoniak";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usernameM, password);
					}
				  });
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("s.informatique@gmail.com"));
					List<String> users = userService.findByType(type);
					System.out.println(users);
					InternetAddress[] address = new InternetAddress[users.size()];
					for (int i = 0; i < users.size(); i++) {
					    address[i] = new InternetAddress(users.get(i));
					}
					message.addRecipients(Message.RecipientType.TO, address);
					message.setSubject(titre);
				 
					message.setText(mail);
					Transport.send(message);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return "/admin/newsletter";
	}
	
	@RequestMapping("/admin/report")
	public String report(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("rapports",rapportService.findAll());
		return "/admin/report";
	}
	@RequestMapping("/admin/marques")
	public String marque(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("marques",marqueService.findAll());
		return "admin/marques";
	}
	@RequestMapping("/admin/changemdp")
	public String changeMdp(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("user",userService.findByUsername(userDetail.getUsername()));
		return "admin/changemdp";
	}
	@RequestMapping(value="/changePassword", method = RequestMethod.POST)
	public String processConfirmationForm(ModelMap model,@RequestParam("password") String password,@RequestParam("confirmPassword") String confirmPassword,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		User user = userService.findByUsername(userDetail.getUsername());
	if(password.equals(confirmPassword)) {
		user.setPassword(passwordEncoder.encode(password));
		user.setConfirmationToken("confirmed");
		userService.save(user);
		model.addAttribute("username", userDetail.getUsername());	
		model.addAttribute("passChange","Votre mot de passe à bien été changer");
        if (request.isUserInRole("USER")) {
			  return "/user/changemdp";
			  	
		  } else if (request.isUserInRole("ADMIN"))
		  {	
			  return "/admin/changemdp"; 
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  return "/tech/changemdp"; 
		  }
		return "/403";
		}
	else {
		model.addAttribute("username", userDetail.getUsername());
		model.addAttribute("errorMessage", "Les mots de passe ne sont pas identique ");
        if (request.isUserInRole("USER")) {
			  return "/user/changemdp";
			  	
		  } else if (request.isUserInRole("ADMIN"))
		  {	
			  return "/admin/changemdp"; 
		  }
		  else if (request.isUserInRole("TECH"))
		  {
			  return "/tech/changemdp"; 
		  }
		return "/403";
		}
	}
}
