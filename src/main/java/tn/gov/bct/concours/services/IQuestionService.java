package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import tn.gov.bct.concours.entities.Choix;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.AddChoixRequest;
import tn.gov.bct.concours.models.NewQuestionRequest;
import tn.gov.bct.concours.models.RemoveChoixRequest;
import tn.gov.bct.concours.models.addPosteToConcourRequest;


public interface IQuestionService {
	public void addQuestion(NewQuestionRequest newRequest);
	public void deleteQuestion(Long idQuestion);
	public void updateQuestion(Question question );
	public List<Question> findAllQuestions();
	public Optional<Question> findQuestionByName(String name);
	public List<Choix> getChoixQuestion(Long id) ;
	public void addChoix(AddChoixRequest req);
	public void removeChoix(RemoveChoixRequest req);
}
