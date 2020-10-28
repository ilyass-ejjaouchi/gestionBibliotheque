package ensa.liberarie.metier;

import java.util.Date;
import java.util.List;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.dao.daoImp.DAOImpAmende;
import ensa.liberarie.dao.daoImp.DAOImpEmprunter;
import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.entities.Amende;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.Personne;

public class MetierAmendeImp implements MetierAmende {

	private static DAO<Personne> prsDao = new DAOImpPersonne();
	private static DAO<Amende> amdDao = new DAOImpAmende();

	public boolean AddAmende(Emprunter emp) {

		boolean r = false;

		try {
			Date d = new Date();

			int nbr_jour = (int) ((d.getTime() - emp.getDate_emprunt().getTime()) / (1000 * 60 * 60 * 24));
			System.out.println(nbr_jour);
			if (nbr_jour > 30) {
				r = true;
				emp.getPersonne().setSanctioner(true);
				prsDao.update(emp.getPersonne());
				Amende am = new Amende(nbr_jour, d, emp);
				am = amdDao.findBy(am, DAOImpAmende.EMP).get(0);
				if ( !am.isRegler() ) {
					if (am.equals(null)) {
						System.out.println("empty");
						amdDao.create(am);
					} else {
						System.out.println("not empty");
						am.setId(amdDao.findBy(am, DAOImpAmende.EMP).get(0).getId());
						amdDao.update(am);
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;

	}

	public void SituationRegler(Amende amd) {
		// TODO Auto-generated method stub
		amd.setRegler(true);
		amdDao.update(amd);
	}

	public List<Amende> ListeAmd(Amende amd, int type) {
		List<Amende> liste = null;
		try {
			liste = amdDao.findBy(amd, type);
		} catch (Exception e) {
		}
		return liste;
	}

}
