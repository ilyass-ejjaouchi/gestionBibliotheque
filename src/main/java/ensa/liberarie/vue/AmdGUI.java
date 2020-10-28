package ensa.liberarie.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ensa.liberarie.dao.daoImp.DAOImpAmende;
import ensa.liberarie.dao.daoImp.DAOImpPersonne;
import ensa.liberarie.entities.Amende;
import ensa.liberarie.entities.Emprunter;
import ensa.liberarie.entities.Personne;
import ensa.liberarie.metier.DAOFactory;
import ensa.liberarie.metier.MetierAmendeImp;
import ensa.liberarie.metier.MetierEmprunterImp;
import ensa.liberarie.vue.AdhGUI.ListerListener;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AmdGUI {

	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private MetierAmendeImp metier = new MetierAmendeImp();
	private MetierEmprunterImp metierEmp = new MetierEmprunterImp(DAOFactory.LIVRE);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AmdGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 905, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 52, 905, 514);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(114, 12, 748, 405);
		panel.add(panel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 96, 740, 269);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "ref_emprunte", "date", "jour", "situation", "prix", "selectionner"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, Long.class, String.class, Integer.class, String.class, Long.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(110);
		scrollPane.setViewportView(table);

		JButton button = new JButton("Supprimer");
		button.setBounds(622, 377, 114, 25);
		panel_2.add(button);

		JButton btnRegler = new JButton("regler");
		btnRegler.setBounds(388, 377, 114, 25);
		panel_2.add(btnRegler);
		btnRegler.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				for (int count = 0; count < table.getModel().getRowCount(); count++) {

					TableModel model = table.getModel();

					if (model.getValueAt(count, 6).toString().equals("true")) {

						metier.SituationRegler(new Amende((Long) model.getValueAt(count, 0),
								new Emprunter((Long) model.getValueAt(count, 1)), (Date) model.getValueAt(count, 2),
								(Integer) model.getValueAt(count, 3), false, (Double) model.getValueAt(count, 5)));

						new ListerListener().actionPerformed(e);
						JOptionPane.showMessageDialog(new JFrame(), "situation regler.", "Dialog",
								JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("\n");
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Chercher", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_1.setBounds(12, 12, 710, 56);
		panel_2.add(panel_1);

		JButton btn_search = new JButton("chercher\n");
		btn_search.setIcon(new ImageIcon(AmdGUI.class.getResource("/images/search.png")));
		btn_search.setBounds(530, 12, 168, 38);
		panel_1.add(btn_search);
		btn_search.addActionListener(new ListerListener());
	}

	class ListerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			for (Amende am : metier.ListeAmd(null, DAOImpAmende.LISTE)) {
				model.addRow(new Object[] { am.getId(), am.getEmp().getId(), am.getDate(), am.getNbr_jour(),
						am.isRegler() ? "regler" : "non regler", am.getPrix(), false });
			}
		}
	}
	
	

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmdGUI window = new AmdGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
