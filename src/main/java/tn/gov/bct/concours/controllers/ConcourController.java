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

import tn.gov.bct.concours.models.Concours;
import tn.gov.bct.concours.services.IConcourService;

@Controller
@RequestMapping("/concours")
public class ConcourController {

	@Autowired
	IConcourService concourInt;
	
	@GetMapping("/all ")
	public ResponseEntity<List<Concours>> getAllConcours(){
		List<Concours>concours= concourInt.getAllConcours();
		return new ResponseEntity<>(concours, HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Concours> addPoste(@RequestBody Concours concours){
		Concours newConcour = concourInt.addConcours(concours, null);
		return new ResponseEntity<> (newConcour, HttpStatus.CREATED);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Concours> updatePoste(@RequestBody Concours concours){
		Concours updatedConcours = concourInt.updateConcours(concours, null);
		return new ResponseEntity<> (updatedConcours, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePoste(@PathVariable("id") Long id){
		concourInt.deleteConcours(id);
		return new ResponseEntity<> (HttpStatus.OK);

	}
}
