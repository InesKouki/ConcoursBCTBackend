package tn.gov.bct.concours.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.gov.bct.concours.entities.Formulaire;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.AddQuestionsToFormulaireRequest;
import tn.gov.bct.concours.models.NewFormulaireRequest;
import tn.gov.bct.concours.models.RemoveQuestionFromFormulaireRequest;
import tn.gov.bct.concours.models.UpdateFormulaireRequest;
import tn.gov.bct.concours.entities.Poste;


import tn.gov.bct.concours.services.IFormulaireService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/formulaires")
public class FormulaireController {
	
	@Autowired
	IFormulaireService formInt;
	
	@GetMapping("/all")
	public List<Formulaire> getFormulairesList(){
		return formInt.getFormulairesList();
	}
	
	@PostMapping("/add")
	//@PreAuthorize("hasRole('ADMIN')")
	public void addFormulaire(@RequestBody NewFormulaireRequest newRequest){
		formInt.ajouterFormulaire(newRequest);
	}

	@DeleteMapping("/delete/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public void deleteFormulaire(@PathVariable("id") Long id){
		formInt.deleteFormulaire(id);
	}
	
	@PostMapping("/addQuestions")
	//@PreAuthorize("hasRole('ADMIN')")
	public void ajouterQuestionsToFormulaire(@RequestBody AddQuestionsToFormulaireRequest req) {
		formInt.addQuestionsToFormulaire(req);
	}
	
	@PostMapping("/removeQuestion")
	//@PreAuthorize("hasRole('ADMIN')")
	public void removeQuestion(@RequestBody RemoveQuestionFromFormulaireRequest req) {
		formInt.removeQuestionFromFormulaire(req);
	}
	
	@GetMapping("/questions/{id}")
	//@PreAuthorize("hasRole('ADMIN') ")
	public List<Question> getQuestion(@PathVariable Long id) {
		return formInt.getQuestionsDuFormulaire(id);
	}
	
	@PutMapping("/update")
	//@PreAuthorize("hasRole('ADMIN')")
	public void updateFormulaire(@RequestBody UpdateFormulaireRequest updateRequest){
		formInt.updateFormulaire(updateRequest);
	}

}
