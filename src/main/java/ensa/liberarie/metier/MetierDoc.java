package ensa.liberarie.metier;

import java.util.List;

import ensa.liberarie.entities.Document;


	
	public interface MetierDoc {
		public void AjouterDoc(Document doc);
		public Document ModifierDoc(Document doc);
		public void SupprimerDoc(Document doc);
		public List<? extends Document> TrouverDoc(Document doc,int type);
	}