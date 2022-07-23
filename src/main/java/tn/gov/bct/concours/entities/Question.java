package tn.gov.bct.concours.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false , updatable=false)
	private Long id;
	@NotBlank
	private String libelle ;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	@JsonBackReference
	private List<Choix> choix ;


	public Question() {
		super();
	}


	public Question(Long id, @NotBlank String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}


	public Question(@NotBlank String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<Choix> getChoix() {
		return choix;
	}


	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}


	public void addChoix(Choix c) {
		this.choix.add(c);
		c.setQuestion(this);
	}
	
	
}
