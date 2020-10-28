package ensa.liberarie.dao.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.entities.CD;

public class DAOImpCD extends DAO<CD> {
	public static final int LIST = 0;
	public static final int NOM_ALBUM = 1;
	public static final int DISPONIBLE = 2;
	public static final int NOM_EDITEUR = 3;
	public static final int NOM_INTERPRETEUR = 4;
	public static final int PRIX = 5;
	public static final int ID = 6;


	private static final String CREATE = "INSERT INTO CD(id ,nom_album,nom_editeur,nom_interpreteur,quantité) VALUES (?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM CD WHERE id=?";
	private static final String UPDATE = "UPDATE CD SET nom_album=?,nom_editeur=?,nom_interpreteur=?, quantité=? WHERE id=?";
	private static final String READ_LIST_NOM_ALBUM = "SELECT  * FROM CD WHERE nom_album LIKE ?";
	private static final String READ_LIST_DISPONIBLE = "SELECT  * FROM CD WHERE nbr > 0";
	private static final String READ_LIST_NOM_EDITEUR = "SELECT  * FROM CD WHERE nom_editeur LIKE ?";
	private static final String READ_LIST_NOM_INTERPRETEUR = "SELECT  * FROM CD WHERE nom_interpreteur LIKE ?";
	private static final String READ_LIST = "SELECT  * FROM CD ";
	private static final String READ_BY_ID = "SELECT  * FROM CD WHERE id = ?";


	@Override
	public CD create(CD obj) {
		// TODO Auto-generated method stub
		try {
			// add Document
			PreparedStatement ps = connect.prepareStatement("INSERT INTO Document(type) VALUES(?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "cd");
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			long id = rs.getInt(1);
			obj.setId(id);

			ps = connect.prepareStatement("INSERT INTO Audio_Video(id) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);
			ps.executeUpdate();

			// add DVD nom_album=?,disponible=?,nom_editeur=?,nom_interpreteur=?,prix=?
			ps = connect.prepareStatement(CREATE);
			ps.setLong(1, id);
			ps.setString(2, obj.getNom_album());
			ps.setString(3, obj.getNom_editeur());
			ps.setString(4, obj.getNom_interpreteur());
			ps.setInt(5, obj.getQuantité());

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
	public boolean delete(CD obj) {
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
	public boolean update(CD obj) {
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(UPDATE);

			ps.setString(1, obj.getNom_album());
			ps.setString(2, obj.getNom_editeur());
			ps.setString(3, obj.getNom_interpreteur());
			ps.setInt(4, obj.getQuantité());
			ps.setLong(5, obj.getId());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public List<CD> findBy(CD obj, int type) {
		// TODO Auto-generated method stub
		ArrayList<CD> List = new ArrayList<CD>();
		CD cd  = new CD();
		try {
			PreparedStatement ps;
			switch (type) {
			case NOM_ALBUM:
				ps = connect.prepareStatement(READ_LIST_NOM_ALBUM);
				ps.setString(1, "%" + obj.getNom_album() + "%");
				break;
			case DISPONIBLE:
				ps = connect.prepareStatement(READ_LIST_DISPONIBLE);
				break;
			case NOM_INTERPRETEUR:
				ps = connect.prepareStatement(READ_LIST_NOM_INTERPRETEUR);
				ps.setString(1, "%" + obj.getNom_interpreteur() + "%");
				break;
			case NOM_EDITEUR :
				ps = connect.prepareStatement(READ_LIST_NOM_EDITEUR);
				ps.setString(1, "%" + obj.getNom_editeur() + "%");
			break;
			case ID:
				ps = connect.prepareStatement(READ_BY_ID);
				ps.setDouble(1, obj.getId());
				break;
			default:
				ps = connect.prepareStatement(READ_LIST);
				break;
			}
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				String nom_album = result.getString(2);
				String nom_editeur = result.getString(3);
				String nom_interp = result.getString(4);
				int qt = result.getInt(5);

				cd = new CD(nom_album, nom_interp, nom_editeur,qt );
				cd.setId(result.getLong(1));
				List.add(cd);
			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
		return List;
	}

}
