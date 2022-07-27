package tn.gov.bct.concours.models;

public class RemovePosteFromConcoursRequest {
	private Long concoursId;
	private Long posteId;
	public Long getConcoursId() {
		return concoursId;
	}
	public void setConcoursId(Long concoursId) {
		this.concoursId = concoursId;
	}
	public Long getPosteId() {
		return posteId;
	}
	public void setPosteId(Long posteId) {
		this.posteId = posteId;
	}
	
	

}
