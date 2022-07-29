package tn.gov.bct.concours.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import tn.gov.bct.concours.entities.User;
import tn.gov.bct.concours.models.AccueilStats;
import tn.gov.bct.concours.models.ConfirmRequest;
import tn.gov.bct.concours.models.JwtResponse;
import tn.gov.bct.concours.models.MessageResponse;



public interface IUserService {
	

	public void deleteUser(Long id);
	public List<User> getAll();
	public JwtResponse confirmUser(ConfirmRequest confirmRequest);
	public ResponseEntity<MessageResponse> rendreAdmin_RH(String username);
	
}
