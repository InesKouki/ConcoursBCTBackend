package tn.gov.bct.concours.services;

import java.util.List;
import java.util.Optional;

import tn.gov.bct.concours.entities.Poste;

public interface IPosteService {
	public Poste addPoste(Poste p);
	public void deletePoste(Long idPoste);
	public Poste updatePoste(Poste p );
	public List<Poste> findAllPoste();
	public Optional<Poste> findPosteByName(String name);
}
