package ensa.liberarie.metier;

import java.util.List;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.entities.Document;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Maison_edition;
import ensa.liberarie.entities.Provenance;

public class MetierDocImp implements MetierDoc {
	private static DAO<Document> docDao;
	private int type;

	public MetierDocImp(int type) {
		super();
		type = type;
		docDao = (DAO<Document>) DAOFactory.dAOFactory(type);
	}

	public void AjouterDoc(Document doc) {
		try {
			switch (type) {
			case 0:
				if (docDao.findBy((Livre) doc, DAOImpLivre.TITRE).isEmpty()) {
					docDao.create(doc);
				} else {
					int qt = doc.getQuantité();
					doc = docDao.findBy((Livre) doc, DAOImpLivre.TITRE).get(0);
					doc.setQuantité(doc.getQuantité()+qt);
					docDao.update(doc);
				}
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Document ModifierDoc(Document doc) {
		try {
			docDao.update(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;

	}

	public void SupprimerDoc(Document doc) {
		try {
			docDao.delete(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<? extends Document> TrouverDoc(Document doc, int type) {
		List<? extends Document> liste = null;
		try {
			liste = docDao.findBy(doc, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	public static void main(String[] args) {
		MetierDocImp doc = new MetierDocImp(0);
		Provenance pr = new Provenance(1);
		// Personne p=new Personne("ilyass", "ejjaouchi", "beni mellal", true, false);
		Maison_edition m = new Maison_edition(1);
		Livre l = new Livre("ali baba", 25, 1520.00, "ahmed danouaui", pr, m);
		doc.AjouterDoc(l);
	}

}