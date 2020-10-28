package ensa.liberarie.dao.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.mysql.jdbc.Statement;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.entities.DVD;
import ensa.liberarie.entities.Livre;

public class DAOImpDVD extends DAO<DVD> {

	public DAOImpDVD() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final int LIST = 0;
	public static final int NOM_EDITEUR = 1;
	public static final int DISPONIBLE = 2;
	public static final int NOM_FILM = 3;
	public static final int NOM_PRODUCTEUR = 4;
	public static final int NOM_REALISATEUR = 5;
	public static final int PRIX = 6;

	private static final String CREATE = "INSERT INTO DVD(id ,nom_editeur,disponible,nom_film,nom_producteur,nom_realisateur,prix) VALUES (?,?,?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM DVD WHERE id=?";
	private static final String UPDATE = "UPDATE DVD SET nom_editeur=?,disponible=?,nom_film=?,nom_producteur=?,nom_realisateur=?,prix=? WHERE id=?";
	private static final String READ_LIST_NOM_EDITEUR = "SELECT  * FROM DVD WHERE nom_editeur LIKE ?";
	private static final String READ_LIST_DISPONIBLE = "SELECT  * FROM DVD WHERE disponible = ?";
	private static final String READ_LIST_NOM_FILM = "SELECT  * FROM DVD WHERE nom_film LIKE ?";
	private static final String READ_LIST_NOM_PRODUCTEUR = "SELECT  * FROM DVD WHERE nom_producteur LIKE ?";
	private static final String READ_LIST_NOM_REALISATEUR = "SELECT  * FROM DVD WHERE nom_realisateur LIKE ?";
	private static final String READ_LIST_PRIX = "SELECT  * FROM DVD WHERE prix <= ?";
	private static final String READ_LIST = "SELECT  * FROM DVD ";

	@Override
	public DVD create(DVD obj) {
		// TODO Auto-generated method stub
		try {
			// add Document
			PreparedStatement ps = connect.prepareStatement("INSERT INTO Document(type) VALUES(?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "dvd");
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			long id = rs.getInt(1);
			obj.setId(id);

			ps = connect.prepareStatement("INSERT INTO Audio_Video(id) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);
			ps.executeUpdate();

			// add DVD
			ps = connect.prepareStatement(CREATE);
			ps.setLong(1, id);
			ps.setString(2, obj.getNom_editeur());
			ps.setBoolean(3, obj.getDisponible());
			ps.setString(4, obj.getNom_film());
			ps.setString(5, obj.getNom_producteur());
			ps.setString(6, obj.getNom_realisateur());
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return obj;

	}

	@Override
	public boolean delete(DVD obj) {
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(DELETE);
			ps.setLong(1, obj.getId());
			ps.executeUpdate();

			ps = connect.prepareStatement("DELETE FROM Audio_Video WHERE id=?");
			ps.setLong(1, obj.getId());
			ps.executeUpdate();

			ps = connect.prepareStatement("DELETE FROM Document WHERE id=?");
			ps.setLong(1, obj.getId());
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(DVD obj) {
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(UPDATE);

			ps.setString(1, obj.getNom_editeur());
			ps.setBoolean(2, obj.getDisponible());
			ps.setString(3, obj.getNom_film());
			ps.setString(4, obj.getNom_producteur());
			ps.setString(5, obj.getNom_realisateur());
			ps.setDouble(7, obj.getId());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<DVD> findBy(DVD obj, int type) {
		// TODO Auto-generated method stub
		ArrayList<DVD> List = new ArrayList<DVD>();
		DVD dvd = new DVD();
		try {
			PreparedStatement ps;
			switch (type) {
			case NOM_EDITEUR:
				ps = connect.prepareStatement(READ_LIST_NOM_EDITEUR);
				ps.setString(1, "%" + obj.getNom_editeur() + "%");
				break;
			case DISPONIBLE:
				ps = connect.prepareStatement(READ_LIST_DISPONIBLE);
				ps.setBoolean(1, obj.getDisponible());
				break;
			case NOM_FILM:
				ps = connect.prepareStatement(READ_LIST_NOM_FILM);
				ps.setString(1, "%" + obj.getNom_film() + "%");
				break;
			case NOM_PRODUCTEUR:
				ps = connect.prepareStatement(READ_LIST_NOM_PRODUCTEUR);
				ps.setString(1, "%" + obj.getNom_producteur() + "%");
				break;
			case NOM_REALISATEUR:
				ps = connect.prepareStatement(READ_LIST_NOM_REALISATEUR);
				ps.setString(1, "%" + obj.getNom_realisateur() + "%");
				break;
			default:
				ps = connect.prepareStatement(READ_LIST);
				break;
			}
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				String nom_editeur = result.getString(1);
				boolean dispo = result.getBoolean(2);
				String nom_film = result.getString(3);
				String nom_producteur = result.getString(4);
				String nom_realisateur = result.getString(5);
				double prix = result.getDouble(6);
				dvd = new DVD();
				dvd.setId(result.getLong(7));
				List.add(dvd);
			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
		return List;
	}

}
