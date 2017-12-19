package com.support.informatique.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Ordinateur")
@PrimaryKeyJoinColumn(name = "idMateriel")
public class Ordinateur extends Materiel {
	@Column(name = "processeur")
	private String processeur;
	@Column(name = "ram")
	private String ram;
	@Column(name = "espaceDisque")
	private int espaceDisque;
	@Column(name = "systemeExploitation")
	private String systemeExploitation;
	
	public String getProcesseur() {
		return processeur;
	}
	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public int getEspaceDisque() {
		return espaceDisque;
	}
	public void setEspaceDisque(int espaceDisque) {
		this.espaceDisque = espaceDisque;
	}
	public String getSystemeExploitation() {
		return systemeExploitation;
	}
	public void setSystemeExploitation(String systemeExploitation) {
		this.systemeExploitation = systemeExploitation;
	}
	@Override
	public String toString() {
		return "Ordinateur [processeur=" + processeur + ", ram=" + ram + ", espaceDisque=" + espaceDisque
				+ ", systemeExploitation=" + systemeExploitation + "]";
	}
	
}
