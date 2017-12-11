package com.support.informatique.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "imprimante")
@PrimaryKeyJoinColumn(name = "materiel_id", referencedColumnName = "id_materiel")
public class Imprimante extends Materiel { 
	 @Column
	 private String nom_imprimante;
	 @Column
	 private Boolean couleurs;
	 @Column
	 private Boolean copie;
	 @Column
	 private Boolean fax;
	 @Column
	 private Boolean scanner;
	 @Column
	 private int vitesse_impression;
	 @Column
	 private String format_papier;
	 
	 
	public String getNom_imprimante() {
		return nom_imprimante;
	}
	public void setNom_imprimante(String nom_imprimante) {
		this.nom_imprimante = nom_imprimante;
	}
	public Boolean getCouleurs() {
		return couleurs;
	}
	public void setCouleurs(Boolean couleurs) {
		this.couleurs = couleurs;
	}
	public Boolean getCopie() {
		return copie;
	}
	public void setCopie(Boolean copie) {
		this.copie = copie;
	}
	public Boolean getFax() {
		return fax;
	}
	public void setFax(Boolean fax) {
		this.fax = fax;
	}
	public Boolean getScanner() {
		return scanner;
	}
	public void setScanner(Boolean scanner) {
		this.scanner = scanner;
	}
	public int getVitesse_impression() {
		return vitesse_impression;
	}
	public void setVitesse_impression(int vitesse_impression) {
		this.vitesse_impression = vitesse_impression;
	}
	public String getFormat_papier() {
		return format_papier;
	}
	public void setFormat_papier(String format_papier) {
		this.format_papier = format_papier;
	}
	 
}
