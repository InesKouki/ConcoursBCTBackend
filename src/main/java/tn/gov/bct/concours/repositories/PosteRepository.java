package tn.gov.bct.concours.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.gov.bct.concours.models.*;


public interface PosteRepository extends JpaRepository <Poste, Long> {
	public Poste findPostByNom(String name);

	public void deletePosteById(Long idPoste);

}