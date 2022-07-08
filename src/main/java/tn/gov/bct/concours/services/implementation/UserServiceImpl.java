package tn.gov.bct.concours.services.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import tn.gov.bct.concours.entities.User;
import tn.gov.bct.concours.models.ConfirmRequest;
import tn.gov.bct.concours.models.JwtResponse;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.services.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JwtResponse confirmUser(ConfirmRequest confirmRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<MessageResponse> rendreAdmin_RH(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
