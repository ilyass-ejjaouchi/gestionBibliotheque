package ensa.liberarie.entities;

import java.io.Serializable;
import java.util.Date;



public class Amende implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static long CU = 15;
	private long id;
	private int nbr_jour;
	private double prix = nbr_jour * CU;
	private boolean regler;
	private Date date;

	private Emprunter emp;

	
	public Amende(long id, Emprunter emp,  Date date,int nbr_jour, boolean regler, double prix) {
		super();
		this.id = id;
		this.nbr_jour = nbr_jour;
		this.prix = prix;
		this.regler = regler;
		this.date = date;
		this.emp = emp;
	}

	public Amende() {

	}

	public Amende(long id) {
		super();
		this.id = id;
	}

	public Amende(int nbr_jour, Date date, Emprunter emp) {
		super();
		this.nbr_jour = nbr_jour;
		this.prix = nbr_jour * CU;
		this.date = date;
		this.emp = emp;
	}

	public Amende(int nbr_jour) {
		this.nbr_jour = nbr_jour;
		this.prix = nbr_jour * CU;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNbr_jour() {
		return nbr_jour;
	}

	public void setNbr_jour(int nbr_jour) {
		this.nbr_jour = nbr_jour;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Emprunter getEmp() {
		return emp;
	}

	public void setEmp(Emprunter emp) {
		this.emp = emp;
	}

	public boolean isRegler() {
		return regler;
	}

	public void setRegler(boolean regler) {
		this.regler = regler;
	}
	

}
