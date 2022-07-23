package tn.gov.bct.concours.models;

public class AddChoixRequest {

	private Long questionId;
	private String libelleRep;
	private int scoreRep;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getLibelleRep() {
		return libelleRep;
	}
	public void setLibelleRep(String libelleRep) {
		this.libelleRep = libelleRep;
	}
	public int getScoreRep() {
		return scoreRep;
	}
	public void setScoreRep(int scoreRep) {
		this.scoreRep = scoreRep;
	}
	
	
}
