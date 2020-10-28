package ensa.liberarie.vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.entities.Personne;
import ensa.liberarie.metier.MetierAdherent;
import ensa.liberarie.metier.MetierAdherentImp;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class AdhGUI {

	private JFrame frame;

	private JTextField Field_Nom;
	private JTextField Field_Prenom;
	private JTextField Field_Ad;
	private JCheckBox Box_IsAdh;
	private boolean IsAdh = false;
	private JButton Btn_Ajt;
	private JButton Btn_Search;
	private JTable table;

	private JPanel AdhPanel;

	private JRadioButton Box_FindBy_Nom;
	private JRadioButton Box_FindBy_liste;
	private JRadioButton Box_FindBy_Adh;
	private boolean FindBy_Nom = false;
	private boolean FindBy_Adh = false;
	private boolean Find_All = false;

	private JTextField Nom_search;

	private MetierAdherent metier;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AdhGUI() {
		
			
			metier = new MetierAdherentImp();
		
		initialize();

		DefaultTableModel model = (DefaultTableModel) table.getModel();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdhPanel = new JPanel();
		AdhPanel.setBackground(UIManager.getColor("Button.background"));
		AdhPanel.setLayout(null);
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBackground(Color.PINK);
		frame.setContentPane(AdhPanel);

		JPanel Panel_Tab = new JPanel();
		Panel_Tab.setBounds(319, 93, 566, 331);
		AdhPanel.add(Panel_Tab);
		Panel_Tab.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 12, 566, 269);
		Panel_Tab.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Nom", "Prenom", "adresse", "Sanctionner", "Adherer", "Supprimer" }) {
			Class[] columnTypes = new Class[] { Long.class, String.class, String.class, String.class, Boolean.class,
					Boolean.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { true, false, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(411, 294, 114, 25);
		btnSupprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				for (int count = 0; count < table.getModel().getRowCount(); count++) {

					if (table.getModel().getValueAt(count, 6).toString().equals("true")) {

						System.out.println(table.getModel().getValueAt(count, 1).toString() + "  "
								+ (Long) table.getModel().getValueAt(count, 0));
						metier.SupprimerAdherent(new Personne((Long) table.getModel().getValueAt(count, 0)));
						Btn_Ajt.setText("Ajouter");
						Field_Nom.setText("");
						Field_Prenom.setText("");
						Field_Ad.setText("");
						Btn_Ajt.setEnabled(false);
						Box_IsAdh.setSelected(false);
						new ListerListener().actionPerformed(e);

					}
				}

			}
		});
		Panel_Tab.add(btnSupprimer);
		table.getColumnModel().getColumn(0).setWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(88);
		table.getColumnModel().getColumn(5).setResizable(false);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				if (table.getSelectedRow() >= 0) {
					System.out.println("Im in");
					Field_Nom.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
					Field_Prenom.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					Field_Ad.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
					Box_IsAdh.setSelected(
							table.getModel().getValueAt(table.getSelectedRow(), 5).toString().equals("true"));
					Btn_Ajt.setText("update");
					Btn_Ajt.setEnabled(true);
				}

			}

		});

		JPanel Panel_Find = new JPanel();
		Panel_Find.setToolTipText("\n");
		Panel_Find.setBounds(309, 12, 580, 80);
		AdhPanel.add(Panel_Find);
		Panel_Find.setLayout(null);
		Panel_Find.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Chercher",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 12, 556, 56);
		Panel_Find.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBackground(UIManager.getColor("Button.background"));

		Box_FindBy_Nom = new JRadioButton("nom");
		Box_FindBy_Nom.setBackground(UIManager.getColor("Button.background"));
		Box_FindBy_Nom.setBounds(8, 8, 55, 23);
		Box_FindBy_Nom.addItemListener(new searchListener());
		panel_6.add(Box_FindBy_Nom);

		Box_FindBy_Adh = new JRadioButton("adherent");
		Box_FindBy_Adh.setBounds(225, 8, 144, 23);
		Box_FindBy_Adh.addItemListener((new searchListener()));
		panel_6.add(Box_FindBy_Adh);

		Box_FindBy_liste = new JRadioButton("Liste", true);
		Box_FindBy_liste.setBounds(130, 8, 91, 23);
		Box_FindBy_liste.addItemListener((new searchListener()));
		panel_6.add(Box_FindBy_liste);

		Nom_search = new JTextField();
		Nom_search.setBounds(12, 35, 106, 21);
		Nom_search.setEnabled(false);
		Nom_search.setColumns(10);
		panel_6.add(Nom_search);

		Btn_Search = new JButton("chercher");
		Btn_Search.setBounds(381, 7, 130, 32);
		panel_6.add(Btn_Search);
		Btn_Search.addActionListener(new ListerListener());

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 295, 514);
		AdhPanel.add(panel);

		JLabel label = new JLabel("Gestion des Adherants\n");
		label.setForeground(new Color(25, 25, 112));
		label.setBounds(66, 37, 155, 26);
		panel.add(label);

		JLabel Label_Prenom = new JLabel("Prenom\n");
		Label_Prenom.setBounds(91, 133, 66, 15);
		panel.add(Label_Prenom);

		Field_Prenom = new JTextField();
		Field_Prenom.setColumns(10);
		Field_Prenom.setBounds(102, 148, 124, 19);
		Field_Prenom.addKeyListener(new TestFiled());
		panel.add(Field_Prenom);

		JLabel Label_Ad = new JLabel("Adresse");
		Label_Ad.setBounds(91, 192, 66, 15);
		panel.add(Label_Ad);

		Field_Ad = new JTextField();
		Field_Ad.setColumns(10);
		Field_Ad.setBounds(102, 207, 124, 19);
		Field_Ad.addKeyListener(new TestFiled());

		panel.add(Field_Ad);

		JLabel Label_Nom = new JLabel("Nom\n");
		Label_Nom.setBounds(91, 75, 66, 15);
		panel.add(Label_Nom);

		Field_Nom = new JTextField();
		Field_Nom.setColumns(10);
		Field_Nom.setBounds(102, 90, 124, 19);
		Field_Nom.addKeyListener(new TestFiled());

		panel.add(Field_Nom);

		Box_IsAdh = new JCheckBox("Adherer");
		Box_IsAdh.setForeground(Color.BLACK);
		Box_IsAdh.setBackground(Color.WHITE);
		Box_IsAdh.setBounds(102, 253, 126, 23);
		Box_IsAdh.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					IsAdh = true;
				} else {
					IsAdh = false;
				}
			}
		});

		panel.add(Box_IsAdh);

		Btn_Ajt = new JButton("Ajouter");
		Btn_Ajt.setBounds(119, 307, 114, 25);
		Btn_Ajt.setEnabled(false);

		Btn_Ajt.addActionListener(new AddListener());

		panel.add(Btn_Ajt);
		frame.setBounds(100, 100, 889, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			Personne p = new Personne(Field_Nom.getText(), Field_Prenom.getText(), Field_Ad.getText(), false, IsAdh);
			if (Btn_Ajt.getText().equals("Ajouter")) {
				try {
					metier.AjouterAdhrent(p);
				}
				catch (Exception er) {
					// TODO: handle exception
					System.out.println(er.getMessage());
				}

			} else {
				System.out.println(table.getModel().getValueAt(table.getSelectedRow(), 0));
				p.setId((Long) (table.getModel().getValueAt(table.getSelectedRow(), 0)));
				metier.ModifierAdherent(p);
			}
			Btn_Ajt.setText("Ajouter");
			Field_Nom.setText("");
			Field_Prenom.setText("");
			Field_Ad.setText("");
			Btn_Ajt.setEnabled(false);
			Box_IsAdh.setSelected(false);
			new ListerListener().actionPerformed(e);

		}
	}

	class searchListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == Box_FindBy_Adh && e.getStateChange() == ItemEvent.SELECTED) {

				FindBy_Adh = true;
				FindBy_Nom = false;
				Find_All = false;
				Box_FindBy_liste.setSelected(false);
				Box_FindBy_Nom.setSelected(false);
				Nom_search.setEnabled(false);

				Nom_search.setText("");

			} else if (e.getSource() == Box_FindBy_liste && e.getStateChange() == ItemEvent.SELECTED) {
				FindBy_Adh = false;
				FindBy_Nom = false;
				Find_All = true;
				Box_FindBy_Adh.setSelected(false);
				Box_FindBy_Nom.setSelected(false);
				Nom_search.setEnabled(false);
				Nom_search.setText("");

			} else if (e.getSource() == Box_FindBy_Nom && e.getStateChange() == ItemEvent.SELECTED) {

				FindBy_Nom = true;
				FindBy_Adh = false;
				Find_All = false;

				Box_FindBy_liste.setSelected(false);
				Box_FindBy_Adh.setSelected(false);
				Nom_search.setEnabled(true);

			}

		}
	}

	class ListerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			if (FindBy_Adh) {
				for (Personne p : metier.TrouverAdherent(null, DAOImpPersonne.LIST_ADHERER)) {

					model.addRow(new Object[] { p.getId(), p.getNom(), p.getPrenom(), p.getAdresse(), p.isSanctioner(),
							p.isAdherer(), false });

				}

			} else if (FindBy_Nom) {
				Personne f = new Personne();
				f.setNom(Nom_search.getText());
				for (Personne p : metier.TrouverAdherent(f, DAOImpPersonne.LIST_MC)) {

					model.addRow(new Object[] { p.getId(), p.getNom(), p.getPrenom(), p.getAdresse(), p.isSanctioner(),
							p.isAdherer(), false });

				}

			} else {
				for (Personne p : metier.TrouverAdherent(null, DAOImpLivre.LISTE)) {

					model.addRow(new Object[] { p.getId(), p.getNom(), p.getPrenom(), p.getAdresse(), p.isSanctioner(),
							p.isAdherer(), false });

				}

			}

		}
	}

	class TestFiled extends KeyAdapter {
		public void keyReleased(KeyEvent evt) {
			super.keyReleased(evt);
			if (Field_Ad.getText().trim().length() > 0 && Field_Nom.getText().trim().length() > 0
					&& Field_Prenom.getText().trim().length() > 0) {
				Btn_Ajt.setEnabled(true);
			} else {
				Btn_Ajt.setEnabled(false);
			}
		}
	}
	
	public JPanel getAdhPanel() {
		return AdhPanel;
	}

	public void setAdhPanel(JPanel adhPanel) {
		AdhPanel = adhPanel;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					AdhGUI window = new AdhGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
