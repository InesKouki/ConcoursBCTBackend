package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;

import tn.gov.bct.concours.entities.Question;


public interface IQuestionService {
	public Question addQuestion(Question q);
	public void deleteQuestion(Long idQuestion);
	public Question updateQuestion(Question question );
	public List<Question> findAllQuestions();
	public Optional<Question> findQuestionByName(String name);
}
