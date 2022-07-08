package tn.gov.bct.concours.services.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;


//import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.gov.bct.concours.entities.ERole;
import tn.gov.bct.concours.entities.Role;
import tn.gov.bct.concours.entities.User;
import tn.gov.bct.concours.models.EditRequest;
import tn.gov.bct.concours.models.JwtResponse;
import tn.gov.bct.concours.models.LoginRequest;
import tn.gov.bct.concours.models.MessageResponse;
import tn.gov.bct.concours.models.MyConstants;
import tn.gov.bct.concours.models.SignupRequest;
import tn.gov.bct.concours.repositories.RoleRepository;
import tn.gov.bct.concours.repositories.UserRepository;
import tn.gov.bct.concours.security.jwt.JwtUtils;
import tn.gov.bct.concours.security.services.UserDetailsImpl;
import tn.gov.bct.concours.services.IAuthService;
@Service
public class AuthServiceImpl implements IAuthService{
	
	private static final Logger LOG = LogManager.getLogger(AuthServiceImpl.class);
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;


	@Override
	public ResponseEntity<MessageResponse> resetPassword(String email) {
		// Generate new password
				String code = generateCode(MyConstants.CODE_TYPE_RESET);
				Optional<User> u = userRepository.findByEmail(email);
				if (u.isPresent()) {
				// Send new password to email
				/*try {
					LOG.info(MyConstants.SENDING_MAIL);
					sendPassword(email, code);
					LOG.info(MyConstants.MAIL_SENT);
				} catch (MessagingException e) {
					e.printStackTrace();
					return ResponseEntity.badRequest().body(new MessageResponse(MyConstants.FAIL_TO_SEND_MAIL));
				}*/

				// update the user's password
					u.get().setPassword(encoder.encode(code));
					userRepository.save(u.get());
					return ResponseEntity.ok(new MessageResponse(MyConstants.PASSWORD_RESET_SUCCESS));
				}
				return ResponseEntity.badRequest().body(new MessageResponse(MyConstants.EMAIL_DOESNT_EXIST));
	}

	@Override
	public ResponseEntity<MessageResponse> envoyerMail(String email) {
		Optional<User> u = userRepository.findByEmail(email);

		/*if (u.isPresent()) {
			// Send confirmation code to email
			try {
				LOG.info(MyConstants.SENDING_MAIL);
				sendEmail(email, u.get().getCode());
				LOG.info(MyConstants.MAIL_SENT);
			} catch (MessagingException e) {
				e.printStackTrace();
				return ResponseEntity.badRequest().body(new MessageResponse(MyConstants.FAIL_TO_SEND_MAIL));
			}
		}*/

		return ResponseEntity
				.ok(new MessageResponse(MyConstants.CODE_SEND_SUCCESS));

	}

	@Override
	public ResponseEntity<MessageResponse> updatePassword(String pw, EditRequest editRequest) {
		BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
		Optional<User> u = userRepository.findById(editRequest.getId());
		if (u.isPresent() && encoder2.matches(editRequest.getPassword(), u.get().getPassword())) {
			u.get().setPassword(encoder.encode(pw));
			userRepository.save(u.get());
			return ResponseEntity.ok(new MessageResponse("Password edited successfully !"));
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Erreur"));
	}

	
	@Override
	public ResponseEntity<MessageResponse> registerUser(SignupRequest signUpRequest) {
		if (Boolean.TRUE.equals(userRepository.existsByUsername(signUpRequest.getUsername()))) {
			return ResponseEntity.badRequest().body(new MessageResponse(MyConstants.USERNAME_ALREADY_IN_USE));
		}

		if (Boolean.TRUE.equals(userRepository.existsByEmail(signUpRequest.getEmail()))) {
			return ResponseEntity.badRequest().body(new MessageResponse(MyConstants.EMAIL_ALREADY_IN_USE));
		}

		// Generate confirmation code
		String code = generateCode(MyConstants.CODE_TYPE_CONFIRM);



		// Create new user's account
		User user = new User(signUpRequest.getNom(),signUpRequest.getPrenom(),signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()), signUpRequest.getUsername(), 
				 false,signUpRequest.getDateNaissance(),signUpRequest.getSexe(),code);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException(MyConstants.ROLE_NOT_FOUND));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "RH":
					Role adminRole = roleRepository.findByName(ERole.ROLE_RH)
							.orElseThrow(() -> new RuntimeException(MyConstants.ROLE_NOT_FOUND));
					roles.add(adminRole);

					break;
				case "Admin":
					Role superAdminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException(MyConstants.ROLE_NOT_FOUND));
					roles.add(superAdminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException(MyConstants.ROLE_NOT_FOUND));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		
		/*// Send code to email
		try {
			LOG.info(MyConstants.SENDING_MAIL);
			sendEmail(signUpRequest.getEmail(), code);
			LOG.info(MyConstants.MAIL_SENT);
		} catch (MessagingException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new MessageResponse(MyConstants.FAIL_TO_SEND_MAIL));
		}*/

		return ResponseEntity.ok(new MessageResponse("User registered successfully !"));
	}
	
	

	@Override
	public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity
				.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),loginRequest.getPassword(),userDetails.getNom(),userDetails.getPrenom(),userDetails.getSexe(),
						userDetails.getEmail(), userDetails.isConfirmed(), userDetails.getCode(), roles));
	}

	
	public String generateCode(String type) {
		// create a string of uppercase and lowercase characters and numbers
		String upperAlphabet = MyConstants.ALPHABET;
		String numbers = MyConstants.NUMBERS;

		String alphaNumeric = upperAlphabet + numbers;

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 0;
		if (type.equals(MyConstants.CODE_TYPE_CONFIRM)) {
			length = 6;
		} else if (type.equals(MyConstants.CODE_TYPE_RESET)) {
			length = 12;
		}

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphaNumeric.length());

			// get character specified by index from the string
			char randomChar = alphaNumeric.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

		return sb.toString();
	}
}
