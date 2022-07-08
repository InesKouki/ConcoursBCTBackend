package tn.gov.bct.concours.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gov.bct.concours.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Boolean existsByUsername(String username);

	Optional<User> findByUsername(String username);

	Boolean existsByEmail(String email);

}
