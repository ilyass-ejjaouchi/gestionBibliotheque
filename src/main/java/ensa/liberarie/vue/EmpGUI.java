package ensa.liberarie.vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ensa.liberarie.dao.daoImp.DAOImpEmprunter;
import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Personne;
import ensa.liberarie.metier.DAOFactory;
import ensa.liberarie.metier.MetierAdherentImp;
import ensa.liberarie.metier.MetierAmendeImp;
import ensa.liberarie.metier.MetierDocImp;
import ensa.liberarie.metier.MetierEmprunterImp;
import ensa.liberarie.vue.AdhGUI.searchListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class EmpGUI {

	private JFrame frame;
	private JButton Btn_Search;
	private JTable table;

	private JList<String> list_Prs;
	private JList<String> list_lv;

	private JPanel EmpPanel;

	private JRadioButton Box_FindBy_Nom;
	private JRadioButton Box_FindBy_liste;
	private JRadioButton Box_FindBy_NRg;
	private JRadioButton Box_FindBy_Livre;

	private boolean FindBy_Nom = false;
	private boolean FindBy_liste = true;
	private boolean FindBy_Livre = false;
	private boolean FindBy_NRg = false;

	private JTextField Nom_search;

	private MetierEmprunterImp metier = new MetierEmprunterImp(DAOFactory.LIVRE);
	private JTextField Field_personne;
	private JTextField field_livre;

	private JButton Btn_ajt;

	private Map<String, Livre> livre_emp;
	private Map<String, Personne> pr_emp;
	private JScrollPane scrollPane_1;
	private JTextField Lv_Search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpGUI window = new EmpGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmpGUI() {

		// TODO Auto-generated catch block
		/*
		 * JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Dialog",
		 * JOptionPane.ERROR_MESSAGE);
		 */

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		EmpPanel = new JPanel();
		EmpPanel.setBackground(UIManager.getColor("Button.background"));
		EmpPanel.setLayout(null);
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBackground(Color.PINK);
		frame.setContentPane(EmpPanel);

		JPanel Panel_Tab = new JPanel();
		Panel_Tab.setBounds(319, 93, 566, 331);
		EmpPanel.add(Panel_Tab);
		Panel_Tab.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 12, 566, 269);
		Panel_Tab.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "id", "Nom", "Titre", "Date emprunte", "Date retoure", "selectionner" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(133);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(411, 294, 114, 25);

		Panel_Tab.add(btnSupprimer);

		JButton btnFin = new JButton("Fin");
		btnFin.setBounds(242, 294, 114, 25);
		Panel_Tab.add(btnFin);
		btnFin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int count = 0; count < table.getModel().getRowCount(); count++) {

					if (table.getModel().getValueAt(count, 5).toString().equals("true")) {

						System.out.println(table.getModel().getValueAt(count, 1).toString() + "  "
								+ (Long) table.getModel().getValueAt(count, 0));

						if (metier.testEmprunte((Long) table.getModel().getValueAt(count, 0))) {
							JOptionPane.showMessageDialog(new JFrame(),
									"cette emprunte a dépassé 30jour.\nReglez d' abord l'amende!", "Dialog",
									JOptionPane.WARNING_MESSAGE);

						} else {
							Emprunter emp = new Emprunter((Long) table.getModel().getValueAt(count, 0));
							metier.FinEmp(emp);
							JOptionPane.showMessageDialog(new JFrame(), "Success!", "Dialog",
									JOptionPane.INFORMATION_MESSAGE);
						}

						new ListerEmpListener().actionPerformed(null);

					}
				}

			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				if (table.getSelectedRow() >= 0) {
					System.out.println("Im in");

					/*
					 * Box_IsAdh.setSelected( table.getModel().getValueAt(table.getSelectedRow(),
					 * 5).toString().equals("true")); Btn_Ajt.setText("update");
					 * Btn_Ajt.setEnabled(true);
					 */
				}

			}

		});

		JPanel Panel_Find = new JPanel();
		Panel_Find.setToolTipText("\n");
		Panel_Find.setBounds(309, 12, 580, 80);
		EmpPanel.add(Panel_Find);
		Panel_Find.setLayout(null);
		Panel_Find.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Chercher",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 12, 556, 56);
		Panel_Find.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBackground(UIManager.getColor("Button.background"));

		Box_FindBy_Nom = new JRadioButton("nom", false);
		Box_FindBy_Nom.setBackground(UIManager.getColor("Button.background"));
		Box_FindBy_Nom.setBounds(8, 8, 55, 23);
		Box_FindBy_Nom.addItemListener((new searchListener()));
		panel_6.add(Box_FindBy_Nom);

		Box_FindBy_NRg = new JRadioButton("non regler", false);
		Box_FindBy_NRg.setBounds(177, 8, 106, 23);
		Box_FindBy_NRg.addItemListener((new searchListener()));
		panel_6.add(Box_FindBy_NRg);

		Box_FindBy_liste = new JRadioButton("Liste", true);
		Box_FindBy_liste.setBounds(85, 8, 69, 23);
		Box_FindBy_liste.addItemListener((new searchListener()));
		panel_6.add(Box_FindBy_liste);

		Nom_search = new JTextField();
		Nom_search.setBounds(12, 35, 106, 21);
		Nom_search.setEnabled(false);
		Nom_search.setColumns(10);
		panel_6.add(Nom_search);

		Btn_Search = new JButton("chercher");
		Btn_Search.setBounds(414, 3, 130, 32);
		panel_6.add(Btn_Search);

		Box_FindBy_Livre = new JRadioButton("Livre");
		Box_FindBy_Livre.setBounds(307, 8, 69, 23);
		panel_6.add(Box_FindBy_Livre);
		Box_FindBy_Livre.addItemListener(new searchListener());

		Lv_Search = new JTextField();
		Lv_Search.setEnabled(false);
		Lv_Search.setColumns(10);
		Lv_Search.setBounds(305, 35, 106, 21);
		panel_6.add(Lv_Search);
		Btn_Search.addActionListener(new ListerEmpListener());

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 307, 514);
		EmpPanel.add(panel);

		JLabel lblGestionDesEmprunte = new JLabel("Gestion des Emprunte\n");
		lblGestionDesEmprunte.setForeground(new Color(25, 25, 112));
		lblGestionDesEmprunte.setBounds(67, 12, 155, 26);
		panel.add(lblGestionDesEmprunte);

		JLabel lblTitreLivre = new JLabel("Titre livre");
		lblTitreLivre.setBounds(112, 38, 106, 15);
		panel.add(lblTitreLivre);

		JLabel lblNomPersonne = new JLabel("Nom Personne");
		lblNomPersonne.setBounds(87, 198, 106, 15);
		panel.add(lblNomPersonne);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(85, 229, 148, 127);
		panel.add(scrollPane_2);

		list_Prs = new JList<String>();
		list_Prs.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		list_Prs.addListSelectionListener(new ListePrListener());

		scrollPane_2.setViewportView(list_Prs);

		Field_personne = new JTextField();
		Field_personne.setColumns(10);
		scrollPane_2.setColumnHeaderView(Field_personne);
		Field_personne.addKeyListener(new FieldPrListener());

		Btn_ajt = new JButton("Ajouter");
		Btn_ajt.setBounds(100, 368, 114, 25);
		panel.add(Btn_ajt);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(85, 65, 148, 127);
		panel.add(scrollPane_1);

		list_lv = new JList<String>();
		scrollPane_1.setViewportView(list_lv);
		list_lv.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		list_lv.addListSelectionListener(new ListeLvListener());

		frame.setBounds(100, 100, 905, 514);

		field_livre = new JTextField();
		scrollPane_1.setColumnHeaderView(field_livre);
		field_livre.setColumns(10);
		field_livre.addKeyListener(new FieldLvListener());
		Btn_ajt.setEnabled(false);

		Btn_ajt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (pr_emp.containsKey(Field_personne.getText().trim())
						&& livre_emp.containsKey(field_livre.getText().trim())) {

					Emprunter emp = new Emprunter(new Date(), pr_emp.get(Field_personne.getText()),
							livre_emp.get(field_livre.getText()));
					metier.AjouterEmp(emp);

					if (metier.getErreur().isEmpty()) {
						JOptionPane.showMessageDialog(new JFrame(), "sucess", "Dialog",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(new JFrame(), metier.getErreur(), "Dialog",
								JOptionPane.ERROR_MESSAGE);
						metier.setErreur("");
					}

					new ListerEmpListener().actionPerformed(null);

				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"le titre ou/et la personne saisie sont introuvable!\n"
									+ "veuillez les selectionner depuis la liste.",
							"Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ListePrListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (list_Prs.getSelectedValue() != null)
				Field_personne.setText((String) list_Prs.getSelectedValue());
			list_Prs.setModel(new DefaultListModel());
		}
	}

	class ListeLvListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (list_lv.getSelectedValue() != null)
				field_livre.setText((String) list_lv.getSelectedValue());
			list_lv.setModel(new DefaultListModel());
		}
	}

	class FieldPrListener implements KeyListener {
		public void keyReleased(KeyEvent e) {
			if (field_livre.getText().trim().length() > 0 && Field_personne.getText().trim().length() > 0) {
				Btn_ajt.setEnabled(true);
			} else {
				Btn_ajt.setEnabled(false);
			}
			pr_emp = new HashMap<String, Personne>();
			MetierAdherentImp m = new MetierAdherentImp();
			Personne pr = new Personne();
			pr.setNom(Field_personne.getText());

			DefaultListModel<String> model = new DefaultListModel<String>();
			for (Personne i : m.TrouverAdherent(pr, DAOImpPersonne.LIST_MC)) {
				String mw = i.getNom() + " " + i.getPrenom();
				model.addElement(mw);
				pr_emp.put(mw, i);
			}
			list_Prs.setModel(model);
		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	class FieldLvListener implements KeyListener {
		public void keyReleased(KeyEvent e) {
			if (field_livre.getText().trim().length() > 0 && Field_personne.getText().trim().length() > 0) {
				Btn_ajt.setEnabled(true);
			} else {
				Btn_ajt.setEnabled(false);
			}
			livre_emp = new HashMap<String, Livre>();
			MetierDocImp m = new MetierDocImp(DAOFactory.LIVRE);
			Livre lv = new Livre();
			lv.setTitre(field_livre.getText());

			DefaultListModel<String> model = new DefaultListModel<String>();
			for (Livre i : (List<Livre>) m.TrouverDoc(lv, DAOImpLivre.TITRE)) {
				String mw = i.getTitre();
				model.addElement(mw);
				livre_emp.put(mw, i);
			}
			list_lv.setModel(model);
		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	class ListerEmpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			if (FindBy_liste) {
				for (Emprunter emp : metier.AfficherListeEmp(null, DAOImpEmprunter.LISTE)) {
					MetierAmendeImp am = new MetierAmendeImp();
					am.AddAmende(emp);
					String nom = emp.getPersonne().getNom() + " " + emp.getPersonne().getPrenom();

					model.addRow(new Object[] { emp.getId(), nom, ((Livre) emp.getDocument()).getTitre(),
							emp.getDate_emprunt(), (emp.getDate_retoure() == null) ? "not yet" : emp.getDate_retoure(),
							false });

				}

			} else if (FindBy_Nom) {
				Emprunter em = new Emprunter();
				em.setPersonne(new Personne());
				em.getPersonne().setNom(Nom_search.getText());

				for (Emprunter emp : metier.AfficherListeEmp(em, DAOImpEmprunter.PER_NAME)) {

					String nom = emp.getPersonne().getNom() + " " + emp.getPersonne().getPrenom();
					System.out.println(em);
					model.addRow(new Object[] { emp.getId(), nom, ((Livre) emp.getDocument()).getTitre(),
							emp.getDate_emprunt(), (emp.getDate_retoure() == null) ? "not yet" : emp.getDate_retoure(),
							false });

				}

			} else if (FindBy_NRg) {
				for (Emprunter emp : metier.AfficherListeEmp(null, DAOImpEmprunter.LISTE)) {
					if (emp.getDate_retoure() == null) {
						MetierAmendeImp am = new MetierAmendeImp();
						am.AddAmende(emp);
						String nom = emp.getPersonne().getNom() + " " + emp.getPersonne().getPrenom();

						model.addRow(new Object[] { emp.getId(), nom, ((Livre) emp.getDocument()).getTitre(),
								emp.getDate_emprunt(), (emp.getDate_retoure() == null) ? "not yet" : emp.getDate_retoure(),
								false });
					}

				}

			} else if(FindBy_Livre) {
				
				System.out.println("**********************************************************************************");

				Emprunter em = new Emprunter();
				// em.setPersonne(ne);
				em.setDocument(new Livre());
				((Livre) em.getDocument()).setTitre(Lv_Search.getText().trim());
				for (Emprunter emp : metier.AfficherListeEmp(em, DAOImpEmprunter.LV_TITLE)) {

					MetierAmendeImp am = new MetierAmendeImp();
					am.AddAmende(emp);
					String nom = emp.getPersonne().getNom() + " " + emp.getPersonne().getPrenom();

					model.addRow(new Object[] { emp.getId(), nom, ((Livre) emp.getDocument()).getTitre(),
							emp.getDate_emprunt(), (emp.getDate_retoure() == null) ? "not yet" : emp.getDate_retoure(),
							false });
				}
			}

			Field_personne.setText("");
			field_livre.setText("");

		}
	}

	class searchListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == Box_FindBy_Nom && e.getStateChange() == ItemEvent.SELECTED) {

				FindBy_Livre = false;
				FindBy_liste = false;
				FindBy_Nom = true;
				FindBy_NRg = false;
				Box_FindBy_Nom.setSelected(true);
				Box_FindBy_liste.setSelected(false);
				Box_FindBy_Livre.setSelected(false);
				Box_FindBy_NRg.setSelected(false);
				Nom_search.setEnabled(true);
				Lv_Search.setEnabled(false);

				Nom_search.setText("");

			} else if (e.getSource() == Box_FindBy_liste && e.getStateChange() == ItemEvent.SELECTED) {
				FindBy_Livre = false;
				FindBy_liste = true;
				FindBy_Nom = false;
				FindBy_NRg = false;
				Box_FindBy_Nom.setSelected(false);
				Box_FindBy_liste.setSelected(true);
				Box_FindBy_Livre.setSelected(false);
				Box_FindBy_NRg.setSelected(false);
				Nom_search.setEnabled(false);
				Lv_Search.setEnabled(false);

			} else if (e.getSource() == Box_FindBy_Livre && e.getStateChange() == ItemEvent.SELECTED) {

				FindBy_Livre = true;
				FindBy_liste = false;
				FindBy_Nom = false;
				FindBy_NRg = false;
				Box_FindBy_Nom.setSelected(false);
				Box_FindBy_liste.setSelected(false);
				Box_FindBy_Livre.setSelected(true);
				Box_FindBy_NRg.setSelected(false);
				Nom_search.setEnabled(false);
				Lv_Search.setEnabled(true);

				Lv_Search.setText("");

			} else if (e.getSource() == Box_FindBy_NRg && e.getStateChange() == ItemEvent.SELECTED) {

				FindBy_Livre = false;
				FindBy_liste = false;
				FindBy_Nom = false;
				FindBy_NRg = true;
				Box_FindBy_Nom.setSelected(false);
				Box_FindBy_liste.setSelected(false);
				Box_FindBy_Livre.setSelected(false);
				Box_FindBy_NRg.setSelected(true);
				Nom_search.setEnabled(false);
				Lv_Search.setEnabled(false);

			}

		}
	}

	public JPanel getEmpPanel() {
		return EmpPanel;
	}

	public void setEmpPanel(JPanel empPanel) {
		EmpPanel = empPanel;
	}
}
