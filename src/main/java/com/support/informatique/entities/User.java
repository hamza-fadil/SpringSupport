package com.support.informatique.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import static javax.persistence.GenerationType.IDENTITY;


@SuppressWarnings("serial")
@Entity
@Table(name = "user", catalog = "support")
public class User implements java.io.Serializable {

	private Integer idUser;
	private Date createTime;
	private String email;
	private String password;
	private String typeUser;
	private String username;
	@Column
	private String enabled;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);
	private Set<Taches> taches = new HashSet<Taches>(0);
	private Set<Reparation> reparations = new HashSet<Reparation>(0);
	public User() {
	}
	public User(String email, String password, String typeUser, String username,Integer idUser) {
		this.email = email;
		this.password = password;
		this.typeUser = typeUser;
		this.username = username;
		this.idUser = idUser;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public User(Date createTime, String email, String password, String typeUser, String username, Set<Ticket> tickets,
			Set<Reparation> reparations,Set<Taches> taches) {
		this.createTime = createTime;
		this.email = email;
		this.password = password;
		this.typeUser = typeUser;
		this.username = username;
		this.tickets = tickets;
		this.reparations = reparations;
		this.taches = taches;
	}
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "id_user", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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

	@Column(name = "Email", unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "type_user", length = 45, nullable = false)
	public String getTypeUser() {
		return this.typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	@Column(name = "Username", nullable = false, length = 16, unique=true)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Taches> getTaches() {
		return this.taches;
	}
	public void setTaches(Set<Taches> taches) {
		this.taches = taches;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Reparation> getReparations() {
		return this.reparations;
	}
	public void setReparations(Set<Reparation> reparations) {
		this.reparations = reparations;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", createTime=" + createTime + ", email=" + email + ", password=" + password
				+ ", typeUser=" + typeUser + ", username=" + username + "]";
	}

	}
