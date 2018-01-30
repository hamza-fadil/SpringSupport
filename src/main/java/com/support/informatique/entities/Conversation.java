package com.support.informatique.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@SuppressWarnings("serial")
@Entity
@Table(name = "conversation", catalog = "support")
public class Conversation implements java.io.Serializable {

	private int idConversation;
	private Ticket ticket;
	private String contenuConversation;
	private User user;
	private Date createTime;
	public Conversation() {
	}

	public Conversation(int idConversation, Ticket ticket) {
		this.idConversation = idConversation;
		this.ticket = ticket;
	}

	public Conversation(int idConversation, Ticket ticket, String contenuConversation, User user,Date createTime) {
		this.idConversation = idConversation;
		this.ticket = ticket;
		this.contenuConversation = contenuConversation;
		this.createTime = createTime;
		this.user = user;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
