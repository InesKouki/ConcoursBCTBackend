package tn.gov.bct.concours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gov.bct.concours.models.Concours;

public interface ConcourRepository extends JpaRepository<Concours, Long>{

	void deleteConcoursById(Long idConcour);

}
