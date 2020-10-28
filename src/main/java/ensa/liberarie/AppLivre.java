package ensa.liberarie;

import java.util.List;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.dao.DAOLivre;
import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Maison_edition;
import ensa.liberarie.entities.Provenance;
import ensa.liberarie.metier.DAOFactory;
import ensa.liberarie.metier.MetierDoc;
import ensa.liberarie.metier.MetierDocImp;

public class AppLivre {
	
	public static void main(String[] args) {
		
		MetierDoc m = new MetierDocImp(DAOFactory.LIVRE);
		//List<Livre> ls= (List<Livre> )m.TrouverDoc(null, DAOImpLivre.LISTE);
		Livre l= new Livre("titre1", 25, 200.00, "ali baba", 30);
		m.AjouterDoc(l);
		/*for(Livre l : ls) {
			System.out.println(l);
		}	*/
	}
}
