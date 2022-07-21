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
import tn.gov.bct.concours.models.UpdateConcoursRequest;
import tn.gov.bct.concours.models.addPosteToConcourRequest;
import tn.gov.bct.concours.repositories.ConcoursRepository;
import tn.gov.bct.concours.repositories.PosteRepository;
import tn.gov.bct.concours.services.IConcourService;

@Service
public class ConcourServiceImpl implements IConcourService {

	@Autowired
	ConcoursRepository concoursRepo;
	@Autowired
	PosteRepository posteRepo;

	@Override
	public void ajouterConcour(NewConcourRequest newRequest) {
		Concours c = new Concours();

		c.setTitre(newRequest.getTitre());
		c.setDatedebut(newRequest.getDateDebut());
		c.setDatefin(newRequest.getDateFin());
		c.setDescription(newRequest.getDescription());
		c.setPostes(null);
		concoursRepo.save(c);

	}

	@Override
	public void deleteConcours(Long idConcour) {
		concoursRepo.deleteById(idConcour);

	}

	@Override
	public void updateConcours(UpdateConcoursRequest updateRequest) {
		Optional<Concours> concours = concoursRepo.findById(updateRequest.getId());
		if (concours.isPresent()) {
			concours.get().setDatedebut(updateRequest.getDateDebut());
			concours.get().setDatefin(updateRequest.getDateFin());
			concours.get().setTitre(updateRequest.getTitre());
			concours.get().setDescription(updateRequest.getDescription());
			concoursRepo.save(concours.get());
		}
	}

	@Override
	public List<Concours> getAllConcours() {
		return concoursRepo.findAll();
	}

	@Override
	public Optional<Concours> findConcoursByName(String name) {
		return concoursRepo.findByTitre(name);
	}

	@Override
	public Optional<Concours> findConcoursById(Long id) {
		return concoursRepo.findById(id);
	}

	@Override
	public void addPosteToConcour(addPosteToConcourRequest req) {
		Optional<Concours> c = concoursRepo.findById(req.getConcoursId());
		Concours concours = null;
		if (c.isPresent())
			concours = c.get();
		if (concours != null) {
			Optional<Poste> p = posteRepo.findById(req.getPosteId());
			if (p.isPresent()) {

				c.get().getPostes().add(p.get());
			}
			concoursRepo.save(concours);
		}

	}

	@Override
	public void removePosteFromConcours(addPosteToConcourRequest req) {
		Optional<Concours> c = concoursRepo.findById(req.getConcoursId());
		if (c.isPresent()) {
			for (Iterator<Poste> iterator = c.get().getPostes().iterator(); iterator.hasNext();) {
				Poste p = iterator.next();
				if (p.getId() == req.getPosteId()) {
					iterator.remove();
				}
			}
			concoursRepo.save(c.get());
		}
	}

	@Override
	public Set<Poste> getPosteDuConcour(Long id) {
		Optional<Concours> c = concoursRepo.findById(id);
		if (c.isPresent()) {
			return c.get().getPostes();
		} else {
			return Collections.emptySet();
		}
	}

}
