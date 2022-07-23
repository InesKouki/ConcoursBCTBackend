package tn.gov.bct.concours.controllers;

import java.util.List;

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

import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.NewPosteRequest;
import tn.gov.bct.concours.models.UpdatePosteRequest;
import tn.gov.bct.concours.repositories.PosteRepository;
import tn.gov.bct.concours.services.IPosteService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/postes")
public class PosteController {

	
	@Autowired
	IPosteService posteInt;
	
	@GetMapping("/all")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('RH')")
	public List<Poste> getAllPostes(){
		return  posteInt.findAllPoste();
		
	}
	
	@PostMapping("/add")
	//@PreAuthorize("hasRole('ADMIN')")
	public void addPoste(@RequestBody NewPosteRequest newrequest){
		 posteInt.addPoste(newrequest);
	

	}
	
	@PutMapping("/update")
	//@PreAuthorize("hasRole('ADMIN')")
	public void updatePoste(@RequestBody UpdatePosteRequest updateRequest){
		posteInt.updatePoste(updateRequest);
		
	}
	
	@DeleteMapping("/delete/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public void deletePoste(@PathVariable("id") Long id){
		posteInt.deletePoste(id);
		

	}
}
