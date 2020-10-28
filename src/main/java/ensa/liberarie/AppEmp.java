package ensa.liberarie;

import java.util.Date;

import ensa.liberarie.dao.daoImp.DAOImpCD;
import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.entities.CD;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Maison_edition;
import ensa.liberarie.entities.Personne;
import ensa.liberarie.entities.Provenance;
import ensa.liberarie.metier.DAOFactory;
import ensa.liberarie.metier.MetierAdherent;
import ensa.liberarie.metier.MetierAdherentImp;
import ensa.liberarie.metier.MetierEmpDoc;

public class AppEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MetierEmpDoc m = new MetierEmpDoc(DAOFactory.LIVRE);
		MetierAdherent a = new MetierAdherentImp();
		DAOImpLivre ld = new DAOImpLivre();
		DAOImpCD cdd = new DAOImpCD();

		Personne p= a.TrouverAdherent(new Personne(2),DAOImpPersonne.ID ).get(0);

		Livre l = new Livre();
		CD cd =new CD(72);
		try {
			l = ld.findBy(new Livre(66), DAOImpLivre.ID).get(0);
			l.setProv(new Provenance(1));
			l.setMaison_edition(new Maison_edition(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Emprunter emp = new Emprunter();
		//System.out.println(emp.getDocument().getNbr());
		//m.AjouterEmp(emp);
		emp.setId(2);
		/*for(Emprunter i : m.AfficherListeEmp()) {
			System.out.println(i);
		}*/
		for(Emprunter d :m.AfficherListeEmp()) {
			System.out.println(d);
		}
	}
}
