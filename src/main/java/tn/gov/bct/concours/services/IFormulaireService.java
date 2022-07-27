package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Set;

import tn.gov.bct.concours.entities.Formulaire;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.AddQuestionsToFormulaireRequest;
import tn.gov.bct.concours.models.NewFormulaireRequest;
import tn.gov.bct.concours.models.RemoveQuestionFromFormulaireRequest;
import tn.gov.bct.concours.models.UpdateFormulaireRequest;

public interface IFormulaireService {

	List<Formulaire> getFormulairesList();
	void deleteFormulaire(Long id);
	List<Question> getQuestionsDuFormulaire(Long id);
	void ajouterFormulaire(NewFormulaireRequest newRequest);
	void updateFormulaire(UpdateFormulaireRequest updateRequest);
	void removeQuestionFromFormulaire(RemoveQuestionFromFormulaireRequest req);
	void addQuestionsToFormulaire(AddQuestionsToFormulaireRequest req);
	List<Question> getQuestionsPasDuFormulaire(Long id);

	

}
