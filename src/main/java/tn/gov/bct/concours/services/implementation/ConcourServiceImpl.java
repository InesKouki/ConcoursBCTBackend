package tn.gov.bct.concours.services.implementation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.models.NewConcourRequest;
import tn.gov.bct.concours.models.addPosteToConcourRequest;
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
	public void ajouterConcour(NewConcourRequest newRequest) {
		Concours c = new Concours();
		c.setDescription(newRequest.getDescription());
		c.settitre(newRequest.getTitre());
		c.setDatedebut(newRequest.getDatedebut());
		c.setDatefin(newRequest.getDatefin());
		c.setPostes(null);
		c.setFormulaire(null);
		concourRepo.save(c);
		
	}
	@Override
	public void deleteConcours(Long idConcour) {
		concourRepo.deleteConcoursById(idConcour);
		
	}
	@Override
	public Concours updateConcours(NewConcourRequest newRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Concours> getAllConcours() {
		return concourRepo.findAll();
	}
	@Override
	public Optional<Concours> findConcoursByName(String name) {
		return concourRepo.findConcoursByTitre(name);
	}
	@Override
	public Optional<Concours> findConcoursById(Long id) {
		return concourRepo.findById(id);
	}
	@Override
	public void addPosteToConcour(addPosteToConcourRequest req) {
		Optional<Concours> c = concourRepo.findById(req.getConcoursId());
		Concours concours = null;
		if (c.isPresent())
			concours = c.get();
		if (concours != null) {
			Optional<Poste> p = posteRepo.findById(req.getPosteId());
			if (p.isPresent()) {
			
				c.get().getPostes().add(p.get());
			}
			concourRepo.save(concours);
		}
		
	}
	@Override
	public void removePosteFromConcours(addPosteToConcourRequest req) {
		Optional<Concours> c = concourRepo.findById(req.getConcoursId());
		if (c.isPresent()) {
		for (Iterator<Poste> iterator = c.get().getPostes().iterator(); iterator.hasNext();) {
			Poste p = iterator.next();
			if (p.getId()==req.getPosteId()) {
				iterator.remove();
			}
		}
		concourRepo.save(c.get());
		}
	}
	
	@Override
	public Set<Poste> getPosteDuConcour(Long id) {
		Optional<Concours> c = concourRepo.findById(id);
		if (c.isPresent()) {
			return c.get().getPostes();
		} else {
			return Collections.emptySet();
		}
	}




}
