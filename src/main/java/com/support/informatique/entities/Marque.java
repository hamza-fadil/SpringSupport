package com.support.informatique.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "marque", catalog = "support")
public class Marque implements java.io.Serializable {

	private int idMarque;
	private String nomMarque;
	private Set<Materiel> materiels = new HashSet<Materiel>(0);

	public Marque() {
	}

	public Marque(int idMarque) {
		this.idMarque = idMarque;
	}

	public Marque(int idMarque, String nomMarque, Set<Materiel> materiels) {
		this.idMarque = idMarque;
		this.nomMarque = nomMarque;
		this.materiels = materiels;
	}

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "id_marque", unique = true, nullable = false)
	public int getIdMarque() {
		return this.idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}

	@Column(name = "nom_marque", length = 45)
	public String getNomMarque() {
		return this.nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marque")
	public Set<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}

}
