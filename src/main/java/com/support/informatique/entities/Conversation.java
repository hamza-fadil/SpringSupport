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
@Table(name = "conversation", catalog = "support")
public class Conversation implements java.io.Serializable {

	private int idConversation;
	private Ticket ticket;
	private String contenuConversation;

	public Conversation() {
	}

	public Conversation(int idConversation, Ticket ticket) {
		this.idConversation = idConversation;
		this.ticket = ticket;
	}

	public Conversation(int idConversation, Ticket ticket, String contenuConversation) {
		this.idConversation = idConversation;
		this.ticket = ticket;
		this.contenuConversation = contenuConversation;
	}

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "id_conversation", unique = true, nullable = false)
	public int getIdConversation() {
		return this.idConversation;
	}

	public void setIdConversation(int idConversation) {
		this.idConversation = idConversation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_id_ticket", nullable = false)
	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Column(name = "contenu_conversation", length = 500)
	public String getContenuConversation() {
		return this.contenuConversation;
	}

	public void setContenuConversation(String contenuConversation) {
		this.contenuConversation = contenuConversation;
	}

}
