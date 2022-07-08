package tn.gov.bct.concours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gov.bct.concours.entities.Choix;

public interface ChoixRepository extends JpaRepository<Choix, Long> {

	Object deleteChoixById(Long idChoix);

}
