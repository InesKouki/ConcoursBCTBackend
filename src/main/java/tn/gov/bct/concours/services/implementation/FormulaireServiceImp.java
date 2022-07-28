package tn.gov.bct.concours.services.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Formulaire;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.AddQuestionsToFormulaireRequest;
import tn.gov.bct.concours.models.NewFormulaireRequest;
import tn.gov.bct.concours.models.RemoveQuestionFromFormulaireRequest;
import tn.gov.bct.concours.models.UpdateFormulaireRequest;
import tn.gov.bct.concours.repositories.QuestionRepository;
import tn.gov.bct.concours.repositories.FormulaireRepository;
import tn.gov.bct.concours.repositories.PosteRepository;
import tn.gov.bct.concours.services.IFormulaireService;
@Service
public class FormulaireServiceImp implements IFormulaireService{

	@Autowired
	FormulaireRepository formRepo;
	@Autowired
	PosteRepository posteRepo;
	@Autowired
	QuestionRepository questRepo;
	
	@Override
	public List<Formulaire> getFormulairesList() {
		return formRepo.findAll();
	}

	@Override
	public void deleteFormulaire(Long id) {
		formRepo.deleteById(id);
		
	}

	@Override
	public List<Question> getQuestionsDuFormulaire(Long id) {
		Optional<Formulaire> f = formRepo.findById(id);
		if (f.isPresent()) {
			return f.get().getQuestions();
		} else {
			return Collections.emptyList();
		}
	
	}

	@Override
	public void ajouterFormulaire(NewFormulaireRequest newRequest) {
		Formulaire f = new Formulaire();
		Poste p = posteRepo.findById(newRequest.getPosteId()).get();
		f.setPoste(p);
		f.setTitre(newRequest.getTitre());
		
		formRepo.save(f);
		
	}

	@Override
	public void updateFormulaire(UpdateFormulaireRequest updateRequest) {
		Optional<Formulaire> f = formRepo.findById(updateRequest.getId());
		Poste p = posteRepo.findById(updateRequest.getPosteId()).get();
		if (f.isPresent()) {
			f.get().setTitre(updateRequest.getTitre());
			f.get().setPoste(p);
			
			formRepo.save(f.get());
			
		}
		
	}

	@Override
	public void removeQuestionFromFormulaire(RemoveQuestionFromFormulaireRequest req) {
		Optional<Formulaire> f = formRepo.findById(req.getFormulaireId());
		if (f.isPresent()) {
			for (Iterator<Question> iterator = f.get().getQuestions().iterator(); iterator.hasNext();) {
				Question q = iterator.next();
				if (q.getId() == req.getQuestionId()) {
					iterator.remove();
				}
			}
			formRepo.save(f.get());
		}
	}

	@Override
	public void addQuestionsToFormulaire(AddQuestionsToFormulaireRequest req) {
		Optional<Formulaire> f = formRepo.findById(req.getFormulaireId());
		Long[] questionIds = req.getQuestionsId();
		if (f.isPresent()) {
			for (int i=0;i < questionIds.length;i++) {
				Optional<Question> q=questRepo.findById(questionIds[i]);
				if (q.isPresent()) {
					f.get().getQuestions().add(q.get());
				}
			}
			formRepo.save(f.get());
		}
	}

	@Override
	public List<Question> getQuestionsPasDuFormulaire(Long id) {
		Optional<Formulaire> f = formRepo.findById(id);
		List<Question> listQ = questRepo.findAll();
		List <Question> listQF = f.get().getQuestions();
		listQ.removeAll(listQF);
		if (Boolean.FALSE.equals(listQ.isEmpty())) {
			return listQ;
		}
		return Collections.emptyList();
		
	}

	@Override
	public Formulaire getFormulaireDuPoste(Long id) {
		Optional<Poste> p = posteRepo.findById(id);
		List<Formulaire> listF = formRepo.findAll();
		for(Formulaire f : listF) {
			if (f.getPoste().getId().equals(id))
				return f;
		}
		
		return null;

}
}
