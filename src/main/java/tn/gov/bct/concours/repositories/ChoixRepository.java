package tn.gov.bct.concours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.gov.bct.concours.entities.Choix;

@Repository
public interface ChoixRepository extends CrudRepository<Choix, Long>, JpaRepository<Choix, Long> {

}
