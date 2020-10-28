package ensa.liberarie.metier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.dao.daoImp.DAOImpCD;
import ensa.liberarie.dao.daoImp.DAOImpDVD;
import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.entities.*;

public class DAOFactory {

	public static int LIVRE = 0;
	public static int CD = 1;
	public static int DVD = 2;

	public static Object dAOFactory(int type) {
		
			try {
				if (type == 0)
					return new DAOImpLivre();
				else if (type == 1)
					return new DAOImpCD();
				else
				return new DAOImpDVD();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

	public static  Document GetClass(int type, long id) throws ClassNotFoundException {
		Class cl;
		Object o2 =null;

		try {
			cl = Class.forName(Livre.class.getName());
			Class[] types = new Class[] { Long.class };
			Constructor ct = cl.getConstructor(types);
			 o2 = ct.newInstance(new Long[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Livre)o2;

	}

}
