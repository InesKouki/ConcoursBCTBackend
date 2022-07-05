package tn.gov.bct.concours.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Formulaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false , updatable=false)
	private Long id;
	private String titre;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="formulaire")
	private Concours concours;
	
	@OneToOne
	private Poste poste;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Formulaire_question", joinColumns = @JoinColumn(name = "formulaire_id"),
	inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> questions;
}
