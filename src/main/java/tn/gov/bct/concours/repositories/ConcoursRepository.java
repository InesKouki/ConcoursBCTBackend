package tn.gov.bct.concours.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.gov.bct.concours.entities.Concours;

@Repository
public interface ConcoursRepository extends CrudRepository<Concours, Long>, JpaRepository<Concours, Long>{


	Optional<Concours> findByTitre(String name);

}
