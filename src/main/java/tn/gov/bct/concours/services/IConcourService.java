package tn.gov.bct.concours.services;

import java.util.List;

import tn.gov.bct.concours.models.Concours;

public interface IConcourService {
	
	public void addConcours(Concours c, Long idPost);
	public void deleteConcours(Long idConcour);
	public void updateConcours(Concours c,Long idConcour);
	public List<Concours> getAllConcours();
	public Concours findConcoursByName(String name);

}
