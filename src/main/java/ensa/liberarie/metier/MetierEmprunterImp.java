package ensa.liberarie.metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.dao.daoImp.DAOImpAmende;
import ensa.liberarie.dao.daoImp.DAOImpEmprunter;
import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.dao.daoImp.daoImpEtatPrs;
import ensa.liberarie.entities.Amende;
import ensa.liberarie.entities.Document;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.EtatPrs;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Personne;

public class MetierEmprunterImp implements MetierEmprunte {
	private DAO<Emprunter> empDao;
	private DAO<Personne> prsDao;
	private DAO<Amende> amdDao;
	private DAO<Document> docDao;
	private DAO<EtatPrs> etatDao;

	private int type;
	String erreur = "";

	public MetierEmprunterImp(int type) {
		super();
		// TODO Auto-generated constructor stub
		this.type = type;

		docDao = (DAO<Document>) DAOFactory.dAOFactory(type);
		empDao = new DAOImpEmprunter();
		prsDao = new DAOImpPersonne();
		amdDao = new DAOImpAmende();
		etatDao= new daoImpEtatPrs();

	}

	public void AjouterEmp(Emprunter emp) {
		try {

			if ( isAllow(emp)) {
				emp.setRegler(false);
				empDao.create(emp);
				emp.getDocument().moinQuantité();
				docDao.update(emp.getDocument());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erreur = e.getMessage();
		}

	}

	public List<Emprunter> AfficherListeEmp(Emprunter emp, int type) {

		List<Emprunter> liste = new ArrayList<Emprunter>();

		try {
			liste = empDao.findBy(emp, type);

			if (this.type == DAOFactory.LIVRE) {
				for (Emprunter i : liste) {
					i.setDocument(docDao.findBy(new Livre(i.getDocument().getId()), DAOImpLivre.ID).get(0));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	/****************************************/

	public void FinEmp(Emprunter emp) {
		try {
			emp = empDao.findBy(emp, DAOImpEmprunter.ID).get(0);
			
			if (emp.getDate_retoure()==null) {
				emp.setRegler(true);
				emp.setDate_retoure(new Date());
				empDao.update(emp);

				if (type == DAOFactory.LIVRE) {
					Livre l = (Livre) docDao.findBy(new Livre(emp.getDocument().getId()), DAOImpLivre.ID).get(0);
					l.plusQuantité();
					docDao.update(l);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Boolean isAllow(Emprunter emp) throws Exception {
		int n = 0;
		int y = 0;
		boolean rs = true;
		EtatPrs etat = new EtatPrs(emp.getPersonne().getId());
		etat=this.etatDao.findBy(etat, DAOImpPersonne.ID).get(0);
		
		
		if(emp.getDocument().getQuantité()<0)
		{
			erreur = "stock insufisant";
			rs=false;
		}else if((etat.getDateFirstEmp().getTime()-(new Date()).getTime())/(1000 * 60 * 60 * 24) > 30 || etat.getNbrEmpMois()==0) 
		{
			etat.setEtat("ad");
			etat.setDateFirstEmp(new Date());
			etat.setNbrEmpMois(1);
		}
		else if( etat.getNbrEmpMois() < 6) {
			System.out.println(etat.getNbrEmpMois());

			etat.setNbrEmpMois(etat.getNbrEmpMois()+1);			
		}else {
			System.out.println(etat.getNbrEmpMois());
			etat.setEtat("pd");
			erreur ="vous avez depaser le nombre";
			rs=false;
		} 
		System.out.println("++++++++++++ "+etat);

		this.etatDao.update(etat);
		
		return rs;

	}

	public boolean testEmprunte(long id_emp) {
		Emprunter emp = new Emprunter();
		boolean r = false;
		emp.setId(id_emp);
		emp = empDao.findBy(emp, DAOImpEmprunter.ID).get(0);
		Date d = new Date();
		int nbr_jour = (int) ((d.getTime() - emp.getDate_emprunt().getTime()) / (1000 * 60 * 60 * 24));
		System.out.println(nbr_jour);
		if (nbr_jour > 30)
			r = true;
		else
			r = false;
		return r;

	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

}
