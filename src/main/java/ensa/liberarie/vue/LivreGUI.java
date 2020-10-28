package ensa.liberarie.vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.JDesktopPane;

public class LivreGUI {

	private JFrame frame;

	private JButton Btn_Ajt;

	private JPanel EmpPanel;
	private JCheckBox Box_Ex;
	private JCheckBox Box_Nv;

	private JPanel Panel_Nv ;
	private JPanel Panel_Ex;
	private DAOImpEmprunter metier = new DAOImpEmprunter();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public LivreGUI() {
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
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1, 1);
		EmpPanel.add(desktopPane);

		JPanel Panel_Find = new JPanel();
		Panel_Find.setToolTipText("\n");
		Panel_Find.setBounds(310, 12, 695, 80);
		EmpPanel.add(Panel_Find);
		Panel_Find.setLayout(null);
		Panel_Find.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Chercher",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(536, 23, 114, 25);
		Panel_Find.add(btnNewButton);
		// Btn_Search.addActionListener(new ListerListener());

		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 298, 461);
		EmpPanel.add(panel);

		JLabel lblGestionDesEmprunte = new JLabel("Gestion des livres\n");
		lblGestionDesEmprunte.setForeground(new Color(25, 25, 112));
		lblGestionDesEmprunte.setBounds(66, 37, 155, 26);
		panel.add(lblGestionDesEmprunte);

		Btn_Ajt = new JButton("Ajouter");
		Btn_Ajt.setBounds(168, 514, 114, 25);
		Btn_Ajt.setEnabled(false);

		// Btn_Ajt.addActionListener(new AddListener());

		panel.add(Btn_Ajt);

		JButton btnMeniPrincipale = new JButton("Menu Principale");
		btnMeniPrincipale.setBackground(Color.LIGHT_GRAY);
		btnMeniPrincipale.setBounds(22, 12, 249, 25);
		panel.add(btnMeniPrincipale);

		Box_Ex = new JCheckBox("existant");
		Box_Ex.setBackground(Color.WHITE);
		Box_Ex.setBounds(22, 82, 126, 23);
		panel.add(Box_Ex);
		Box_Ex.addItemListener(new NavListener());
		


		Box_Nv = new JCheckBox("nouveau", true);
		Box_Nv.setBackground(Color.WHITE);
		Box_Nv.setBounds(173, 82, 126, 23);
		panel.add(Box_Nv);
		Box_Nv.addItemListener(new NavListener());
		Box_Nv.setSelected(true);


		 Panel_Nv = new JPanel();
		Panel_Nv.setBackground(Color.WHITE);
		Panel_Nv.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nouveau", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		Panel_Nv.setBounds(6, 113, 292, 299);
		panel.add(Panel_Nv);
		Panel_Nv.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(18, 43, 124, 19);
		Panel_Nv.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(18, 89, 124, 19);
		Panel_Nv.add(textField_1);
		
		JLabel label_2 = new JLabel("Pages\n");
		label_2.setBounds(18, 122, 56, 15);
		Panel_Nv.add(label_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(92, 120, 50, 19);
		Panel_Nv.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(92, 183, 50, 19);
		Panel_Nv.add(spinner_2);
		
		JLabel label_3 = new JLabel("Prix");
		label_3.setBounds(18, 185, 56, 15);
		Panel_Nv.add(label_3);
		
		JLabel label_4 = new JLabel("Quantité");
		label_4.setBounds(18, 251, 87, 15);
		Panel_Nv.add(label_4);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(92, 249, 50, 19);
		Panel_Nv.add(spinner_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(154, 43, 124, 84);
		Panel_Nv.add(scrollPane_2);
		
		JLabel label_5 = new JLabel("maison edition");
		label_5.setBounds(169, 157, 111, 15);
		Panel_Nv.add(label_5);
		
		JLabel label_6 = new JLabel("maison edition");
		label_6.setBounds(169, 26, 111, 15);
		Panel_Nv.add(label_6);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(154, 185, 124, 84);
		Panel_Nv.add(scrollPane_3);
		
		JLabel label_7 = new JLabel("Pages\n");
		label_7.setBounds(18, 74, 56, 15);
		Panel_Nv.add(label_7);
		
		JLabel label_8 = new JLabel("Pages\n");
		label_8.setBounds(18, 26, 87, 15);
		Panel_Nv.add(label_8);
		
		Panel_Ex = new JPanel();
		Panel_Ex.setLayout(null);
		Panel_Ex.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Existant", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		Panel_Ex.setBackground(Color.WHITE);
		Panel_Ex.setBounds(6, 113, 292, 299);
		Panel_Ex.setVisible(false);
		panel.add(Panel_Ex);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(5, 17, 283, 106);
		Panel_Ex.add(panel_3);

		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 24, 148, 54);
		panel_3.add(scrollPane_1);
		
		JLabel label = new JLabel("Titre livre");
		label.setBounds(12, 0, 106, 15);
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(173, 0, 66, 15);
		panel_3.add(label_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(183, 25, 78, 37);
		panel_3.add(spinner);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(157, 424, 114, 25);
		panel.add(btnAjouter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 104, 684, 283);
		EmpPanel.add(scrollPane);

		frame.setBounds(100, 100, 1100, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class NavListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == Box_Ex && e.getStateChange() == ItemEvent.SELECTED) {
				
				Box_Nv.setSelected(false);
				Panel_Ex.setVisible(true);
				Panel_Nv.setVisible(false);

			} else if (e.getSource() == Box_Nv && e.getStateChange() == ItemEvent.SELECTED) {
				
				Box_Ex.setSelected(false);
				Panel_Ex.setVisible(false);
				Panel_Nv.setVisible(true);
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivreGUI window = new LivreGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
