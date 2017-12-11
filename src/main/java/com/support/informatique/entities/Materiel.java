package com.support.informatique.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "materiel", catalog = "support")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Materiel implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "id_materiel", unique = true, nullable = false)
	private int idMateriel;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marque_id_marque", nullable = false)
	private Marque marque;
	@Column(name = "reparation_id_reparation", nullable = false)
	private int reparationIdReparation;
	@Column(name = "serie_materiel", length = 45)
	private String serieMateriel;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
	private Set<Panne> pannes = new HashSet<Panne>(0);

	public Materiel() {
		super();
	}

	public Materiel(int idMateriel, Marque marque, int reparationIdReparation, String serieMateriel, Set<Panne> pannes){

		this.idMateriel = idMateriel;
		this.marque = marque;
		this.reparationIdReparation = reparationIdReparation;
		this.serieMateriel = serieMateriel;
		this.pannes = pannes;
	}

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public int getReparationIdReparation() {
		return reparationIdReparation;
	}

	public void setReparationIdReparation(int reparationIdReparation) {
		this.reparationIdReparation = reparationIdReparation;
	}

	public String getSerieMateriel() {
		return serieMateriel;
	}

	public void setSerieMateriel(String serieMateriel) {
		this.serieMateriel = serieMateriel;
	}

	public Set<Panne> getPannes() {
		return pannes;
	}

	public void setPannes(Set<Panne> pannes) {
		this.pannes = pannes;
	}

	

}
