package tn.gov.bct.concours.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.gov.bct.concours.entities.User;
import tn.gov.bct.concours.models.ConfirmRequest;
import tn.gov.bct.concours.models.JwtResponse;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.services.IUserService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("/userList")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('RH')")
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAll();
	}


	@PutMapping("/confirm")
	public ResponseEntity<JwtResponse> confirmUser(@RequestBody ConfirmRequest confirmRequest) {
		return ResponseEntity.ok(userService.confirmUser(confirmRequest));
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
	
	@PostMapping("/makeAdminRH")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MessageResponse> rendreAdminRH(@RequestBody String username) {
		return userService.rendreAdmin_RH(username);
	}
}
