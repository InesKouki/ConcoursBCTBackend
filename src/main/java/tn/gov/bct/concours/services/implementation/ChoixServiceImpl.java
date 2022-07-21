package tn.gov.bct.concours.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gov.bct.concours.entities.Choix;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.repositories.ChoixRepository;
import tn.gov.bct.concours.repositories.QuestionRepository;
import tn.gov.bct.concours.services.IChoixService;

@Service
public class ChoixServiceImpl implements IChoixService {

	@Autowired
	ChoixRepository choixRepo;
	
	@Autowired
	QuestionRepository questRepo;
	
	@Override
	public Choix addChoix(Choix c, Long idQuestion) {
	Optional<Question> q = questRepo.findById(idQuestion);
	if (q.isPresent()) {
		q.get().addChoix(c);
	}
	return choixRepo.save(c);

	}

	@Override
	public void deleteChoix(Long idChoix) {
		 choixRepo.deleteById(idChoix);
		
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
