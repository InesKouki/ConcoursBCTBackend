package tn.gov.bct.concours.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.gov.bct.concours.entities.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>, JpaRepository<Question, Long> {

	Optional<Question> findByLibelle(String name);

	Optional<Question> findById(Long idQuestion);

}
