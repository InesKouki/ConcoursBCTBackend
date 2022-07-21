package tn.gov.bct.concours.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.repositories.QuestionRepository;
import tn.gov.bct.concours.services.IQuestionService;
@Service
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	QuestionRepository questRepo;
	@Override
	public Question addQuestion(Question q) {
		return questRepo.save(q);
		
	}

	@Override
	public void deleteQuestion(Long idQuestion) {
		questRepo.deleteById(idQuestion);
		
	}

	@Override
	public Question updateQuestion(Question q) {
		return questRepo.save(q);
		
	}

	@Override
	public List<Question> findAllQuestions() {
		return questRepo.findAll();
	}

	@Override
	public Optional<Question> findQuestionByName(String name) {
		return questRepo.findByLibelle(name);

	}

}
