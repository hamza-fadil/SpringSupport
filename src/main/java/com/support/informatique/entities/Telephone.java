package com.support.informatique.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@PrimaryKeyJoinColumn(name = "materiel_id", referencedColumnName = "id_materiel")
@Table(name = "telephone", catalog = "support")
public class Telephone extends Materiel { 
	@Column
	private int nbCompte;
	@Column
	private int nbHotkey;
	@Column
	private Byte poe;
	@Column
	private Byte sip;
	
	public int getNbCompte() {
		return nbCompte;
	}
	public void setNbCompte(int nbCompte) {
		this.nbCompte = nbCompte;
	}
	public int getNbHotkey() {
		return nbHotkey;
	}
	public void setNbHotkey(int nbHotkey) {
		this.nbHotkey = nbHotkey;
	}
	public Byte getPoe() {
		return poe;
	}
	public void setPoe(Byte poe) {
		this.poe = poe;
	}
	public Byte getSip() {
		return sip;
	}
	public void setSip(Byte sip) {
		this.sip = sip;
	}

}
