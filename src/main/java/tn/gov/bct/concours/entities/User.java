package tn.gov.bct.concours.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
		 @UniqueConstraint(columnNames = "username")}
)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	Long id;
	
	@NotBlank
	String nom;
	
	@NotBlank
	String prenom;
	
	@NotBlank
	String email;
	
	@NotBlank
	@JsonIgnore
	String password;
	

	String cin;

	@NotBlank
	String username;
	@Lob
	@Column(name = "CV", length = Integer.MAX_VALUE, nullable = true)
	byte[] cv;

	private boolean confirmed;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Candidature> candidatures;

	private Date dateNaissance;

	private String code;
	@NotBlank
	String sexe;

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	
	public User() {
		super();
	}

	public User(@NotBlank String nom, @NotBlank String prenom, @NotBlank String email, @NotBlank String password,
			@NotBlank String username, boolean confirmed, Date dateNaissance, @NotBlank String sexe,String code) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.username = username;
		this.confirmed = confirmed;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.code = code;
	}

	public User(@NotBlank String nom, @NotBlank String prenom, @NotBlank String email, @NotBlank String password,
			@NotBlank String username, boolean confirmed, @NotBlank String sexe,String code) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.username = username;
		this.confirmed = confirmed;
		this.sexe = sexe;
		this.code = code;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public byte[] getCv() {
		return cv;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}

	public Set<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
