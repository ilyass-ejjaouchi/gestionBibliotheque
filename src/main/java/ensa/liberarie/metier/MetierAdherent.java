package ensa.liberarie.metier;
import java.util.List;

import ensa.liberarie.entities.Amende;
import ensa.liberarie.entities.Personne;

public interface MetierAdherent {
	
	public Personne AjouterAdhrent(Personne prs);
	public void ModifierAdherent(Personne prs);
	public void SupprimerAdherent(Personne prs);
	public List<Personne> TrouverAdherent(Personne prs,int type);

	
}
