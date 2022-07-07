package tn.gov.bct.concours.services;

import java.util.List;

import tn.gov.bct.concours.models.Choix;

public interface IChoixService {
	public Choix addChoix(Choix c,Long idQuestion);
	public void deleteChoix(Long idReponse);
	public Choix updateChoix(Choix choix );
	public List<Choix> getAllChoix();
	public Choix findChoixByName(String name);
}
