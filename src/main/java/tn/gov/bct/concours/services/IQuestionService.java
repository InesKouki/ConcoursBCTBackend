package tn.gov.bct.concours.services;

import java.util.List;

import tn.gov.bct.concours.models.Question;


public interface IQuestionService {
	public Question addQuestion(Question q);
	public void deleteQuestion(Long idQuestion);
	public Question updateQuestion(Question question );
	public List<Question> findAllQuestions();
	public Question findQuestionByName(String name);
}
