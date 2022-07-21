package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;

import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.NewPosteRequest;
import tn.gov.bct.concours.models.UpdatePosteRequest;

public interface IPosteService {
	public void addPoste(NewPosteRequest newRequest);
	public void deletePoste(Long idPoste);
	public void updatePoste(UpdatePosteRequest updateRequest );
	public List<Poste> findAllPoste();
	public Optional<Poste> findPosteByName(String name);
}
