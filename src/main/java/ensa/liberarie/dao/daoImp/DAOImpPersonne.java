package ensa.liberarie.dao.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.jboss.logging.Message;

import com.mysql.jdbc.Statement;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.entities.Personne;

public class DAOImpPersonne extends DAO<Personne> {

	

	public static final int LIST = 0;
	public static final int LIST_MC = 1;
	public static final int LIST_ADHERER = 2;
	public static final int LIST_SANCTIONER = 3;
	public static final int ID = 4;

	private static final String CREAT = "INSERT INTO Personnee(adherer,adresse,nom,prenom,sanctioner) VALUES (?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM Personnee WHERE id=?";
	private static final String UPDATE = "UPDATE Personnee SET adherer=?,adresse=?,nom=?,prenom=?,sanctioner=? WHERE id=?";
	private static final String READ_LIST = "SELECT * FROM Personnee";
	private static final String READ_LIST_MC = "SELECT * FROM Personnee WHERE nom LIKE ? OR prenom LIKE ?";
	private static final String READ_LIST_ADHERER = "SELECT * FROM Personnee WHERE adherer ";
	private static final String READ_LIST_SANCTIONER = "SELECT * FROM Personnee WHERE sanctioner";
	private static final String READ_BY_ID = "SELECT * FROM Personnee WHERE id=? ";

	private static final String MESSAGE = "Verifier la connexion avec la base de donnée";
	
	

	@Override
	public Personne create(Personne obj)  {
		try {
			PreparedStatement ps = connect.prepareStatement(CREAT, Statement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, obj.isAdherer());
			ps.setString(2, obj.getAdresse());
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setBoolean(5, obj.isSanctioner());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			long id = rs.getInt(1);
			obj.setId(id);
			ps.close();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		return obj;
	}

	@Override
	public boolean delete(Personne obj) {
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
	public boolean update(Personne obj) {
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(UPDATE);
			ps.setBoolean(1, obj.isAdherer());
			ps.setString(2, obj.getAdresse());
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setBoolean(5, obj.isSanctioner());
			ps.setLong(6, obj.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Personne> findBy(Personne obj, int type)  {
		Personne p = new Personne();
		List<Personne> list = new ArrayList<Personne>();
		try {
			PreparedStatement ps;
			switch (type) {
			case LIST:
				ps = connect.prepareStatement(READ_LIST);
				break;
			case LIST_MC:
				ps = connect.prepareStatement(READ_LIST_MC);
				ps.setString(1, "%" + obj.getNom() + "%");
				ps.setString(2, "%" + obj.getNom() + "%");

				break;
			case LIST_ADHERER:
				ps = connect.prepareStatement(READ_LIST_ADHERER);
				break;
			case LIST_SANCTIONER:
				ps = connect.prepareStatement(READ_LIST_SANCTIONER);
				break;
			case ID:
				ps = connect.prepareStatement(READ_BY_ID);
				ps.setLong(1, obj.getId());
				break;
			default:
				ps = connect.prepareStatement(READ_LIST);
				break;
			}
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				String nom = result.getString(2);
				String prenom = result.getString(3);
				boolean adherer = result.getBoolean(4);
				boolean sanctioner = result.getBoolean(5);
				String adresse = result.getString(6);

				p = new Personne(nom, prenom, adresse, sanctioner, adherer);
				p.setId(result.getLong(1));
				list.add(p);

			}
			ps.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return list;
	}

}
