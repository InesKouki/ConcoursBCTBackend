package tn.gov.bct.concours.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.gov.bct.concours.models.Poste;
import tn.gov.bct.concours.repositories.PosteRepository;
import tn.gov.bct.concours.services.IPosteService;

@Controller
@RequestMapping("/poste")
public class PosteController {

	
	@Autowired
	IPosteService posteInt;
	
	@GetMapping("/all ")
	public ResponseEntity<List<Poste>> getAllPostes(){
		List<Poste>postes= posteInt.findAllPoste();
		return new ResponseEntity<>(postes, HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Poste> addPoste(@RequestBody Poste poste){
		Poste newPoste = posteInt.addPoste(poste);
		return new ResponseEntity<> (newPoste, HttpStatus.CREATED);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Poste> updatePoste(@RequestBody Poste poste){
		Poste updatedPoste = posteInt.addPoste(poste);
		return new ResponseEntity<> (updatedPoste, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePoste(@PathVariable("id") Long id){
		posteInt.deletePoste(id);
		return new ResponseEntity<> (HttpStatus.OK);

	}
}