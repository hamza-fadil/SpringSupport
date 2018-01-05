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
@Table(name = "Taches", catalog = "support")
public class Taches implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(unique = true, nullable = false)
	private int idTaches;
	@Column
	private String nomTaches;
	@Column
	private String descTaches;
	@Column
	private String faitTaches;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_user", nullable = false) 
	private User user;
	public Taches() {
	}
	public Taches(User user) {
		this.user = user;
	}
	public Taches(User user, String nomTaches, String descTaches, String faitTaches) {
		this.user = user;
		this.descTaches = descTaches;
		this.nomTaches = nomTaches;
		this.faitTaches = faitTaches;
	}
	public int getIdTaches() {
		return idTaches;
	}
	public void setIdTaches(int idTaches) {
		this.idTaches = idTaches;
	}
	public String getNomTaches() {
		return nomTaches;
	}
	public void setNomTaches(String nomTaches) {
		this.nomTaches = nomTaches;
	}
	public String getDescTaches() {
		return descTaches;
	}
	public void setDescTaches(String descTaches) {
		this.descTaches = descTaches;
	}
	public String getFaitTaches() {
		return faitTaches;
	}
	public void setFaitTaches(String faitTaches) {
		this.faitTaches = faitTaches;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Taches [idTaches=" + idTaches + ", nomTaches=" + nomTaches + ", descTaches=" + descTaches
				+ ", faitTaches=" + faitTaches + "]";
	}
	
}
