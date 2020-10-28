package ensa.liberarie.vue;
import java.util.ArrayList;
import java.util.List;

import  javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import ensa.liberarie.dao.daoImp.DAOImpCD;
import ensa.liberarie.entities.CD;
import ensa.liberarie.metier.MetierDocImp;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.*;

public class GestionCd extends  JFrame {

    public GestionCd() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new  JScrollPane();
        Table = new  JTable();
        jPanel2 = new  JPanel();
        RechercheFiled = new  JTextField();
        BtnRecherche = new  JButton();
        jLabel1 = new  JLabel();
        jPanel1 = new  JPanel();
        TitreText = new  JLabel();
        AuteurText = new  JLabel();
        jLabel4 = new  JLabel();
        jLabel5 = new  JLabel();
        BtnAjouter = new  JButton();
        IDFiled = new  JTextField();
        EditeurFiled = new  JTextField();
        InterpreteurFiled = new  JTextField();
        PrixFiled = new  JTextField();
        reset = new  JButton();
        BtnSupprimer = new  JButton();
        TitreText1 = new  JLabel();
        AlbumFiled = new  JTextField();
        btnAfficher = new  JButton();
        BtnModifier = new  JButton();
        retourMenu = new  JButton();
        retour = new  JButton();
        jLabel8 = new  JLabel();
        CopieFiled = new  JTextField();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

