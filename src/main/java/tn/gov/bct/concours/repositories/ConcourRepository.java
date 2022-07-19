package tn.gov.bct.concours.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gov.bct.concours.entities.Concours;

public interface ConcourRepository extends JpaRepository<Concours, Long>{

	void deleteConcoursById(Long idConcour);

	Optional<Concours> findConcoursByTitre(String name);

}
