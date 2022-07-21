package tn.gov.bct.concours.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtResponse {

	private String token;
	private Long id;
	private String username;
	private String password;
	private String email;
	private boolean confirmed;
	private String code;
	private List<String> roles;
	private String nom;
	private String prenom;
	private String sexe;

	public JwtResponse(String accessToken, Long id, String username, String password,String nom,String prenom,String sexe, String email, boolean confirmed,
			String code, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.password=password;
		this.nom=nom;
		this.prenom=prenom;
		this.sexe=sexe;
		this.email = email;
		this.confirmed = confirmed;
		this.code = code;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
