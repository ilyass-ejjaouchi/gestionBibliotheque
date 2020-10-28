package ensa.liberarie.entities;

import java.util.List;

public class Personne {
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private boolean sanctioner;
	private boolean adherer;
	private int nbr_emp;
	private List<Amende> amendes;
	private EtatPrs etat;

	public Personne() {
		super();
	}
	
	

	public Personne(long id) {
		super();
		this.id = id;
	}



	public Personne(String nom, String prenom, String adresse, boolean sanctioner, boolean adherer) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.sanctioner = sanctioner;
		this.adherer = adherer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public boolean isSanctioner() {
		return sanctioner;
	}

	public void setSanctioner(boolean sanctioner) {
		this.sanctioner = sanctioner;
	}

	public boolean isAdherer() {
		return adherer;
	}

	public void setAdherer(boolean adherer) {
		this.adherer = adherer;
	}
	
	

	public int getNbr_emp() {
		return nbr_emp;
	}



	public void setNbr_emp(int nbr_emp) {
		this.nbr_emp = nbr_emp;
	}

	


	public List<Amende> getAmendes() {
		return amendes;
	}



	public void setAmendes(List<Amende> amendes) {
		this.amendes = amendes;
	}



	public EtatPrs getEtat() {
		return etat;
	}



	public void setEtat(EtatPrs etat) {
		this.etat = etat;
	}



	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", sanctioner="
				+ sanctioner + ", adherer=" + adherer + ", amendes=" + amendes + "]";
	}

}
