package ensa.liberarie.metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.dao.daoImp.daoImpEtatPrs;
import ensa.liberarie.entities.EtatPrs;
import ensa.liberarie.entities.Personne;

public class MetierAdherentImp implements MetierAdherent {

	private DAOImpPersonne prsDao;
	private daoImpEtatPrs etatDao;
	private String erreur;
	
	public MetierAdherentImp() {
		
			prsDao = new DAOImpPersonne();
			etatDao = new daoImpEtatPrs();

	}

	public Personne AjouterAdhrent(Personne pr)  {
		try {
			pr=prsDao.create(pr);
			EtatPrs etat = new EtatPrs(pr.getId(),"dr", new Date(), 0);
			etatDao.create(etat);

		} catch (Exception e) {
			erreur = e.getMessage();
		}
		return pr;
	}
	

	public void ModifierAdherent(Personne pr) {
		try {
			prsDao.update(pr);
		} catch (Exception e) {
			erreur = e.getMessage();
		}

	}

	public void SupprimerAdherent(Personne pr) {
		try {
			prsDao.delete(pr);
		} catch (Exception e) {
			erreur = e.getMessage();
		}

	}

	public List<Personne> TrouverAdherent(Personne pr, int type) {
		// TODO Auto-generated method stub
		List<Personne> prs = new ArrayList<Personne>();
		try {
			prs=prsDao.findBy(pr, type);
		} catch (Exception e) {
			e.printStackTrace();
			erreur = e.getMessage();
		}
		return prs;

	}
	
	


	public String getErreur() {
		return erreur;
	}


	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	
	
}
