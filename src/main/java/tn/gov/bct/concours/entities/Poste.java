package tn.gov.bct.concours.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poste {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String nom;
	private String description;
	private Integer nbr_place;

	public Poste(String nom, String description, Integer nbr_place) {
		super();
		this.nom = nom;
		this.description = description;
		this.nbr_place = nbr_place;
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

	public Integer getNbr_place() {
		return nbr_place;
	}

	public void setNbr_place(Integer nbr_place) {
		this.nbr_place = nbr_place;
	}

}
