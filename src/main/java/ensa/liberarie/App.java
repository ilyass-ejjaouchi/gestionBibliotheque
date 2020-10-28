package ensa.liberarie;

import java.lang.reflect.Method;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.dao.SingletonConnection;
import ensa.liberarie.dao.daoImp.DAOImpCD;
import ensa.liberarie.dao.daoImp.DAOImpDVD;
import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.entities.CD;
import ensa.liberarie.entities.DVD;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Personne;

/**
 * Hello world!
 *
 */
public class App {
public static void chg(Livre l){
	l.setAuteur("dede");
	
}

	public static void main(String[] args) {
		Livre l = new Livre();
		l.setAuteur("dddddddddddd");
		chg(l);
		System.out.println(l.getAuteur());
		
		try {
			Class c = Class.forName(String.class.getName());
			for(Method m :c.getMethods() )
			System.out.println(m );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*DAOImpPersonne d = new DAOImpPersonne();
    	Personne p = new Personne("gf", "ddd", "yyyyyyyyy", true, false);
    	p=d.create(p);
    	p.setAdresse("dakl");
    	d.update(p);
    	p.setId(1);
    	
    	
    	for(Personne i : d.findBy(p, DAOImpPersonne.LIST)) {
    		System.out.println(i);
    	}*/
    	
    	
    	
    	
    	/*DAOImpCD d = new DAOImpCD();
    	CD c = new CD("edsherre", true, "89", "89", 50.1);
    	
    	c.setId(57);
    	d.update(c);
    	System.out.println(c);*/
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//DAO<Livre> d = new DAOImpLivre();
    	
    	/*Livre s = new Livre();
    	s.setPrix(80.0);
    	s.setTitre("c");
    	s.setAuteur("hd");
    	
    	for(Livre i : d.findBy(s, DAOImpLivre.TITRE)) {
    		System.out.println(i);
    	}
    	
    	DAO<DVD> d = new DAOImpDVD();
    	DVD dv = new DVD();
    	//dv = d.create(dv);
    	dv.setNom_editeur("dc");
    	dv.setId(50);
    	//d.update(dv);
    	
    	for(DVD e : d.findBy(dv, DAOImpDVD.)) {
    		System.out.println(e);
    	}
    	//d.delete(dv);*/
    	
    
    	
    	
    	
    
}
