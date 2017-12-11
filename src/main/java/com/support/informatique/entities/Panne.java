package com.support.informatique.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "panne", catalog = "support")
public class Panne implements java.io.Serializable {

	private int idPanne;
	private Materiel materiel;
	private String descPanne;
	private String nomPanne;
	private Set<Reparation> reparations = new HashSet<Reparation>(0);

	public Panne() {
	}

	public Panne(int idPanne, Materiel materiel) {
		this.idPanne = idPanne;
		this.materiel = materiel;
	}

	public Panne(int idPanne, Materiel materiel, String descPanne, String nomPanne, Set<Reparation> reparations) {
		this.idPanne = idPanne;
		this.materiel = materiel;
		this.descPanne = descPanne;
		this.nomPanne = nomPanne;
		this.reparations = reparations;
	}

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "id_panne", unique = true, nullable = false)
	public int getIdPanne() {
		return this.idPanne;
	}

	public void setIdPanne(int idPanne) {
		this.idPanne = idPanne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materiel_id_materiel", nullable = false)
	public Materiel getMateriel() {
		return this.materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@Column(name = "desc_panne", length = 500)
	public String getDescPanne() {
		return this.descPanne;
	}

	public void setDescPanne(String descPanne) {
		this.descPanne = descPanne;
	}

	@Column(name = "nom_panne", length = 45)
	public String getNomPanne() {
		return this.nomPanne;
	}

	public void setNomPanne(String nomPanne) {
		this.nomPanne = nomPanne;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "panne")
	public Set<Reparation> getReparations() {
		return this.reparations;
	}

	public void setReparations(Set<Reparation> reparations) {
		this.reparations = reparations;
	}

}
