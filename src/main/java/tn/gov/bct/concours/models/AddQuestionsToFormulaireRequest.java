package tn.gov.bct.concours.models;

import antlr.collections.List;
import io.jsonwebtoken.lang.Arrays;

public class AddQuestionsToFormulaireRequest {

	private Long formulaireId;
	private Long[] questionsId;
	
	
	public Long getFormulaireId() {
		return formulaireId;
	}
	public void setFormulaireId(Long formulaireId) {
		this.formulaireId = formulaireId;
	}
	public Long[] getQuestionsId() {
		return questionsId;
	}
	public void setQuestionsId(Long[] questionsId) {
		this.questionsId = questionsId;
	}
	
}
