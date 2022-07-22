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

import tn.gov.bct.concours.entities.Question;
import tn.gov.bct.concours.models.NewQuestionRequest;
import tn.gov.bct.concours.services.IQuestionService;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/questions")
public class QuestionController {
	
	@Autowired
	IQuestionService questInt;
	
	@GetMapping("/all")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('RH')")
	public List<Question> getAllQuestions(){
		return questInt.findAllQuestions();
		
	}
	
	
	@PostMapping("/add")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('RH')")
	public void addQuestion(@RequestBody NewQuestionRequest newRequest){
		questInt.addQuestion(newRequest);

	}
	
	@PutMapping("/update")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('RH')")
	public void updateQuestion(@RequestBody Question question){
		 questInt.updateQuestion(question);

	}
	
	@DeleteMapping("/delete/{id}")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('RH')")
	public void deleteQuestion(@PathVariable("id") Long id){
		questInt.deleteQuestion(id);

	}
	

}
