package com.support.informatique.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ticket", catalog = "support")
public class Ticket implements java.io.Serializable {

	private Integer idTicket;
	private User user;
	private String contTicket;
	private String titreTicket;
	private String typeTicket;
	private Set<Fichier> fichiers = new HashSet<Fichier>(0);
	private Set<Conversation> conversations = new HashSet<Conversation>(0);

	public Ticket() {
	}

	public Ticket(User user) {
		this.user = user;
	}

	public Ticket(User user, String contTicket, String titreTicket, String typeTicket, Set<Fichier> fichiers,
			Set<Conversation> conversations) {
		this.user = user;
		this.contTicket = contTicket;
		this.titreTicket = titreTicket;
		this.typeTicket = typeTicket;
		this.fichiers = fichiers;
		this.conversations = conversations;
	}



	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", contTicket=" + contTicket + ", titreTicket=" + titreTicket
				+ ", typeTicket=" + typeTicket + "]";
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ticket", unique = true, nullable = false)
	public Integer getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "cont_ticket", length = 45)
	public String getContTicket() {
		return this.contTicket;
	}

	public void setContTicket(String contTicket) {
		this.contTicket = contTicket;
	}

	@Column(name = "titre_ticket", length = 45)
	public String getTitreTicket() {
		return this.titreTicket;
	}

	public void setTitreTicket(String titreTicket) {
		this.titreTicket = titreTicket;
	}

	@Column(name = "type_ticket", length = 1)
	public String getTypeTicket() {
		return this.typeTicket;
	}

	public void setTypeTicket(String typeTicket) {
		this.typeTicket = typeTicket;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
	public Set<Fichier> getFichiers() {
		return this.fichiers;
	}

	public void setFichiers(Set<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}


	

}
