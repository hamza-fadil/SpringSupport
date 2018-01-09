package com.support.informatique.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Rapport", catalog = "support")
public class Rapport implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(unique = true, nullable = false)
	private int idRapport;
	@Column
	private String nomRapport;
	@Column
	private String descRapport;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_id_ticket", nullable = false) 
	private Ticket ticket;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_user", nullable = false) 
	private User user;
	public Rapport() {
	}
	public Rapport(Ticket ticket) {
		this.ticket = ticket;
	}
	public Rapport(Ticket ticket, String nomRapport, String descRapport) {
		this.ticket = ticket;
		this.nomRapport = nomRapport;
		this.descRapport = descRapport;
	}
	public int getIdRapport() {
		return idRapport;
	}
	public void setIdRapport(int idRapport) {
		this.idRapport = idRapport;
	}
	public String getNomRapport() {
		return nomRapport;
	}
	public void setNomRapport(String nomRapport) {
		this.nomRapport = nomRapport;
	}
	public String getDescRapport() {
		return descRapport;
	}
	public void setDescRapport(String descRapport) {
		this.descRapport = descRapport;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
