package ensa.liberarie.metier;

import java.util.List;

import ensa.liberarie.entities.Emprunter;

public interface MetierEmprunte {
	
	public void AjouterEmp(Emprunter emp);
	public List<Emprunter> AfficherListeEmp(Emprunter emp , int type);
	public void FinEmp(Emprunter emp);

}
