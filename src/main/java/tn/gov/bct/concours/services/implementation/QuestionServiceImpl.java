package tn.gov.bct.concours.services.implementation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gov.bct.concours.entities.Choix;
import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.AddChoixRequest;
import tn.gov.bct.concours.models.NewQuestionRequest;
import tn.gov.bct.concours.models.RemoveChoixRequest;
import tn.gov.bct.concours.repositories.ChoixRepository;
import tn.gov.bct.concours.repositories.QuestionRepository;
import tn.gov.bct.concours.services.IQuestionService;
@Service
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	QuestionRepository questRepo;
	
	@Autowired
	ChoixRepository choixRepo;

	@Override
	public void addQuestion(NewQuestionRequest newRequest) {
		Question q= new Question();
		q.setLibelle(newRequest.getLibelle());
		q.setChoix(null);
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

	@Override
	public List<Choix> getChoixQuestion(Long id) {
		Optional<Question> c = questRepo.findById(id);
		if (c.isPresent()) {
			return c.get().getChoix();
		} else {
			return Collections.emptyList();
		}
	}
	

	@Override
	public void addChoix(AddChoixRequest req) {
	Choix c = new Choix();
	c.setLibelle(req.getLibelleRep());
	c.setScoreChoix(req.getScoreRep());
	
	Question q = questRepo.findById(req.getQuestionId()).get();
	q.addChoix(c);
	choixRepo.save(c);
	
	
		
	}

	@Override
	public void removeChoix(RemoveChoixRequest req) {
		Optional<Question> q = questRepo.findById(req.getIdQuestion());
		if (q.isPresent()) {
			for (Iterator<Choix> iterator = q.get().getChoix().iterator(); iterator.hasNext();) {
				Choix c = iterator.next();
				if (c.getId() == req.getIdChoix()) {
					iterator.remove();
				}
			}
			questRepo.save(q.get());
			choixRepo.deleteById(req.getIdChoix());
		}
		
	}
	
	

}
