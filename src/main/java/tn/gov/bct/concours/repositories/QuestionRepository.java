package tn.gov.bct.concours.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.gov.bct.concours.models.Question;
public interface QuestionRepository extends JpaRepository <Question, Long> {

	void deleteQuestionById(Long idQuestion);

	Question findQuestionByName(String name);

	Question findQuestionById(Long idQuestion);

}
