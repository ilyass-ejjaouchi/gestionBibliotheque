package ensa.liberarie.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Livre extends Document {

	private String titre;
	private int nbr_page;
	private double prix;
	private String auteur;
	private Provenance provenance;
	private Maison_edition maison_edition;

	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livre(long id) {
		super(id);
	}
	public Livre(String titre, int nbr_page, double prix, String auteur, Provenance provenance,
			Maison_edition maison_edition) {
		super();
		this.titre = titre;
		this.nbr_page = nbr_page;
		this.prix = prix;
		this.auteur = auteur;
		this.provenance = provenance;
		this.maison_edition = maison_edition;
	}

	public Livre(String titre, int nbr_page, double prix,String auteur, int nbr) {
		super();

		this.titre = titre;
		this.nbr_page = nbr_page;
		this.prix = prix;
		this.auteur = auteur;
		this.quantité = nbr;
	}

	public Livre(String titre, int nbr_page, Double prix) {
		this.titre = titre;
		this.nbr_page = nbr_page;
		this.prix = prix;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbr_page() {
		return nbr_page;
	}

	public void setNbr_page(int nbr_page) {
		this.nbr_page = nbr_page;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Provenance getProv() {
		return provenance;
	}

	public void setProv(Provenance prov) {
		this.provenance = prov;
	}

	public Maison_edition getMaison_edition() {
		return maison_edition;
	}

	public void setMaison_edition(Maison_edition maison_edition) {
		this.maison_edition = maison_edition;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Provenance getProvenance() {
		return provenance;
	}

	public void setProvenance(Provenance provenance) {
		this.provenance = provenance;
	}
	
	

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", nbr_page=" + nbr_page + ", prix=" + prix + ", auteur=" + auteur
				+ ", provenance=" + provenance + ", maison_edition=" + maison_edition + ", id=" + id + ", nbr=" + quantité
				+ "]";
	}


	

}
