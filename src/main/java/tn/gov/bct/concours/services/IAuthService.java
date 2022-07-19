package tn.gov.bct.concours.services;

import org.springframework.http.ResponseEntity;

import tn.gov.bct.concours.models.EditRequest;
import tn.gov.bct.concours.models.JwtResponse;
import tn.gov.bct.concours.models.LoginRequest;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.models.SignupRequest;



public interface IAuthService {
	public ResponseEntity<MessageResponse> resetPassword(String email);
	public ResponseEntity<MessageResponse> envoyerMail(String email);
	public ResponseEntity<MessageResponse> updatePassword(String pw,EditRequest editRequest);
	public ResponseEntity<MessageResponse> registerUser(SignupRequest signUpRequest);
	public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest);
}
