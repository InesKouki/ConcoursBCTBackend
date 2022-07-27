package tn.gov.bct.concours.entities;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
public class Concours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true, updatable = false)
	Long id;

	@NotBlank
	private String titre;

	@Column(nullable = true, updatable = false)
	private Date datedebut;

	@Column(nullable = true, updatable = false)
	private Date datefin;
	@NotBlank
	private String description;

	/*
	 * @ManyToOne(cascade=CascadeType.ALL) private Formulaire formulaire ;
	 */

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Poste> postes;

	public Concours() {
	}

	public Concours(String titre, Date datedebut, Date datefin, String description) {
		this.titre = titre;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addPoste(Poste p) {
		this.postes.add(p);

	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	/*
	 * public Formulaire getFormulaire() { return formulaire; }
	 * 
	 * public void setFormulaire(Formulaire formulaire) { this.formulaire =
	 * formulaire; }
	 */



	public void setId(Long id) {
		this.id = id;
	}

	public List<Poste> getPostes() {
		return postes;
	}

	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}

	@Override
	public String toString() {
		return "Concour{" +

				", titre='" + titre + '\'' + ", datedebut=" + datedebut + '\'' + ", datefin=" + datefin + '\''
				+ ", description='" + description + '\'' + '}';
	}
}
