package tn.gov.bct.concours.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Poste {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false , updatable=false)
	private Long id;
	@NotBlank
	private String nom;
	@NotBlank
	private String description ;
	private int nombrePlace;
	
	
	
	public Poste() {
		super();
	}
	
	
	public Poste(@NotBlank String nom, @NotBlank String description, int nombrePlace) {
		super();
		this.nom = nom;
		this.description = description;
		this.nombrePlace = nombrePlace;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	
	
	
}
