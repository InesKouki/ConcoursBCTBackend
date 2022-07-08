package tn.gov.bct.concours.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidature {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false , updatable=false)
	private Long id;
	private Date date;
	private float score;
	
	@ManyToOne
	private User user;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="candidatureRep")
	private List<Reponse> reponses;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public float getScore() {
		return score;
	}


	public void setScore(float score) {
		this.score = score;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Reponse> getReponses() {
		return reponses;
	}


	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}
	
	
}
