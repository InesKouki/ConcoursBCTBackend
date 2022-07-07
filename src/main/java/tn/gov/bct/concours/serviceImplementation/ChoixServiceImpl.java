package tn.gov.bct.concours.serviceImplementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import tn.gov.bct.concours.models.Choix;
import tn.gov.bct.concours.models.Question;

import tn.gov.bct.concours.repositories.ChoixRepository;
import tn.gov.bct.concours.repositories.QuestionRepository;
import tn.gov.bct.concours.services.IChoixService;

public class ChoixServiceImpl implements IChoixService {

	@Autowired
	ChoixRepository choixRepo;
	
	@Autowired
	QuestionRepository questRepo;
	@Override
	public Choix addChoix(Choix c, Long idQuestion) {
	Question q = questRepo.findQuestionById(idQuestion);
	q.addChoix(c);
	return choixRepo.save(c);
		
	}

	@Override
	public void deleteChoix(Long idChoix) {
		 choixRepo.deleteChoixById(idChoix);
		
	}

	@Override
	public Choix updateChoix(Choix choix) {
		return choixRepo.save(choix);
		
	}

	@Override
	public List<Choix> getAllChoix() {
		return choixRepo.findAll();
	}

	@Override
	public Choix findChoixByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}