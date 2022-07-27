package tn.gov.bct.concours.models;

public class addPosteToConcourRequest {
	private Long concoursId;
	private Long[] PosteId;
	public Long getConcoursId() {
		return concoursId;
	}
	public void setConcoursId(Long concoursId) {
		this.concoursId = concoursId;
	}
	public Long[] getPosteId() {
		return PosteId;
	}
	public void setPosteId(Long[] posteId) {
		PosteId = posteId;
	}
	
	
	
}
