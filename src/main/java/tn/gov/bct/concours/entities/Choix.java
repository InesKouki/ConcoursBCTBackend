package tn.gov.bct.concours.entities;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Choix {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false , updatable=false)
	private Long id;
	@NotBlank
	private String libelle;
	private float scoreChoix;
	
	@ManyToOne
	@JsonIgnore
	private Question question;

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

	public float getScoreChoix() {
		return scoreChoix;
	}

	public void setScoreChoix(float scoreChoix) {
		this.scoreChoix = scoreChoix;
	}

	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
