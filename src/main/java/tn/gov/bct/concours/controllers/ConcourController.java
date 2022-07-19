package tn.gov.bct.concours.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.NewConcourRequest;
import tn.gov.bct.concours.models.addPosteToConcourRequest;
import tn.gov.bct.concours.services.IConcourService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/concours")
public class ConcourController {

	@Autowired
	IConcourService concourInt;
	
	@GetMapping("/all ")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('RH')")
	public List<Concours> getAllConcours(){
		return concourInt.getAllConcours();
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public void addPoste(@RequestBody NewConcourRequest newRequest){
	 concourInt.ajouterConcour(newRequest);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deletePoste(@PathVariable("id") Long id){
		concourInt.deleteConcours(id);
	}
	
	@PostMapping("/assignPoste")
	@PreAuthorize("hasRole('ADMIN')")
	public void assignPosteToConcours(@RequestBody addPosteToConcourRequest req) {
		concourInt.addPosteToConcour(req);
	}
	
	@PostMapping("/removePoste")
	@PreAuthorize("hasRole('ADMIN')")
	public void removePoste(@RequestBody addPosteToConcourRequest req) {
		concourInt.removePosteFromConcours(req);
	}
	
	@GetMapping("/postes/{id}")
	@PreAuthorize("hasRole('ADMIN') ")
	public Set<Poste> getEquipe(@PathVariable Long id) {
		return concourInt.getPosteDuConcour(id);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public void updatePoste(@RequestBody Concours concours){
		

	}
	
	
}
