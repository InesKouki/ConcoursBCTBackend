package tn.gov.bct.concours.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.NewQuestionRequest;
import tn.gov.bct.concours.repositories.QuestionRepository;
import tn.gov.bct.concours.services.IQuestionService;
@Service
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	QuestionRepository questRepo;

	@Override
	public void addQuestion(NewQuestionRequest newRequest) {
		Question q= new Question();
		q.setLibelle(newRequest.getLibelle());
		questRepo.save(q);
		
	}

	@Override
	public void deleteQuestion(Long idQuestion) {
		questRepo.deleteById(idQuestion);
		
	}

	@Override
	public void updateQuestion(Question question) {
		Optional<Question> q = questRepo.findById(question.getId());
		if (q.isPresent()) {
			q.get().setLibelle(question.getLibelle());
			questRepo.save(q.get());
		}
		
	}

	@Override
	public List<Question> findAllQuestions() {
		return questRepo.findAll();
	}

	@Override
	public Optional<Question> findQuestionByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	

}
