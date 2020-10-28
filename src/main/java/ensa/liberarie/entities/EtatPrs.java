package ensa.liberarie.entities;

import java.util.Date;

public class EtatPrs {
	
	long id;
	String etat;
	Date dateFirstEmp;
	int nbrEmpMois;
	
	
	public EtatPrs(long id) {
		super();
		this.id = id;
		
	}
	
	public EtatPrs(String etat, Date dateFirstEmp, int nbrEmpMois) {
		super();
		this.etat = etat;
		this.dateFirstEmp = dateFirstEmp;
		this.nbrEmpMois = nbrEmpMois;
	}
	
	public EtatPrs(long id, String etat, Date dateFirstEmp, int nbrEmpMois) {
		super();
		this.id = id;
		this.etat = etat;
		this.dateFirstEmp = dateFirstEmp;
		this.nbrEmpMois = nbrEmpMois;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDateFirstEmp() {
		return dateFirstEmp;
	}
	public void setDateFirstEmp(Date dateFirstEmp) {
		this.dateFirstEmp = dateFirstEmp;
	}
	public int getNbrEmpMois() {
		return nbrEmpMois;
	}
	public void setNbrEmpMois(int nbrEmpMois) {
		this.nbrEmpMois = nbrEmpMois;
	}

	@Override
	public String toString() {
		return "EtatPrs [id=" + id + ", etat=" + etat + ", dateFirstEmp=" + dateFirstEmp + ", nbrEmpMois=" + nbrEmpMois
				+ "]";
	}

	
	
	
}
