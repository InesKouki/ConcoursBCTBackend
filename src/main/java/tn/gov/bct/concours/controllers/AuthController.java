package tn.gov.bct.concours.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gov.bct.concours.models.EditRequest;
import tn.gov.bct.concours.models.JwtResponse;
import tn.gov.bct.concours.models.LoginRequest;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.models.SignupRequest;
import tn.gov.bct.concours.services.IAuthService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	IAuthService authService;

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return authService.authenticateUser(loginRequest);
	}

	@PostMapping("/signup")
	public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		return authService.registerUser(signUpRequest);
	}
	
	@PostMapping("/resetpw")
	public ResponseEntity<MessageResponse> resetPassword(@RequestBody String email) {
		return authService.resetPassword(email);
	}
	
	@PostMapping("/sendmail")
	public ResponseEntity<MessageResponse> envoyerMail(@RequestBody String email) {
		return authService.envoyerMail(email);
	}
	
	@PutMapping("/editpw/{pw}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('RH')")
	public ResponseEntity<MessageResponse> updatePassword(@PathVariable String pw,@RequestBody EditRequest editRequest) {
		return authService.updatePassword(pw, editRequest);
	}

}
