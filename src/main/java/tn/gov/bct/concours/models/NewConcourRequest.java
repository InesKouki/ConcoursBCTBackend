package tn.gov.bct.concours.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class NewConcourRequest {
	private String titre;

	private Date dateDebut;

	private Date dateFin;

	private String description;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
