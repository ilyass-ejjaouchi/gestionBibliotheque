package ensa.liberarie.dao.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import ensa.liberarie.dao.DAOLivre;
import ensa.liberarie.entities.*;

public class DAOImpLivre extends DAOLivre {

	public static final int LISTE = 0;
	public static final int AUTEUR = 1;
	public static final int DISPONIBLE = 2;
	public static final int NBR_PAGE = 3;
	public static final int PRIX = 4;
	public static final int TITRE = 5;
	public static final int ID = 6;

	private static final String CREATE = "INSERT INTO Livre(id,auteur,nbr_page,prix,titre,FK_P,FK_M ,quantité) VALUES (?,?,?,?,?,?,?,?)";

	private static final String DELETE = "DELETE FROM Livre WHERE id=?";

	private static final String UPDATE = "UPDATE Livre SET auteur =? ,nbr_page=? , prix=? , titre = ? ,quantité=? WHERE id = ?";
	private static final String ADD_PROVENANCE = "UPDATE Livre SET FK_P=? WHERE id=?";
	private static final String ADD_MAISON_EDITION = "UPDATE Livre SET FK_M=? WHERE id=?";

	private static final String READ_LIST = "SELECT  * FROM Livre";
	private static final String READ_LIST_ID = "SELECT  * FROM Livre WHERE id = ?";
	private static final String READ_LIST_TITRE = "SELECT  * FROM Livre WHERE titre LIKE ?";
	private static final String READ_LIST_DISPO = "SELECT  * FROM Livre WHERE quantité> 0";
	private static final String READ_LIST_AUTEUR = "SELECT  * FROM Livre WHERE auteur LIKE ?";
	private static final String READ_LIST_PRIX = "SELECT  * FROM Livre WHERE prix <= ?";
	

	@Override
	public Livre create(Livre obj) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement ps = connect.prepareStatement("INSERT INTO Document VALUES(NULL)",
					Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			long id = rs.getInt(1);
			obj.setId(id);

			ps = connect.prepareStatement(CREATE);
			ps.setLong(1, id);
			ps.setString(2, obj.getAuteur());
			ps.setInt(3, obj.getNbr_page());
			ps.setDouble(4, obj.getPrix());
			ps.setString(5, obj.getTitre());
			ps.setLong(6, obj.getProvenance().getId());
			ps.setLong(7, obj.getMaison_edition().getId());
			ps.setInt(8, obj.getQuantité());

			System.out.println(ps);
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}

	public boolean delete(Livre obj) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(DELETE);
			ps.setLong(1, obj.getId());
			ps.executeUpdate();
			ps = connect.prepareStatement("DELETE FROM Document WHERE id=?");
			ps.setLong(1, obj.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Livre obj) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(UPDATE);
			ps.setString(1, obj.getAuteur());
			ps.setInt(2, obj.getNbr_page());
			ps.setDouble(3, obj.getPrix());
			ps.setString(4, obj.getTitre());
			ps.setInt(5, obj.getQuantité());
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
	public List<Livre> findBy(Livre obj, int type) {

		Livre lv = new Livre();
		List<Livre> list = new ArrayList<Livre>();

		try {
			PreparedStatement ps;
			switch (type) {
			case AUTEUR:
				ps = connect.prepareStatement(READ_LIST_AUTEUR);
				ps.setString(1, "%" + obj.getAuteur() + "%");
				break;
			case DISPONIBLE:
				ps = connect.prepareStatement(READ_LIST_DISPO);
				break;
			case PRIX:
				ps = connect.prepareStatement(READ_LIST_PRIX);
				ps.setDouble(1, obj.getPrix());
				break;
			case TITRE:
				ps = connect.prepareStatement(READ_LIST_TITRE);
				ps.setString(1, "%" + obj.getTitre() + "%");
				break;
			case ID:
				ps = connect.prepareStatement(READ_LIST_ID);
				ps.setLong(1, obj.getId());
				break;
			default:
				ps = connect.prepareStatement(READ_LIST);
				break;

			}
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				String titre = result.getString(2);
				String auteur = result.getString(3);
				int qt = result.getInt(4);
				int nbr_pg = result.getInt(5);
				double prix = result.getDouble(6);
				// maison_edition provenance

				lv = new Livre(titre, nbr_pg, prix, auteur, qt);
				lv.setId(result.getLong(1));
				list.add(lv);

			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

		return list;
	}

	@Override

	public void AddProvance(Provenance provence, Livre livre) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connect.prepareStatement(ADD_PROVENANCE);
			ps.setLong(1, provence.getId());
			ps.setLong(2, livre.getId());

			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void AddMaisonEdition(Maison_edition maisonEdition) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connect.prepareStatement(ADD_MAISON_EDITION);
			ps.setLong(1, maisonEdition.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
