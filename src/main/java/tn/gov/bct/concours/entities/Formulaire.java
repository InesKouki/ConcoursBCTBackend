package tn.gov.bct.concours.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Formulaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false , updatable=false)
	private Long id;
	private String titre;
	
	/*@OneToOne(cascade=CascadeType.ALL, mappedBy="formulaire")
	private Concours concours;*/
	
	@OneToOne
	private Poste poste;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Formulaire_question", joinColumns = @JoinColumn(name = "formulaire_id"),
	inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> questions;

	
	
	public Formulaire() {
		super();
	}

	public Formulaire(String titre, Poste poste) {
		super();
		this.titre = titre;
		this.poste = poste;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
