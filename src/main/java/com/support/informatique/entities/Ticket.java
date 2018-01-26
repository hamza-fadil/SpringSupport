package com.support.informatique.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@SuppressWarnings("serial")
@Entity
@Table(name = "ticket", catalog = "support")
public class Ticket implements java.io.Serializable {

	private Integer idTicket;
	private User user;
	private String contTicket;
	private String titreTicket;
	private String typeTicket;
	@Column
	private String etatTicket;
	private List<Fichier> fichiers = new ArrayList<Fichier>();
	private Set<Conversation> conversations = new HashSet<Conversation>(0);
	private Set<Rapport> rapport = new HashSet<Rapport>(0);
	private Date createTime;

	public Ticket() {
	}

	public Ticket(User user) {
		this.user = user;
	}

	public Ticket(User user, String contTicket, String titreTicket, String typeTicket, List<Fichier> fichiers,
			Set<Conversation> conversations,Set<Rapport> rapport,Date createTime) {
		this.user = user;
		this.contTicket = contTicket;
		this.titreTicket = titreTicket;
		this.typeTicket = typeTicket;
		this.fichiers = fichiers;
		this.conversations = conversations;
		this.rapport = rapport;
		this.createTime = createTime;
	}





	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", contTicket=" + contTicket + ", titreTicket=" + titreTicket
				+ ", typeTicket=" + typeTicket + ", etatTicket=" + etatTicket + "]";
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
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "contTicket",columnDefinition="TEXT")
	@Lob
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
	public List<Fichier> getFichiers() {
		return this.fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
	public Set<Rapport> getRapport() {
		return this.rapport;
	}
	public void setRapport(Set<Rapport> rapport) {
		this.rapport = rapport;
	}

	public String getEtatTicket() {
		return etatTicket;
	}

	public void setEtatTicket(String etatTicket) {
		this.etatTicket = etatTicket;
	}
	

}
