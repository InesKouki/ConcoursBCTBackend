package tn.gov.bct.concours.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.gov.bct.concours.entities.*;

@Repository
public interface PosteRepository extends CrudRepository<Poste, Long>, JpaRepository <Poste, Long> {
	public Optional<Poste> findByNom(String name);
	public Optional<Poste> findById(Long idPoste);

}
