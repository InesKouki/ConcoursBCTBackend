package tn.gov.bct.concours.models;

public class addPosteToConcourRequest {
	private Long concoursId;
	private Long[] PosteIds;
	public Long getConcoursId() {
		return concoursId;
	}
	public void setConcoursId(Long concoursId) {
		this.concoursId = concoursId;
	}
	public Long[] getPosteIds() {
		return PosteIds;
	}
	public void setPosteId(Long[] posteId) {
		PosteIds = posteId;
	}

	
	
}
