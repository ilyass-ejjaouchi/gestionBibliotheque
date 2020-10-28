package javaprojet;

import java.util.logging.Level;
import java.util.logging.Logger;
import liberarie.dao.daoImp.DAOImpProvenance;
import liberarie.entities.Provenance;
public class AddProvenance extends javax.swing.JFrame {

   
    public AddProvenance() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TitreText = new javax.swing.JLabel();
        AuteurText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnAjouter = new javax.swing.JButton();
        IDFiled = new javax.swing.JTextField();
        NomFiled = new javax.swing.JTextField();
        AdresseFiled = new javax.swing.JTextField();
        TitreText1 = new javax.swing.JLabel();
        retourMenu = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        TypeFiled = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitreText.setFont(new java.awt.Font("Sylfaen", 1, 14)); 
        TitreText.setText("Type:");

        AuteurText.setFont(new java.awt.Font("Sylfaen", 1, 14));
        AuteurText.setText("Nom :");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); 
        jLabel4.setText("Adresse:");

        BtnAjouter.setText("Ajouter");
        BtnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouterActionPerformed(evt);
            }
        });

        IDFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFiledActionPerformed(evt);
            }
        });

        NomFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomFiledActionPerformed(evt);
            }
        });

        AdresseFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdresseFiledActionPerformed(evt);
            }
        });

        TitreText1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        TitreText1.setText("ID:");
        retourMenu.setIcon(new javax.swing.ImageIcon("F:\\studies\\listLivre.png"));
        retourMenu.setText("retour au menu principal");
        retour.setText("Retour");
        retour.setIcon(new javax.swing.ImageIcon("F:\\studies\\reply (1).png"));
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });

        TypeFiled.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maison d'édition", "Librerie" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitreText1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AuteurText)
                                    .addComponent(jLabel4)
                                    .addComponent(TitreText))
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AdresseFiled, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(NomFiled, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(IDFiled, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(TypeFiled, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(retour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(retourMenu)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retourMenu)
                    .addComponent(retour))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText1)
                    .addComponent(IDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText)
                    .addComponent(TypeFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuteurText)
                    .addComponent(NomFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AdresseFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(BtnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(524, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }
    DAOImpProvenance daop= new DAOImpProvenance();
    private void BtnAjouterActionPerformed(java.awt.event.ActionEvent evt) {
     Provenance p= new Provenance(NomFiled.getText(), AdresseFiled.getText(), TypeFiled.getSelectedItem().toString());
        try {
            daop.create(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void IDFiledActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NomFiledActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void AdresseFiledActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void retourActionPerformed(java.awt.event.ActionEvent evt) {
        GestionLivre p= new GestionLivre();
        setVisible(false);
        p.setVisible(true);
        p.setSize(1200, 550);
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddProvenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProvenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProvenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProvenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProvenance().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField AdresseFiled;
    private javax.swing.JLabel AuteurText;
    private javax.swing.JButton BtnAjouter;
    private javax.swing.JTextField IDFiled;
    private javax.swing.JTextField NomFiled;
    private javax.swing.JLabel TitreText;
    private javax.swing.JLabel TitreText1;
    private javax.swing.JComboBox<String> TypeFiled;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton retour;
    private javax.swing.JButton retourMenu;
    // End of variables declaration//GEN-END:variables
}
