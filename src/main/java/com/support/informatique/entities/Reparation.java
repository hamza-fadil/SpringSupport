package com.support.informatique.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@SuppressWarnings("serial")
@Entity
@Table(name = "reparation", catalog = "support")
public class Reparation implements java.io.Serializable {

	private int idReparation;
	private Panne panne;
	private User user;
	private Date dateReparation;
	private String motifReparation;

	public Reparation() {
	}

	public Reparation(int idReparation, Panne panne, User user) {
		this.idReparation = idReparation;
		this.panne = panne;
		this.user = user;
	}

	public Reparation(int idReparation, Panne panne, User user, Date dateReparation, String motifReparation) {
		this.idReparation = idReparation;
		this.panne = panne;
		this.user = user;
		this.dateReparation = dateReparation;
		this.motifReparation = motifReparation;
	}

	@Id

	@Column(name = "id_reparation", unique = true, nullable = false)
	public int getIdReparation() {
		return this.idReparation;
	}

	public void setIdReparation(int idReparation) {
		this.idReparation = idReparation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "panne_id_panne", nullable = false)
	public Panne getPanne() {
		return this.panne;
	}

	public void setPanne(Panne panne) {
		this.panne = panne;
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
	@Temporal(TemporalType.DATE)
	@Column(name = "date_reparation", length = 10)
	public Date getDateReparation() {
		return this.dateReparation;
	}

	public void setDateReparation(Date dateReparation) {
		this.dateReparation = dateReparation;
	}

	@Column(name = "motif_reparation", length = 45)
	public String getMotifReparation() {
		return this.motifReparation;
	}

	public void setMotifReparation(String motifReparation) {
		this.motifReparation = motifReparation;
	}

}
