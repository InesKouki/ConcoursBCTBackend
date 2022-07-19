package tn.gov.bct.concours.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.gov.bct.concours.entities.Question;
public interface QuestionRepository extends JpaRepository <Question, Long> {

	void deleteQuestionById(Long idQuestion);

	Question findQuestionByLibelle(String name);

	Question findQuestionById(Long idQuestion);

}
