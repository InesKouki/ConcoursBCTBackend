package tn.gov.bct.concours.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.gov.bct.concours.services.IPosteService;
import tn.gov.bct.concours.models.UpdatePosteRequest;
import tn.gov.bct.concours.entities.Concours;
import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.NewPosteRequest;
import tn.gov.bct.concours.repositories.PosteRepository;

@Service
@RequiredArgsConstructor
public class PosteServiceImpl implements IPosteService {

	@Autowired
	PosteRepository posteRepo ;

	@Override
	public void deletePoste(Long idPoste) {
		posteRepo.deleteById(idPoste);
		
	}
	
	@Override
	public List<Poste> findAllPoste() {
		return posteRepo.findAll();
	}

	@Override
	public Optional<Poste> findPosteByName(String name) {
		return posteRepo.findByNom(name);
	}

	@Override
	public void addPoste(NewPosteRequest newRequest) {
		Poste p = new Poste();

		p.setNom(newRequest.getNom());
		p.setDescription(newRequest.getDescription());
		p.setNombrePlace(newRequest.getNombrePlace());
		 posteRepo.save(p);
	}


	@Override
	public void updatePoste(UpdatePosteRequest updateRequest) {
		Optional<Poste> poste = posteRepo.findById(updateRequest.getId());
		if (poste.isPresent()) {
			poste.get().setNom(updateRequest.getNom());
			poste.get().setDescription(updateRequest.getDescription());
			poste.get().setNombrePlace(updateRequest.getNombrePlace());
			posteRepo.save(poste.get());
		}
	}

}
