package ensa.liberarie.entities;

public class DVD extends Audio_Video {

	private String nom_film;
	private String nom_realisateur;
	private String nom_producteur;
	private String nom_editeur;

	public DVD() {
		super();
	}

	public DVD(String nom_film, Boolean disponible, String nom_realisateur, String nom_producteur, String nom_editeur,
			int quantité) {
		super();
		this.nom_film = nom_film;
		this.disponible = disponible;
		this.nom_realisateur = nom_realisateur;
		this.nom_producteur = nom_producteur;
		this.nom_editeur = nom_editeur;
		this.quantité = quantité;
	}

	public String getNom_film() {
		return nom_film;
	}

	public void setNom_film(String nom_film) {
		this.nom_film = nom_film;
	}

	public String getNom_realisateur() {
		return nom_realisateur;
	}

	public void setNom_realisateur(String nom_realisateur) {
		this.nom_realisateur = nom_realisateur;
	}

	public String getNom_producteur() {
		return nom_producteur;
	}

	public void setNom_producteur(String nom_producteur) {
		this.nom_producteur = nom_producteur;
	}

	public String getNom_editeur() {
		return nom_editeur;
	}

	public void setNom_editeur(String nom_editeur) {
		this.nom_editeur = nom_editeur;
	}



	@Override
	public String toString() {
		return "DVD [nom_film=" + nom_film + ", nom_realisateur=" + nom_realisateur + ", nom_producteur="
				+ nom_producteur + ", nom_editeur=" + nom_editeur + ", id=" + id + "]";
	}

}
