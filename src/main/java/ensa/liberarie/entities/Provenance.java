package ensa.liberarie.entities;

public class Provenance {
	
	private long id;
	private String nom;
	private String adresse;
	
	
	public Provenance(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Provenance(String nom) {
		super();
		this.nom = nom;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	


	
}
