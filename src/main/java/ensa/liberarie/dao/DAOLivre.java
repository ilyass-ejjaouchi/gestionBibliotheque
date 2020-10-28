package ensa.liberarie.dao;


import ensa.liberarie.entities.Document;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Maison_edition;
import ensa.liberarie.entities.Provenance;

public abstract class DAOLivre extends DAO<Livre>{
	
	public abstract void AddProvance(Provenance provence , Livre livre) ;
	public abstract void AddMaisonEdition(Maison_edition maisonEdition) ;
	
	

}
