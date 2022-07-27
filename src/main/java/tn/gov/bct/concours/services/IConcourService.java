package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;


import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.models.NewConcourRequest;
import tn.gov.bct.concours.models.RemovePosteFromConcoursRequest;
import tn.gov.bct.concours.models.UpdateConcoursRequest;
import tn.gov.bct.concours.models.addPosteToConcourRequest;

public interface IConcourService {
	
	public void ajouterConcour(NewConcourRequest newRequest);
	public void deleteConcours(Long idConcour);
	public void updateConcours(UpdateConcoursRequest updateRequest);
	public List<Concours> getAllConcours();
	public Optional<Concours> findConcoursByName(String name);
	public Optional<Concours> findConcoursById(Long id);
	public List<Poste> getPosteDuConcour(Long id) ;
	public void addPosteToConcour(addPosteToConcourRequest req);
	public void removePosteFromConcours(RemovePosteFromConcoursRequest req);
	List<Poste> getPosteNonDuConcour(Long id);
	
	

}
