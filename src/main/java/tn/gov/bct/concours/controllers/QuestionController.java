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

import tn.gov.bct.concours.entities.Choix;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.AddChoixRequest;
import tn.gov.bct.concours.models.NewQuestionRequest;
import tn.gov.bct.concours.models.RemoveChoixRequest;
import tn.gov.bct.concours.models.addPosteToConcourRequest;
import tn.gov.bct.concours.services.IQuestionService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	
	@Autowired
	IQuestionService questInt;
	
	@GetMapping("/all")
	public List<Question> getAllQuestions(){
		return questInt.findAllQuestions();
		
	}

	@PostMapping("/add")
	public void addQuestion(@RequestBody NewQuestionRequest newRequest){
		questInt.addQuestion(newRequest);

	}
	
	@PutMapping("/update")
	public void updateQuestion(@RequestBody Question question){
		 questInt.updateQuestion(question);

	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteQuestion(@PathVariable("id") Long id){
		questInt.deleteQuestion(id);

	}
	
	@PostMapping("/addChoix")
	public void ajouterChoix(@RequestBody AddChoixRequest req) {
		questInt.addChoix(req);
	}
	
	@PostMapping("/removeChoix")
	public void supprimerChoix(@RequestBody RemoveChoixRequest req) {
		questInt.removeChoix(req);
	}
	
	@GetMapping("/choix/{id}")
	public List<Choix> getPoste(@PathVariable Long id) {
		return questInt.getChoixQuestion(id);
	}
	

}
