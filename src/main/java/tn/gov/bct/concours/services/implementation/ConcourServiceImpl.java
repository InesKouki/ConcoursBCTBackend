package tn.gov.bct.concours.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.repositories.ConcourRepository;
import tn.gov.bct.concours.repositories.PosteRepository;
import tn.gov.bct.concours.services.IConcourService;

@Service
public class ConcourServiceImpl implements IConcourService {

	@Autowired
	ConcourRepository concourRepo;
	@Autowired
	PosteRepository posteRepo;
	@Override
	public Concours addConcours(Concours c, Long idPoste) {
		Poste p = posteRepo.findPosteById(idPoste);
		c.addPoste(p);
		return	concourRepo.save(c);
		
	}

	@Override
	public void deleteConcours(Long idConcour) {
		concourRepo.deleteConcoursById(idConcour);
		
	}

	@Override
	public Concours updateConcours(Concours c, Long idPoste) {
		Poste p = posteRepo.findPosteById(idPoste);
		c.addPoste(p);
		return concourRepo.save(c);
		
	}

	@Override
	public List<Concours> getAllConcours() {
		return concourRepo.findAll();
	}

	@Override
	public Concours findConcoursByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}



}
