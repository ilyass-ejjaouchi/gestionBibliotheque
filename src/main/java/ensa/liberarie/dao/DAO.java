package ensa.liberarie.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.CommunicationException;

import ensa.liberarie.entities.Document;
import ensa.liberarie.entities.Livre;

public abstract class DAO<T> {

	protected Connection connect = null;

	public DAO(){
		try {
			this.connect = SingletonConnection.getConnection();
		} catch (ExceptionInInitializerError e) {
			// TODO: handle exception
			System.out.println("erre" +e.getMessage());
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("erre"+e.getMessage());
		} catch (NoClassDefFoundError e) {
			System.out.println("erre"+e.getMessage());

		}

	}

	public abstract T create(T obj) ;

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj) ;

	public abstract List<T> findBy(T obj, int type) ;

}
