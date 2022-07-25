package tn.gov.bct.concours.models;

public class UpdateFormulaireRequest {

	private Long id;
	private String titre;
	private Long posteId;
	
	
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
	public Long getPosteId() {
		return posteId;
	}
	public void setPosteId(Long posteId) {
		this.posteId = posteId;
	}
	
}
