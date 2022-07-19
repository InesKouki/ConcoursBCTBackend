package tn.gov.bct.concours.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import tn.gov.bct.concours.entities.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;
	private String nom;
	private String prenom;
	private String sexe;
	
	private String email;

	private boolean confirmed;

	private String code;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

<<<<<<< HEAD
	public UserDetailsImpl(Long id,String nom,String prenom, String email, String password,String username,String sexe,String code,boolean confirmed,
=======
	public UserDetailsImpl(Long id,String nom,String prenom, String email, String password,String username,String sexe,
>>>>>>> ea27f1e0d72dd7ce90cb02decc5d17551211d11a
			Collection<? extends GrantedAuthority> authorities) {
		this.nom=nom;
		this.prenom=prenom;
		this.id = id;
		this.email = email;
		this.username=username;
		this.password = password;
		this.authorities = authorities;
		this.confirmed=confirmed;
		this.code=code;
		this.sexe=sexe;
		
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getNom(),
				user.getPrenom(),
				user.getEmail(),
				user.getPassword(), 
				user.getUsername(),
				user.getSexe(),
<<<<<<< HEAD
				user.getCode(),
				user.isConfirmed(),
=======
>>>>>>> ea27f1e0d72dd7ce90cb02decc5d17551211d11a
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
