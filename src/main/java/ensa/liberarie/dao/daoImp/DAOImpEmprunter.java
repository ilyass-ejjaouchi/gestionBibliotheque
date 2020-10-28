package ensa.liberarie.dao.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import ensa.liberarie.dao.DAO;
import ensa.liberarie.entities.CD;
import ensa.liberarie.entities.DVD;
import ensa.liberarie.entities.Document;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Personne;

public class DAOImpEmprunter extends DAO<Emprunter> {

	

	public static final int LISTE = 0;
	public static final int ID = 1;
	public static final int PER = 2;
	public static final int NOT_REG = 3;
	public static final int PER_ID = 4;
	//av=AUDIO VIDEO
	public static final int AV_PER = 5;
	public static final int PER_NAME  = 6;
	public static final int LV_TITLE  = 7;

	

	private static final String CREATE = "INSERT INTO Emprunter(date_emprunt,date_retoure,FK_DOC,FK_PR) VALUES (?,?,?,?)";

	private static final String UPDATE = "UPDATE Emprunter SET date_emprunt=?,date_retoure=?,FK_DOC=?,FK_PR=? WHERE id = ?";

	private static final String DELETE = "DELETE FROM Emprunter WHERE id=?";

	private static final String READ_LIST = "SELECT  * FROM Emprunter";
	private static final String READ_PER_ID = "SELECT emp.* FROM Emprunter emp,Livre lv ,Personnee pr WHERE lv.id=emp.FK_DOC AND pr.id=emp.FK_PR AND pr.id=?";
	private static final String READ_PER_NAME = "SELECT emp.* FROM Emprunter emp,Livre lv ,Personnee pr WHERE lv.id=emp.FK_DOC AND pr.id=emp.FK_PR AND pr.nom LIKE ?";
	private static final String READ_TITLE = "SELECT emp.* FROM Emprunter emp,Livre lv WHERE lv.id=emp.FK_DOC AND lv.titre LIKE ?";

	
	private static final String READ_AV_PER = "SELECT emp.* FROM Emprunter emp,Audio_Video av WHERE av.id=emp.FK_DOC WHERE emp.FK_PR=?";

	private static final String READ_LIST_ID = "SELECT  * FROM Emprunter WHERE id = ?";
	private static final String READ_LIST_REG = "SELECT  * FROM Emprunter WHERE regler = false";
	private static final String READ_LIST_PER = "SELECT  * FROM Emprunter WHERE FK_PR = ?";

	@Override
	public Emprunter create(Emprunter obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connect.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			ps.setObject(1, obj.getDate_emprunt());
			ps.setObject(2, obj.getDate_retoure());
			ps.setLong(3, obj.getDocument().getId());
			ps.setLong(4, obj.getPersonne().getId());
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
	public boolean delete(Emprunter obj)  {
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
	public boolean update(Emprunter obj) {

		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(UPDATE);
			ps.setObject(1, obj.getDate_emprunt());
			ps.setObject(2, obj.getDate_retoure());
			ps.setLong(3, obj.getDocument().getId());
			ps.setLong(4, obj.getPersonne().getId());
			ps.setLong(5, obj.getId());


			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Emprunter> findBy(Emprunter obj, int type) {
		List<Emprunter> list = new ArrayList<Emprunter>();
		String typ;
		ResultSet result;
		DAOImpPersonne dao_per = new DAOImpPersonne();

		try {
			PreparedStatement ps;
			switch (type) {

			case ID:
				ps = connect.prepareStatement(READ_LIST_ID);
				ps.setLong(1, obj.getId());
				break;
			case PER:
				ps = connect.prepareStatement(READ_LIST_PER);
				ps.setLong(1, obj.getPersonne().getId());
				break;
			case NOT_REG:
				ps = connect.prepareStatement(READ_LIST_REG);
				break;
			case PER_ID:
				ps = connect.prepareStatement(READ_PER_ID);
				ps.setLong(1, obj.getPersonne().getId());
				break;
			case AV_PER:
				ps = connect.prepareStatement(READ_AV_PER);
				ps.setLong(1, obj.getPersonne().getId());
				break;
			case PER_NAME:
				ps = connect.prepareStatement(READ_PER_NAME);
				ps.setString(1, "%"+obj.getPersonne().getNom()+"%");
				break;
			case LV_TITLE:
				ps = connect.prepareStatement(READ_TITLE);
				ps.setString(1, "%"+((Livre)obj.getDocument()).getTitre()+"%");
				break;
			case LISTE:
			default:
				ps = connect.prepareStatement(READ_LIST);
				break;

			}
			result = ps.executeQuery();

			while (result.next()) {
				Emprunter emp = new Emprunter();

				ResultSet rs;
				Date d_emp = result.getDate(2);
				Date d_rtr = result.getDate(3);
				long id_doc = result.getLong(4);
				long id_pr = result.getLong(5);

				/*
				 * PreparedStatement pss =
				 * connect.prepareStatement("SELECT * FROM Document WHERE id=?");
				 * 
				 * pss.setLong(1, id_doc); System.out.println(id_doc); rs = pss.executeQuery();
				 * rs.next(); typ = rs.getString(2);
				 */
				emp.setDate_emprunt(d_emp);
				emp.setDate_retoure(d_rtr);
				emp.setDocument(new Document(id_doc));
				emp.setPersonne(dao_per.findBy(new Personne(id_pr), DAOImpPersonne.ID).get(0));
				emp.setId(result.getLong(1));
				// System.out.println(emp);
				list.add(emp);

			}
			result.close();
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	private static Document GetDocumentType(String type, long id_doc) throws Exception {

		if (type.equals("livre")) {
			Livre lv = new Livre();
			lv.setId(id_doc);
			DAOImpLivre dao_livre = new DAOImpLivre();
			lv = dao_livre.findBy(lv, DAOImpLivre.ID).get(0);
			return lv;
		} else if (type.equals("cd")) {
			CD cd = new CD();
			cd.setId(id_doc);
			DAOImpCD dao_cd = new DAOImpCD();
			cd = dao_cd.findBy(cd, DAOImpLivre.ID).get(0);
			return cd;
		} else if (type.equals("dvd")) {
			DVD dvd = new DVD();
			dvd.setId(id_doc);
			DAOImpDVD dao_cd = new DAOImpDVD();
			dvd = dao_cd.findBy(dvd, DAOImpLivre.ID).get(0);
			return dvd;
		} else {
			return null;
		}

	}

}
