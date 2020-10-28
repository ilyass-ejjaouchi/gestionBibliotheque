package ensa.liberarie.entities;

import java.util.Date;

public class Emprunter {


	private long id;
	private Date date_emprunt;
	private Date date_retoure;
	private boolean regler;
	private Document document;
	private Personne personne;

	public Emprunter(long id) {
		super();
		this.id = id;
	}

	public Emprunter(Date date_emprunt, Personne personne, Document document) {
		super();
		this.date_emprunt = date_emprunt;
		this.personne = personne;
		this.document = document;
	}

	public Emprunter(Date date_emprunt, Date date_retoure, Personne personne, Document document) {
		super();
		this.date_emprunt = date_emprunt;
		this.date_retoure = date_retoure;
		this.personne = personne;
		this.document = document;
	}

	public Emprunter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emprunter(Date date_emprunt, Date date_retoure) {
		super();
		this.date_emprunt = date_emprunt;
		this.date_retoure = date_retoure;
	}

	public Date getDate_retoure() {
		return date_retoure;
	}

	public void setDate_retoure(Date date_retoure) {
		this.date_retoure = date_retoure;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate_emprunt() {
		return date_emprunt;
	}

	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public boolean isRegler() {
		return regler;
	}

	public void setRegler(boolean regler) {
		this.regler = regler;
	}

	@Override
	public String toString() {
		return "Emprunter [id=" + id + ", date_emprunt=" + date_emprunt + ", date_retoure=" + date_retoure
				+ ", personne=" + personne + ", regler=" + regler + ", document=" + document + "]";
	}

}
