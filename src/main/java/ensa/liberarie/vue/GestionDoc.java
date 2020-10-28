
package ensa.liberarie.vue;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.*;

public class GestionDoc extends  JFrame {

    public GestionDoc() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new  JLabel();
        BtnCd = new  JButton();
        BtnLivre = new  JButton();
        BtnDVD = new  JButton();
        jLabel2 = new  JLabel();
        jLabel3 = new  JLabel();
        jLabel4 = new  JLabel();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("GESTION DES DOCUMENTS");

        BtnCd.setIcon(new  ImageIcon(getClass().getResource("images/cd.png"))); 
        BtnCd.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                BtnCdActionPerformed(evt);
            }
        });

        BtnLivre.setIcon(new  ImageIcon(getClass().getResource("images/books.png"))); 
        BtnLivre.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                BtnLivreActionPerformed(evt);
            }
        });

        BtnDVD.setIcon(new  ImageIcon("images/DVD.png"));
        BtnDVD.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                BtnDVDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        jLabel2.setText("Gestion des DVD");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        jLabel3.setText("Gestion des Livres");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        jLabel4.setText("Gestion des CD");

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(452, 452, 452))
                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnCd,  GroupLayout.PREFERRED_SIZE, 229,  GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(BtnLivre,  GroupLayout.PREFERRED_SIZE, 229,  GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(BtnDVD,  GroupLayout.PREFERRED_SIZE, 229,  GroupLayout.PREFERRED_SIZE))
                            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(220, 220, 220)
                                .addComponent(jLabel3)
                                .addGap(190, 190, 190)
                                .addComponent(jLabel2)
                                .addGap(46, 46, 46)))
                        .addGap(132, 132, 132))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLivre,  GroupLayout.PREFERRED_SIZE, 158,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDVD,  GroupLayout.PREFERRED_SIZE, 158,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCd,  GroupLayout.PREFERRED_SIZE, 158,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }

    private void BtnLivreActionPerformed( ActionEvent evt) {
        GestionLivre VuLivre= new GestionLivre();
        setVisible(false);
        VuLivre.setVisible(true);
        VuLivre.setSize(1200, 550);
    }

    private void BtnCdActionPerformed( ActionEvent evt) {
        GestionCd VuCD= new GestionCd();
        setVisible(false);
        VuCD.setVisible(true);
        VuCD.setSize(1200, 550);
    }

    private void BtnDVDActionPerformed( ActionEvent evt) {
          GestionDVD VuDVD= new GestionDVD();
        setVisible(false);
        VuDVD.setVisible(true);
        VuDVD.setSize(1200, 550);
    }

   
    public static void main(String args[]) {
        try {
            for ( UIManager.LookAndFeelInfo info :  UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                     UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(GestionDoc.class.getName()).log( Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
             Logger.getLogger(GestionDoc.class.getName()).log( Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
             Logger.getLogger(GestionDoc.class.getName()).log( Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
             Logger.getLogger(GestionDoc.class.getName()).log( Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDoc().setVisible(true);
            }
        });
    }
    private  JButton BtnCd;
    private  JButton BtnDVD;
    private  JButton BtnLivre;
    private  JLabel jLabel1;
    private  JLabel jLabel2;
    private  JLabel jLabel3;
    private  JLabel jLabel4;
}
