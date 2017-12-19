package com.support.informatique.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "fichier", catalog = "support")
public class Fichier implements java.io.Serializable {

	private Integer idFichier;
	private Ticket ticket;
	private byte[] fichierJoint;

	public Fichier() {
	}

	public Fichier(Ticket ticket) {
		this.ticket = ticket;
	}

	public Fichier(Ticket ticket, byte[] fichierJoint) {
		this.ticket = ticket;
		this.fichierJoint = fichierJoint;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_fichier", unique = true, nullable = false)
	public Integer getIdFichier() {
		return this.idFichier;
	}

	public void setIdFichier(Integer idFichier) {
		this.idFichier = idFichier;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_id_ticket", nullable = false)
	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Column(name = "fichier_joint",columnDefinition="blob")
	@Lob
	public byte[] getFichierJoint() {
		return this.fichierJoint;
	}

	public void setFichierJoint(byte[] fichierJoint) {
		this.fichierJoint = fichierJoint;
	}

}
