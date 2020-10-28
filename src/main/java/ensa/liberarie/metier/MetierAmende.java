package ensa.liberarie.metier;

import java.util.List;

import ensa.liberarie.entities.Amende;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.Personne;

public interface MetierAmende {

	public boolean AddAmende(Emprunter emp);

	public void SituationRegler(Amende amd);

	public List<Amende> ListeAmd(Amende amd , int type);

}
