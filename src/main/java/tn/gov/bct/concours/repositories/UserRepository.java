package tn.gov.bct.concours.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.gov.bct.concours.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Boolean existsByUsername(String username);

	Optional<User> findByUsername(String username);

	Boolean existsByEmail(String email);

	Optional<User> findByCode(String code);
	
	Long countByConfirmedTrue();

}
