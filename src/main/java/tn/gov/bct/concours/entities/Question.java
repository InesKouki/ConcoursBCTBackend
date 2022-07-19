package tn.gov.bct.concours.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false , updatable=false)
	private Long id;
	@NotBlank
	private String libelle ;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	private List<Choix> choix ;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public void addChoix(Choix c) {
		this.choix.add(c);
		c.setQuestion(this);
	}
	
	
}
