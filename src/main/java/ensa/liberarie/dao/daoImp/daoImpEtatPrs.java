package ensa.liberarie.dao.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ensa.liberarie.dao.DAO;
import ensa.liberarie.entities.EtatPrs;
import ensa.liberarie.entities.Personne;

public class daoImpEtatPrs extends DAO<EtatPrs> {
	
	
		private static String CREAT ="INSERT INTO etatPrs VALUES(?,?,?,?)";
		private static String UPDATE ="UPDATE  etatPrs SET etat=? , datePremiereEmp=? , NbrEmp=? WHERE id=?";
		private static String FIND ="SELECT * FROM etatPrs WHERE id=?";

	@Override
	public EtatPrs create(EtatPrs obj) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps=connect.prepareStatement(CREAT);
			ps.setLong(1, obj.getId());
			ps.setString(2, obj.getEtat());
			ps.setObject(3, obj.getDateFirstEmp());
			ps.setInt(4, obj.getNbrEmpMois());
			ps.executeUpdate();
		}catch(SQLException e) {
			
		}
		
		
		return null;
	}

	@Override
	public boolean delete(EtatPrs obj) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	@Override
	public boolean update(EtatPrs obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connect.prepareStatement(UPDATE);

			ps.setString(1, obj.getEtat());
			ps.setObject(2, obj.getDateFirstEmp());
			ps.setInt(3, obj.getNbrEmpMois());
			ps.setLong(4, obj.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			
		}
		return true;
	}

	@Override
	public List<EtatPrs> findBy(EtatPrs obj, int type) {
		// TODO Auto-generated method stub
		List<EtatPrs> list = new ArrayList<EtatPrs>();

		try {
			PreparedStatement ps=connect.prepareStatement(FIND);
			ps.setLong(1, obj.getId());
			ResultSet result = ps.executeQuery();
			result.next();
			
			obj.setEtat(result.getString(2));
			obj.setDateFirstEmp(result.getDate(3));
			obj.setNbrEmpMois(result.getInt(4));
			list.add(obj);
			
		}catch(SQLException e) {
			
		}
		
		return list;
	}
	
	

}