        Table.setBorder( BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Table.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); 
        Table.setModel(new  DefaultTableModel(
            new Object [][] { },
            new String [] {
                "ID", "Nom d'Album", "Nom Editeur", "Nom Interpreteur", "quantiter"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new  MouseAdapter() {
            public void mouseClicked( MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        RechercheFiled.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                RechercheFiledActionPerformed(evt);
            }
        });

        BtnRecherche.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        BtnRecherche.setIcon(new  ImageIcon("/images/magnifierD.png"));
        BtnRecherche.setText("Recherche");
        BtnRecherche.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                BtnRechercheActionPerformed(evt);
            }
        });

         GroupLayout jPanel2Layout = new  GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(RechercheFiled,  GroupLayout.PREFERRED_SIZE, 230,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRecherche,  GroupLayout.PREFERRED_SIZE, 153,  GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(RechercheFiled,  GroupLayout.PREFERRED_SIZE, 25,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRecherche,  GroupLayout.PREFERRED_SIZE, 25,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel1.setText("Gestion des CD");

        TitreText.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        TitreText.setText("Nom Album:");

        AuteurText.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        AuteurText.setText("Nom Editeur:");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setText("Nom Interpreteur:");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setText("Prix:");

        BtnAjouter.setIcon(new  ImageIcon("/images/release.png")); // NOI18N
        BtnAjouter.setText("Ajouter");
        BtnAjouter.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                BtnAjouterActionPerformed(evt);
            }
        });

        IDFiled.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                IDFiledActionPerformed(evt);
            }
        });

        EditeurFiled.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                EditeurFiledActionPerformed(evt);
            }
        });

        InterpreteurFiled.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                InterpreteurFiledActionPerformed(evt);
            }
        });

        PrixFiled.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                PrixFiledActionPerformed(evt);
            }
        });

        reset.setIcon(new  ImageIcon("/images/restore.png")); // NOI18N
        reset.setText("Reinistialiser");
        reset.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        BtnSupprimer.setIcon(new  ImageIcon("F:\\studies\\album (1).png")); // NOI18N
        BtnSupprimer.setText("Supprimer");
        BtnSupprimer.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                BtnSupprimerActionPerformed(evt);
            }
        });

        TitreText1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        TitreText1.setText("ID:");

        AlbumFiled.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                AlbumFiledActionPerformed(evt);
            }
        });

        btnAfficher.setIcon(new  ImageIcon("F:\\studies\\album.png")); // NOI18N
        btnAfficher.setText("Afficher");
        btnAfficher.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btnAfficherActionPerformed(evt);
            }
        });

        BtnModifier.setIcon(new  ImageIcon("F:\\studies\\music-disc.png")); // NOI18N
        BtnModifier.setText("Modifier");
        BtnModifier.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                BtnModifierActionPerformed(evt);
            }
        });

        retourMenu.setIcon(new  ImageIcon("F:\\studies\\listCD.png")); // NOI18N
        retourMenu.setText("retour au menu principal");
        retourMenu.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                retourMenuActionPerformed(evt);
            }
        });

        retour.setIcon(new  ImageIcon("F:\\studies\\reply.png")); // NOI18N
        retour.setText("Retour");
        retour.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel8.setText("Nombre de Copie:");

        CopieFiled.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                CopieFiledActionPerformed(evt);
            }
        });

         GroupLayout jPanel1Layout = new  GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitreText1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                    .addComponent(AuteurText)
                                    .addComponent(jLabel4)
                                    .addComponent(TitreText)
                                    .addComponent(jLabel5))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                    .addComponent(PrixFiled,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 115,  GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InterpreteurFiled,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 115,  GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EditeurFiled,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 115,  GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AlbumFiled,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 115,  GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IDFiled,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 115,  GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(46, 46, 46)
                                .addComponent(CopieFiled)))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAfficher)
                        .addGap(36, 36, 36)
                        .addComponent(BtnAjouter)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnModifier)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(reset)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnSupprimer)
                .addGap(31, 31, 31))
            .addGroup( GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(retour)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(retourMenu)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(retourMenu)
                    .addComponent(retour))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText1)
                    .addComponent(IDFiled,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText)
                    .addComponent(AlbumFiled,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(AuteurText)
                    .addComponent(EditeurFiled,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(InterpreteurFiled,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(PrixFiled,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(CopieFiled,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModifier)
                    .addComponent(BtnAjouter)
                    .addComponent(btnAfficher))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSupprimer)
                    .addComponent(reset))
                .addGap(28, 28, 28))
        );

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jPanel1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel2,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1,  GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   DAOImpCD daocd= new DAOImpCD();
   
   MetierDocImp doc= new MetierDocImp(1);

    public void AfficherCd(){
       List<CD>list= (List<CD>)doc.TrouverDoc(null,DAOImpCD.LIST);
             DefaultTableModel model=(DefaultTableModel)Table.getModel();
             Object[] row=new Object[8];
             for(int i=0;i<list.size();i++){
             row[0]=list.get(i).getId();
             row[1]=list.get(i).getNom_album();
             row[2]=list.get(i).getNom_editeur();          
             row[3]=list.get(i).getNom_interpreteur();
             row[4]=list.get(i).getQuantité();
            model.addRow(row);
             }
             }
    private void TableMouseClicked( MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int i=Table.getSelectedRow();
        TableModel model=Table.getModel();
        PrixFiled.setText(model.getValueAt(i, 4).toString());
        IDFiled.setText(model.getValueAt(i, 0).toString());
        CopieFiled.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_TableMouseClicked

    private void RechercheFiledActionPerformed( ActionEvent evt) {//GEN-FIRST:event_RechercheFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RechercheFiledActionPerformed

    private void BtnRechercheActionPerformed( ActionEvent evt) {//GEN-FIRST:event_BtnRechercheActionPerformed
         DefaultTableModel model=(DefaultTableModel)Table.getModel(); 
           model.setRowCount(0);
           CD cd= new CD();
         cd.setNom_album(RechercheFiled.getText());
         List<CD> list = new ArrayList<CD>();
         try {
			list=daocd.findBy(cd, DAOImpCD.NOM_ALBUM);
                        Object[] row=new Object[6];
			for(int i=0;i<list.size();i++){
			    row[0]=list.get(i).getId();
                            row[1]=list.get(i).getNom_album();
                            row[2]=list.get(i).getNom_editeur();
                             row[3]=list.get(i).getNom_interpreteur();
                            row[4]=list.get(i).getQuantité();
                            model.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_BtnRechercheActionPerformed

    private void BtnAjouterActionPerformed( ActionEvent evt) {//GEN-FIRST:event_BtnAjouterActionPerformed
    	if(EditeurFiled.getText().equals("")||AlbumFiled.getText().equals("")||PrixFiled.getText().equals("")||CopieFiled.getText().equals("")||InterpreteurFiled.getText().equals("")){
            JOptionPane.showMessageDialog(null, "vous devez remplir tous les champs");
        } else {
    	DefaultTableModel model=(DefaultTableModel)Table.getModel();
       CD cd = new CD(AlbumFiled.getText(), InterpreteurFiled.getText(),EditeurFiled.getText(), Integer.parseInt(CopieFiled.getText()));
       doc.AjouterDoc(cd);
       model.setRowCount(0);
       AfficherCd(); }       
    }//GEN-LAST:event_BtnAjouterActionPerformed

    private void IDFiledActionPerformed( ActionEvent evt) {//GEN-FIRST:event_IDFiledActionPerformed

    }//GEN-LAST:event_IDFiledActionPerformed

    private void EditeurFiledActionPerformed( ActionEvent evt) {//GEN-FIRST:event_EditeurFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditeurFiledActionPerformed

    private void InterpreteurFiledActionPerformed( ActionEvent evt) {//GEN-FIRST:event_InterpreteurFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InterpreteurFiledActionPerformed

    private void PrixFiledActionPerformed( ActionEvent evt) {//GEN-FIRST:event_PrixFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrixFiledActionPerformed

    private void resetActionPerformed( ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
      IDFiled.setText("");
      AlbumFiled.setText("");
      InterpreteurFiled.setText("");
      PrixFiled.setText("");
      CopieFiled.setText("");
      EditeurFiled.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void BtnSupprimerActionPerformed( ActionEvent evt) {//GEN-FIRST:event_BtnSupprimerActionPerformed
        try {
            CD l=new CD();
            l.setId((long)(Integer.parseInt( IDFiled.getText())));
            daocd.delete(l);
            DefaultTableModel model=(DefaultTableModel)Table.getModel(); 
            model.setRowCount(0);
            AfficherCd();
        } catch (Exception ex) {
            ex.printStackTrace();
        }       
    }//GEN-LAST:event_BtnSupprimerActionPerformed

    private void AlbumFiledActionPerformed( ActionEvent evt) {//GEN-FIRST:event_AlbumFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlbumFiledActionPerformed

    private void btnAfficherActionPerformed( ActionEvent evt) {//GEN-FIRST:event_btnAfficherActionPerformed
    	DefaultTableModel model=(DefaultTableModel)Table.getModel();
        model.setRowCount(0);
        AfficherCd();
    }//GEN-LAST:event_btnAfficherActionPerformed

    private void BtnModifierActionPerformed( ActionEvent evt) {//GEN-FIRST:event_BtnModifierActionPerformed
    	if(IDFiled.getText().equals("")||PrixFiled.getText().equals("")||CopieFiled.getText().equals("")){
            JOptionPane.showMessageDialog(null, "vous devez selectioner un CD");
        }else {
        	CD cd= new CD();
            cd.setId((long)(Integer.parseInt(IDFiled.getText())));
            cd.setQuantité(Integer.parseInt(CopieFiled.getText()));
            try {
                daocd.update(cd);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            DefaultTableModel model=(DefaultTableModel)Table.getModel();
            model.setRowCount(0);
            AfficherCd(); 	
        } 
    	 
    }//GEN-LAST:event_BtnModifierActionPerformed

    private void retourActionPerformed( ActionEvent evt) {//GEN-FIRST:event_retourActionPerformed
               GestionDoc p= new GestionDoc();
               setVisible(false);
               p.setVisible(true);
               p.setSize(1200, 550);     
    }//GEN-LAST:event_retourActionPerformed

    private void CopieFiledActionPerformed( ActionEvent evt) {//GEN-FIRST:event_CopieFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CopieFiledActionPerformed

    private void retourMenuActionPerformed( ActionEvent evt) {//GEN-FIRST:event_retourMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retourMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for ( UIManager.LookAndFeelInfo info :  UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                     UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(GestionCd.class.getName()).log( Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
             Logger.getLogger(GestionCd.class.getName()).log( Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
             Logger.getLogger(GestionCd.class.getName()).log( Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
             Logger.getLogger(GestionCd.class.getName()).log( Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCd().setVisible(true);
            }
        });
    }
    private  JTextField AlbumFiled;
    private  JLabel AuteurText;
    private  JButton BtnAjouter;
    private  JButton BtnModifier;
    private  JButton BtnRecherche;
    private  JButton BtnSupprimer;
    private  JTextField CopieFiled;
    private  JTextField EditeurFiled;
    private  JTextField IDFiled;
    private  JTextField InterpreteurFiled;
    private  JTextField PrixFiled;
    private  JTextField RechercheFiled;
    private  JTable Table;
    private  JLabel TitreText;
    private  JLabel TitreText1;
    private  JButton btnAfficher;
    private  JLabel jLabel1;
    private  JLabel jLabel4;
    private  JLabel jLabel5;
    private  JLabel jLabel8;
    private  JPanel jPanel1;
    private  JPanel jPanel2;
    private  JScrollPane jScrollPane1;
    private  JButton reset;
    private  JButton retour;
    private  JButton retourMenu;
    // End of variables declaration//GEN-END:variables
}
