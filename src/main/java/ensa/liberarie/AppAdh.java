package ensa.liberarie;

import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.entities.Document;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Personne;
import ensa.liberarie.metier.DAOFactory;
import ensa.liberarie.metier.MetierAdherentImp;
import ensa.liberarie.metier.MetierEmprunte;
import ensa.liberarie.metier.MetierEmprunterImp;

public class AppAdh {
	
	public static void main(String[] args) {
		
		
	
		MetierEmprunte m = new MetierEmprunterImp(DAOFactory.LIVRE);
		
		for(Emprunter i : m.AfficherListeEmp()) {
			System.out.println(i);
		}
	}
		
		

}

