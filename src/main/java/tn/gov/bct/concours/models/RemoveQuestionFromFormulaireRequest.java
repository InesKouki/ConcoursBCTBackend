package tn.gov.bct.concours.models;

public class RemoveQuestionFromFormulaireRequest {

	private Long formulaireId;
	private Long questionId;
	public Long getFormulaireId() {
		return formulaireId;
	}
	public void setFormulaireId(Long formulaireId) {
		this.formulaireId = formulaireId;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
	
}
