package ensa.liberarie.vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;

public class MenuGUI {

	private JFrame frame;
	private AdhGUI adhG = new AdhGUI();
	private EmpGUI EmpG = new EmpGUI();
	private AmdGUI amdG = new AmdGUI();
	JPanel menu_panel;
	private final CardLayout cl = new CardLayout();
	JPanel glb_panel = new JPanel(cl);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI window = new MenuGUI();
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
	public MenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton home = new JButton("Menu principale");
		home.setForeground(Color.WHITE);
		home.setBackground(Color.DARK_GRAY);
		home.setBounds(0, -12, 905, 63);
		frame.getContentPane().add(home);
		home.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(glb_panel, "menu");

			}
		});

		glb_panel.setBackground(new Color(0, 0, 0, 0));

		glb_panel.setBounds(12, 52, 905, 514);
		frame.getContentPane().add(glb_panel);

		menu_panel = new JPanel();
		menu_panel.setLayout(null);
		glb_panel.add(menu_panel, "menu");
		glb_panel.add(adhG.getAdhPanel(), "adh");
		glb_panel.add(EmpG.getEmpPanel(), "emp");
		glb_panel.add(amdG.getPanel(), "amd");



		JButton Adh_btn = new JButton("Gestion Adherent");
		Adh_btn.setBounds(34, 123, 163, 91);
		menu_panel.add(Adh_btn);
		Adh_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(glb_panel, "adh");

			}
		});

		JButton Emp_btn = new JButton("Gestion Emprunte");
		Emp_btn.setBounds(631, 123, 163, 91);
		menu_panel.add(Emp_btn);
		
		JButton Amd_btn = new JButton("Gestion Amende");
		Amd_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(glb_panel, "amd");
			}
		});
		
		Amd_btn.setBounds(344, 123, 163, 91);
		menu_panel.add(Amd_btn);
		Emp_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(glb_panel, "emp");
			}
		});

	}
}
