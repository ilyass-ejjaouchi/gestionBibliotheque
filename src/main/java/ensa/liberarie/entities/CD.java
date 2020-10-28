package ensa.liberarie.entities;

public class CD extends Audio_Video {
	
	private String nom_album;
	private String nom_interpreteur;
	private String nom_editeur;
	
	public CD() {
		super();
	}
	
	public CD(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public CD(String nom_album,String nom_interpreteur, String nom_editeur  , int quantité) {
		super();
		this.nom_album = nom_album;
		this.nom_interpreteur = nom_interpreteur;
		this.nom_editeur = nom_editeur;
		this.quantité=quantité;
	}
	

	public String getNom_album() {
		return nom_album;
	}
	public void setNom_album(String nom_album) {
		this.nom_album = nom_album;
	}
	public String getNom_interpreteur() {
		return nom_interpreteur;
	}
	public void setNom_interpreteur(String nom_interpreteur) {
		this.nom_interpreteur = nom_interpreteur;
	}
	public String getNom_editeur() {
		return nom_editeur;
	}
	public void setNom_editeur(String nom_editeur) {
		this.nom_editeur = nom_editeur;
	}

	

	@Override
	public String toString() {
		return "CD [nom_album=" + nom_album + ", nom_interpreteur=" + nom_interpreteur + ", nom_editeur=" + nom_editeur
				+ ", quantité=" + quantité + ", id=" + id + "]";
	}
	
	
	
	
}
