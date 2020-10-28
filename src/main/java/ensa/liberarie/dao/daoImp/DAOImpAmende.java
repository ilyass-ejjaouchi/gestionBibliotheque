package ensa.liberarie.dao.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.entities.Amende;
import ensa.liberarie.entities.Emprunter;


public class DAOImpAmende extends DAO<Amende>{
	
	public static final int LISTE = 0;
	public static final int ID = 1;
	public static final int EMP = 2;
	public static final int STU = 3;

	
	
	private static final String CREATE = "INSERT INTO Amende(date,nbr_jour,prix,situation,FK_EMP) VALUES (?,?,?,?,?)";

	private static final String UPDATE = "UPDATE Amende SET date =?, nbr_jour=? , prix=? , FK_EMP = ? , situation=? WHERE id = ?";

	private static final String DELETE = "DELETE FROM Amende WHERE id=?";

	private static final String READ_LIST = "SELECT  * FROM Amende";
	private static final String READ_LIST_ID = "SELECT  * FROM Amende WHERE id = ?";
	private static final String READ_BY_EMP = "SELECT * FROM Amende WHERE FK_EMP=?";
	private static final String READ_BY_ST = "SELECT * FROM Amende WHERE situation=false";




	@Override
	public Amende create(Amende obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connect.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			ps.setObject(1, obj.getDate());
			ps.setInt(2, obj.getNbr_jour());
			ps.setDouble(3, obj.getPrix());
			ps.setBoolean(4, obj.isRegler());
			ps.setLong(5, obj.getEmp().getId());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			long id = rs.getInt(1);
			obj.setId(id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean delete(Amende obj){
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(DELETE);
			ps.setLong(1, obj.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Amende obj)  {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connect.prepareStatement(UPDATE);
			ps.setObject(1, obj.getDate());
			ps.setInt(2, obj.getNbr_jour());
			ps.setDouble(3, obj.getPrix());
			ps.setLong(4, obj.getEmp().getId());
			ps.setBoolean(5, obj.isRegler());
			ps.setLong(6, obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Amende> findBy(Amende obj, int type)  {
		Amende Amd = new Amende();
		List<Amende> list = new ArrayList<Amende>();
		ResultSet result;
		DAOImpEmprunter dao_emp = new DAOImpEmprunter();

		try {
			PreparedStatement ps;
			switch (type) {

			case ID:
				ps = connect.prepareStatement(READ_LIST_ID);
				ps.setLong(1, obj.getId());
				break;
			case EMP:
				ps = connect.prepareStatement(READ_BY_EMP);
				ps.setLong(1, obj.getEmp().getId());
				break;
			case STU:
				ps = connect.prepareStatement(READ_BY_ST);
				break;
			case LISTE:
			default:
				ps = connect.prepareStatement(READ_LIST);
				break;

			}
			result = ps.executeQuery();

			while (result.next()) 
			{
				
				Date d_Amd = result.getDate(2);
				int nbr_jour = result.getInt(3);
				double prix = result.getDouble(4);
				boolean rg = result.getBoolean(5);
				long id_emp = result.getLong(6);

				
				
				Amd.setDate(d_Amd);
				Amd.setNbr_jour(nbr_jour);
				Amd.setPrix(prix);
				Amd.setRegler(rg);
				Amd.setEmp(dao_emp.findBy(new Emprunter(id_emp) , DAOImpEmprunter.ID).get(0));
				Amd.setId(result.getLong(1));
				list.add(Amd);

			}
			result.close();
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}
	
	

}
