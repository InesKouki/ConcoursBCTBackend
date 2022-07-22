package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;

import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.NewQuestionRequest;


public interface IQuestionService {
	public void addQuestion(NewQuestionRequest newRequest);
	public void deleteQuestion(Long idQuestion);
	public void updateQuestion(Question question );
	public List<Question> findAllQuestions();
	public Optional<Question> findQuestionByName(String name);
}
