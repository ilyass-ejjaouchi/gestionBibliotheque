/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensa.liberarie.vue;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import liberarie.dao.daoImp.DAOImpDVD;
import liberarie.entities.DVD;
import liberarie.metier.MetierDocImp;

/**
 *
 * @author IYASS
 */
public class GestionDVD extends javax.swing.JFrame {

    /**
     * Creates new form GestionDVD
     */
    public GestionDVD() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        RechercheFiled = new javax.swing.JTextField();
        BtnRecherche = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TitreText = new javax.swing.JLabel();
        AuteurText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnAjouter = new javax.swing.JButton();
        IDFiled = new javax.swing.JTextField();
        EditeurFiled = new javax.swing.JTextField();
        ProducteurFiled = new javax.swing.JTextField();
        PrixFiled = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        BtnSupprimer = new javax.swing.JButton();
        TitreText1 = new javax.swing.JLabel();
        FilmFiled = new javax.swing.JTextField();
        btnAfficher = new javax.swing.JButton();
        BtnModifier = new javax.swing.JButton();
        retourMenu = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CopieFiled = new javax.swing.JTextField();
        RealisateurFiled = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Table.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom Film", "Nom Editeur", "Nom producteur", "Nom Realisateur", "Prix", "Copie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        RechercheFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercheFiledActionPerformed(evt);
            }
        });

        BtnRecherche.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BtnRecherche.setIcon(new javax.swing.ImageIcon("F:\\studies\\magnifierD.png")); // NOI18N
        BtnRecherche.setText("Recherche");
        BtnRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRechercheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addComponent(RechercheFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RechercheFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel1.setText("Gestion des DVD");

        TitreText.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        TitreText.setText("Nom film:");

        AuteurText.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        AuteurText.setText("Nom Editeur:");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setText("Nom producteur:");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setText("Prix:");

        BtnAjouter.setIcon(new javax.swing.ImageIcon("F:\\studies\\release.png")); // NOI18N
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

        EditeurFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditeurFiledActionPerformed(evt);
            }
        });

        ProducteurFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProducteurFiledActionPerformed(evt);
            }
        });

        PrixFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrixFiledActionPerformed(evt);
            }
        });

        reset.setIcon(new javax.swing.ImageIcon("F:\\studies\\restore.png")); // NOI18N
        reset.setText("Reinistialiser");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        BtnSupprimer.setIcon(new javax.swing.ImageIcon("F:\\studies\\album (1).png")); // NOI18N
        BtnSupprimer.setText("Supprimer");
        BtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSupprimerActionPerformed(evt);
            }
        });

        TitreText1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        TitreText1.setText("ID:");

        FilmFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilmFiledActionPerformed(evt);
            }
        });

        btnAfficher.setIcon(new javax.swing.ImageIcon("F:\\studies\\listDVD.png")); // NOI18N
        btnAfficher.setText("Afficher");
        btnAfficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfficherActionPerformed(evt);
            }
        });

        BtnModifier.setIcon(new javax.swing.ImageIcon("F:\\studies\\modifierDVD.png")); // NOI18N
        BtnModifier.setText("Modifier");
        BtnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModifierActionPerformed(evt);
            }
        });

        retourMenu.setIcon(new javax.swing.ImageIcon("F:\\studies\\listCD.png")); // NOI18N
        retourMenu.setText("retour au menu principal");

        retour.setIcon(new javax.swing.ImageIcon("F:\\studies\\reply.png")); // NOI18N
        retour.setText("Retour");
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel8.setText("Nombre de Copie:");

        CopieFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopieFiledActionPerformed(evt);
            }
        });

        RealisateurFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealisateurFiledActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel6.setText("Nom realisateur:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(retour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(retourMenu)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAfficher)
                                .addGap(36, 36, 36)
                                .addComponent(BtnAjouter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnModifier))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(reset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnSupprimer)
                                .addGap(21, 21, 21)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitreText1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AuteurText)
                                    .addComponent(jLabel4)
                                    .addComponent(TitreText)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PrixFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ProducteurFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EditeurFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FilmFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IDFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(RealisateurFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CopieFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retourMenu)
                    .addComponent(retour))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText1)
                    .addComponent(IDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText)
                    .addComponent(FilmFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuteurText)
                    .addComponent(EditeurFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ProducteurFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(RealisateurFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrixFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CopieFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModifier)
                    .addComponent(BtnAjouter)
                    .addComponent(btnAfficher))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSupprimer)
                    .addComponent(reset))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1052, 1052, 1052))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int i=Table.getSelectedRow();
        TableModel model=Table.getModel();
        PrixFiled.setText(model.getValueAt(i, 5).toString());
        IDFiled.setText(model.getValueAt(i, 0).toString());
        CopieFiled.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_TableMouseClicked

    private void RechercheFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercheFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RechercheFiledActionPerformed

    private void BtnRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRechercheActionPerformed
        DefaultTableModel model=(DefaultTableModel)Table.getModel();
        model.setRowCount(0);
        DVD cd= new DVD();
        cd.setNom_film(RechercheFiled.getText());
        List<DVD> list = new ArrayList<DVD>();
        try {
            list=daodvd.findBy(cd, DAOImpDVD.NOM_FILM);
            Object[] row=new Object[7];
            for(int i=0;i<list.size();i++){
                row[0]=list.get(i).getId();
                row[1]=list.get(i).getNom_film();
                row[2]=list.get(i).getNom_editeur();
                row[3]=list.get(i).getNom_producteur();
                row[4]=list.get(i).getNom_realisateur();
                row[5]=list.get(i).getPrix();
                row[6]=list.get(i).getNbr();
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnRechercheActionPerformed
      public void AfficherDVD(){
       List<DVD>list= (List<DVD>)doc.TrouverDoc(null,DAOImpDVD.LIST);
             DefaultTableModel model=(DefaultTableModel)Table.getModel();
             Object[] row=new Object[8];
             for(int i=0;i<list.size();i++){
             row[0]=list.get(i).getId();
             row[1]=list.get(i).getNom_film();
             row[2]=list.get(i).getNom_editeur();          
             row[3]=list.get(i).getNom_producteur();
             row[4]=list.get(i).getNom_realisateur();
             row[5]=list.get(i).getPrix();
             row[6]=list.get(i).getNbr();
            model.addRow(row);
            System.out.println("get it ");
             }
             }
    private void BtnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouterActionPerformed
    	if(EditeurFiled.getText().equals("")||FilmFiled.getText().equals("")||PrixFiled.getText().equals("")||CopieFiled.getText().equals("")||ProducteurFiled.getText().equals("")||RealisateurFiled.getText().equals("")){
            JOptionPane.showMessageDialog(null, "vous devez remplir tous les champs");
        } else {
        	DefaultTableModel model=(DefaultTableModel)Table.getModel();
            DVD dvd= new DVD(FilmFiled.getText(),RealisateurFiled.getText(), ProducteurFiled.getText(), EditeurFiled.getText(),Double.parseDouble(PrixFiled.getText()), Integer.parseInt(CopieFiled.getText()));
            doc.AjouterDoc(dvd);
            model.setRowCount(0);
            AfficherDVD();
        }
    	
    }//GEN-LAST:event_BtnAjouterActionPerformed

    private void IDFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFiledActionPerformed

    }//GEN-LAST:event_IDFiledActionPerformed

    private void EditeurFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditeurFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditeurFiledActionPerformed

    private void ProducteurFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProducteurFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProducteurFiledActionPerformed

    private void PrixFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrixFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrixFiledActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        IDFiled.setText("");
        FilmFiled.setText("");
        ProducteurFiled.setText("");
        PrixFiled.setText("");
        CopieFiled.setText("");
        EditeurFiled.setText("");
    }//GEN-LAST:event_resetActionPerformed
     DAOImpDVD daodvd= new DAOImpDVD();
     MetierDocImp doc=new MetierDocImp(2);
    private void BtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupprimerActionPerformed
        try {
            DVD l=new DVD();
            l.setId((long)(Integer.parseInt( IDFiled.getText())));
            daodvd.delete(l);
            DefaultTableModel model=(DefaultTableModel)Table.getModel();
            model.setRowCount(0);
            AfficherDVD();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_BtnSupprimerActionPerformed

    private void FilmFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilmFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilmFiledActionPerformed

    private void btnAfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfficherActionPerformed
        DefaultTableModel model=(DefaultTableModel)Table.getModel();
        model.setRowCount(0);
        AfficherDVD();
    }//GEN-LAST:event_btnAfficherActionPerformed

    private void BtnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModifierActionPerformed
    	if(IDFiled.getText().equals("")||PrixFiled.getText().equals("")||CopieFiled.getText().equals("")){
            JOptionPane.showMessageDialog(null, "vous devez selectioner un livre");
        } else {
        	DVD dvd= new DVD();
            dvd.setId((long)(Integer.parseInt(IDFiled.getText())));
            dvd.setPrix(Double.parseDouble(PrixFiled.getText()));
            dvd.setNbr(Integer.parseInt(CopieFiled.getText()));
            try {
                daodvd.update(dvd);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            DefaultTableModel model=(DefaultTableModel)Table.getModel();
            model.setRowCount(0);
            AfficherDVD();
        }
    	
    }//GEN-LAST:event_BtnModifierActionPerformed

    private void retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourActionPerformed
        GestionDoc p= new GestionDoc();
        setVisible(false);
        p.setVisible(true);
        p.setSize(1200, 500);
    }//GEN-LAST:event_retourActionPerformed

    private void CopieFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopieFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CopieFiledActionPerformed

    private void RealisateurFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealisateurFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RealisateurFiledActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDVD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuteurText;
    private javax.swing.JButton BtnAjouter;
    private javax.swing.JButton BtnModifier;
    private javax.swing.JButton BtnRecherche;
    private javax.swing.JButton BtnSupprimer;
    private javax.swing.JTextField CopieFiled;
    private javax.swing.JTextField EditeurFiled;
    private javax.swing.JTextField FilmFiled;
    private javax.swing.JTextField IDFiled;
    private javax.swing.JTextField PrixFiled;
    private javax.swing.JTextField ProducteurFiled;
    private javax.swing.JTextField RealisateurFiled;
    private javax.swing.JTextField RechercheFiled;
    private javax.swing.JTable Table;
    private javax.swing.JLabel TitreText;
    private javax.swing.JLabel TitreText1;
    private javax.swing.JButton btnAfficher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    private javax.swing.JButton retour;
    private javax.swing.JButton retourMenu;
    // End of variables declaration//GEN-END:variables
}
