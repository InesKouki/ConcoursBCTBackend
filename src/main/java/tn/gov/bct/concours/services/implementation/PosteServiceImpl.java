package tn.gov.bct.concours.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.gov.bct.concours.services.IPosteService;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.repositories.PosteRepository;

@Service
@RequiredArgsConstructor
public class PosteServiceImpl implements IPosteService {

	@Autowired
	PosteRepository posteRepo ;
	@Override
	public Poste addPoste(Poste p) {
		return posteRepo.save(p);
		
	}

	@Override
	public void deletePoste(Long idPoste) {
		posteRepo.deleteById(idPoste);
		
	}

	@Override
	public Poste updatePoste(Poste p) {
		return posteRepo.save(p);
	}

	@Override
	public List<Poste> findAllPoste() {
		return posteRepo.findAll();
	}

	@Override
	public Optional<Poste> findPosteByName(String name) {
		// TODO Auto-generated method stub
		return posteRepo.findByNom(name);
	}

}
