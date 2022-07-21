package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;

import tn.gov.bct.concours.entities.Poste;
import tn.gov.bct.concours.models.NewPosteRequest;

public interface IPosteService {
	public void addPoste(NewPosteRequest newRequest);
	public void deletePoste(Long idPoste);
	public Poste updatePoste(Poste p );
	public List<Poste> findAllPoste();
	public Optional<Poste> findPosteByName(String name);
}
