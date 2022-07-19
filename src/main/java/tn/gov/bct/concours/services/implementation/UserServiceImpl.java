package tn.gov.bct.concours.services.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tn.gov.bct.concours.entities.ERole;
import tn.gov.bct.concours.entities.Role;
import tn.gov.bct.concours.entities.User;
import tn.gov.bct.concours.models.ConfirmRequest;
import tn.gov.bct.concours.models.JwtResponse;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.models.MyConstants;
import tn.gov.bct.concours.repositories.RoleRepository;
import tn.gov.bct.concours.repositories.UserRepository;
import tn.gov.bct.concours.security.jwt.JwtUtils;
import tn.gov.bct.concours.security.services.UserDetailsImpl;
import tn.gov.bct.concours.services.IUserService;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepo;
	
	
	
	
	@Override
	public void deleteUser(Long id) {
		Optional<User> u = userRepo.findById(id);
		if (u.isPresent()) {
			userRepo.deleteById(id);
		}
		
	}

	@Override
	public List<User> getAll() {
		List<User> listOfUsers = userRepo.findAll();
		if (Boolean.FALSE.equals(userRepo.findAll().isEmpty())) {
			Optional<User> u= userRepo.findByUsername(MyConstants.ADMIN_USERNAME);
			if (u.isPresent()) {
				listOfUsers.remove(u.get());
			}
			return listOfUsers;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public JwtResponse confirmUser(ConfirmRequest confirmRequest) {
		Optional<User> u = userRepo.findByCode(confirmRequest.getCode());
		if (u.isPresent() && (u.get().getId().equals(confirmRequest.getId()))) {
			u.get().setConfirmed(true);
			userRepo.save(u.get());
		}

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(confirmRequest.getUsername(), confirmRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),userDetails.getPassword(),userDetails.getNom(),userDetails.getPrenom(),userDetails.getSexe(),
				userDetails.getEmail(), userDetails.isConfirmed(), userDetails.getCode(), roles);
	}

	@Override
	public ResponseEntity<MessageResponse> rendreAdmin_RH(String username) {
		try {
			Optional<User> user= userRepo.findByUsername(username);
			if (user.isPresent()) {
				user.get().getRoles().clear();
				Role rhRole = roleRepository.findByName(ERole.ROLE_RH)
						.orElseThrow(() -> new RuntimeException(MyConstants.ROLE_NOT_FOUND));
				user.get().getRoles().add(rhRole);
				userRepo.save(user.get());
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new MessageResponse(MyConstants.FAIL_USER_TO_RH));
		}

		return ResponseEntity.ok(new MessageResponse(MyConstants.SUCCESS_USER_TO_RH));
	}

}
