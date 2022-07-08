package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;


import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.models.NewConcourRequest;
import tn.gov.bct.concours.models.addPosteToConcourRequest;

public interface IConcourService {
	
	public void ajouterConcour(NewConcourRequest newRequest);
	public void deleteConcours(Long idConcour);
	public Concours updateConcours(NewConcourRequest newRequest);
	public List<Concours> getAllConcours();
	public Optional<Concours> findConcoursByName(String name);
	public Optional<Concours> findConcoursById(Long id);
	public Set<Poste> getPosteDuConcour(Long id) ;
	public void addPosteToConcour(addPosteToConcourRequest req);
	public void removePosteFromConcours(addPosteToConcourRequest req);
	

}
