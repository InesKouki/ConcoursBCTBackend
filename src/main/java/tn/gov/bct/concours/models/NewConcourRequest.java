package tn.gov.bct.concours.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class NewConcourRequest {
	 @NotBlank
	    private String titre;

	    @Column(nullable = true,updatable = false)
	    private Date datedebut;
	    
	    
	    @Column(nullable = true,updatable = false)
	    private Date datefin;
	    
	    @NotBlank
	    private  String description;
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
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
	    
	    

}
