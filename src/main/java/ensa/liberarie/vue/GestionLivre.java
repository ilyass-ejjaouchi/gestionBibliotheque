package ensa.liberarie.vue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ensa.liberarie.dao.daoImp.DAOImpLivre;
import ensa.liberarie.entities.Livre;
import ensa.liberarie.entities.Provenance;
import ensa.liberarie.metier.MetierDocImp;
import liberarie.dao.daoImp.DAOImpProvenance;
public class GestionLivre extends javax.swing.JFrame {

    public GestionLivre() {
        initComponents();
           List<Provenance> list = new ArrayList<Provenance>();
		try {
			list=daoP.findBy(null, DAOImpProvenance.LISTE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++){
                    PrevanaceItem.addItem(list.get(i).getNom());
		
		}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TitreText = new javax.swing.JLabel();
        AuteurText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtnAjouter = new javax.swing.JButton();
        IDFiled = new javax.swing.JTextField();
        AuteurFiled = new javax.swing.JTextField();
        NbrPageFiled = new javax.swing.JTextField();
        PrixFiled = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        CopieFiled = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PrevanaceItem = new javax.swing.JComboBox<>();
        BtnSupprimer = new javax.swing.JButton();
        TitreText1 = new javax.swing.JLabel();
        TitreFiled = new javax.swing.JTextField();
        BtnNvProvenance = new javax.swing.JButton();
        btnAfficher = new javax.swing.JButton();
        BtnModifier = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        RechercheFiled = new javax.swing.JTextField();
        BtnRecherche = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel1.setText("Gestion des livres");

        TitreText.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        TitreText.setText("Titre:");

        AuteurText.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        AuteurText.setText("Auteur:");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setText("nbr de page:");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setText("Prix:");

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel7.setText("Provenance:");

        BtnAjouter.setIcon(new javax.swing.ImageIcon("F:\\studies\\book-with-add-button.png")); // NOI18N
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

        AuteurFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuteurFiledActionPerformed(evt);
            }
        });

        NbrPageFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbrPageFiledActionPerformed(evt);
            }
        });

        PrixFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrixFiledActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaprojet/reset.png"))); // NOI18N
        jButton1.setText("Reinistialiser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CopieFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopieFiledActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel8.setText("Nombre de Copie:");

        PrevanaceItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        BtnSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaprojet/remove-book-button.png"))); // NOI18N
        BtnSupprimer.setText("Supprimer");
        BtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSupprimerActionPerformed(evt);
            }
        });

        TitreText1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        TitreText1.setText("ID:");

        TitreFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitreFiledActionPerformed(evt);
            }
        });

        BtnNvProvenance.setIcon(new javax.swing.ImageIcon("F:\\studies\\plus.png")); // NOI18N
        BtnNvProvenance.setText("nouveau");
        BtnNvProvenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNvProvenanceActionPerformed(evt);
            }
        });

        btnAfficher.setIcon(new javax.swing.ImageIcon("F:\\studies\\books-stack-of-three.png")); // NOI18N
        btnAfficher.setText("Afficher");
        btnAfficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfficherActionPerformed(evt);
            }
        });

        BtnModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaprojet/phonebook.png"))); // NOI18N
        BtnModifier.setText("Modifier");
        BtnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnAfficher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAjouter)
                .addGap(18, 18, 18)
                .addComponent(BtnModifier)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitreText1)
                            .addComponent(AuteurText)
                            .addComponent(jLabel4)
                            .addComponent(TitreText)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PrixFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NbrPageFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AuteurFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TitreFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IDFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(CopieFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PrevanaceItem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnNvProvenance)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSupprimer)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText1)
                    .addComponent(IDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitreText)
                    .addComponent(TitreFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuteurText)
                    .addComponent(AuteurFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NbrPageFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrixFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PrevanaceItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNvProvenance))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CopieFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAfficher)
                    .addComponent(BtnAjouter)
                    .addComponent(BtnModifier))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(BtnSupprimer))
                .addGap(33, 33, 33))
        );

        Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Table.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titre", "Auteur", "nbr de page", "prix", "provenence", "Type de prevenance", "copie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true, true
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        RechercheFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercheFiledActionPerformed(evt);
            }
        });

        BtnRecherche.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BtnRecherche.setIcon(new javax.swing.ImageIcon("F:\\studies\\magnifier .png")); // NOI18N
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(RechercheFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RechercheFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        retour.setIcon(new javax.swing.ImageIcon("F:\\studies\\reply (1).png")); // NOI18N
        retour.setText("Retour");
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("F:\\studies\\listLivre.png")); // NOI18N
        jButton2.setText("retour au menu principal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(retour)
                        .addGap(47, 47, 47)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(retour)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     MetierDocImp doc=new MetierDocImp(0);
     DAOImpProvenance daoP= new DAOImpProvenance();
     DAOImpLivre daoLv= new DAOImpLivre();
    private void BtnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouterActionPerformed
        if(TitreFiled.getText().equals("")||AuteurFiled.getText().equals("")||PrixFiled.getText().equals("")||CopieFiled.getText().equals("")||NbrPageFiled.getText().equals("")||PrevanaceItem.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "vous devez remplir tous les champs");
        } 
        else{
        DefaultTableModel model=(DefaultTableModel)Table.getModel();        
        Provenance pr=new Provenance(PrevanaceItem.getSelectedItem().toString());
      List<Provenance> list = new ArrayList<Provenance>();
        try {
            list=daoP.findBy(pr, DAOImpProvenance.ProvenanceNom);
            pr.setId(list.get(0).getId());
        } catch (Exception ex) {
           ex.printStackTrace();
        }
     Livre l=new Livre(TitreFiled.getText(),Integer.parseInt(NbrPageFiled.getText()),Double.parseDouble(PrixFiled.getText()), AuteurFiled.getText(), pr,Integer.parseInt(CopieFiled.getText()));
     doc.AjouterDoc(l);
     model.setRowCount(0);
     AfficherLivre();
     reset(); 
     CopieFiled.setText("");
     PrixFiled.setText("");
        }
    }//GEN-LAST:event_BtnAjouterActionPerformed

    private void IDFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFiledActionPerformed
    }//GEN-LAST:event_IDFiledActionPerformed

    private void AuteurFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuteurFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuteurFiledActionPerformed

    private void NbrPageFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbrPageFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NbrPageFiledActionPerformed

    private void PrixFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrixFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrixFiledActionPerformed

    private void RechercheFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercheFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RechercheFiledActionPerformed

    private void BtnRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRechercheActionPerformed
               DefaultTableModel model=(DefaultTableModel)Table.getModel(); 
               model.setRowCount(0);
       Livre l= new Livre();
         l.setTitre(RechercheFiled.getText());
         List<Livre> list = new ArrayList<Livre>();
         try {
			list=daoLv.findBy(l, DAOImpLivre.TITRE);
                        Object[] row=new Object[8];
			for(int i=0;i<list.size();i++){
			    row[0]=list.get(i).getId();
                            row[1]=list.get(i).getTitre(); 
                            row[2]=list.get(i).getAuteur();          
                             row[3]=list.get(i).getNbr_page();
                             row[4]=list.get(i).getPrix();
                 try {
                             Long idd=daoLv.FindIdProvenance(list.get(i));
                            Provenance p=new Provenance(idd);
                            List<Provenance> list2 = new ArrayList<Provenance>();
                            list2=daoP.findBy(p,DAOImpProvenance.LISTE_ID);
                             row[5]=list2.get(0).getNom();
                             row[6]=list2.get(0).getType();
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                 row[7]=list.get(0).getNbr();
         model.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_BtnRechercheActionPerformed
   public void AfficherLivre(){
       List<Livre>list= (List<Livre>) doc.TrouverDoc(null,DAOImpLivre.LISTE);
             DefaultTableModel model=(DefaultTableModel)Table.getModel();
             Object[] row=new Object[8];
             for(int i=0;i<list.size();i++){
             row[0]=list.get(i).getId();
             row[1]=list.get(i).getTitre();
             row[2]=list.get(i).getAuteur();          
            row[3]=list.get(i).getNbr_page();
            row[4]=list.get(i).getPrix();
                 try {
                     Long idd=daoLv.FindIdProvenance(list.get(i));
                     Provenance p=new Provenance(idd);
		     List<Provenance> list2 = new ArrayList<Provenance>();
		      list2=daoP.findBy(p,DAOImpProvenance.LISTE_ID);
                      row[5]=list2.get(0).getNom();
                      row[6]=list2.get(0).getType();
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                 row[7]=list.get(i).getNbr();
         model.addRow(row);
             }
             }
    private void btnAfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfficherActionPerformed
        DefaultTableModel model=(DefaultTableModel)Table.getModel(); 
         model.setRowCount(0);
        AfficherLivre(); 
    }//GEN-LAST:event_btnAfficherActionPerformed

    private void retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourActionPerformed
              GestionDoc p= new GestionDoc();
               setVisible(false);
               p.setVisible(true);
               p.setSize(1200, 500);
    }//GEN-LAST:event_retourActionPerformed
      public void reset(){
      IDFiled.setText("");
        AuteurFiled.setText("");
        NbrPageFiled.setText("");
        PrixFiled.setText("");
        TitreFiled.setText("");
      }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       reset(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked

        int i=Table.getSelectedRow();
        TableModel model=Table.getModel();
        PrixFiled.setText(model.getValueAt(i, 4).toString());
        CopieFiled.setText(model.getValueAt(i, 7).toString());
        IDFiled.setText(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_TableMouseClicked

    private void CopieFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopieFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CopieFiledActionPerformed
    
    private void BtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupprimerActionPerformed
        try {
            Livre l=new Livre();
            l.setId((long)(Integer.parseInt( IDFiled.getText())));
            Provenance p=new Provenance();
            p.setId(daoLv.FindIdProvenance(l));
            l.setProv(p);
            daoLv.delete(l);
            DefaultTableModel model=(DefaultTableModel)Table.getModel(); 
            model.setRowCount(0);
            AfficherLivre();
            reset();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //ViderTableau();
    }//GEN-LAST:event_BtnSupprimerActionPerformed

    private void TitreFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitreFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitreFiledActionPerformed

    private void BtnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModifierActionPerformed
        if(IDFiled.getText().equals("")||PrixFiled.getText().equals("")||CopieFiled.getText().equals("")){
            JOptionPane.showMessageDialog(null, "vous devez selectioner un livre");
        } 
        else{
        Livre l= new Livre();
        l.setId((long)(Integer.parseInt(IDFiled.getText())));
        l.setPrix(Double.parseDouble(PrixFiled.getText()));
        l.setNbr(Integer.parseInt(CopieFiled.getText()));
        try {
            daoLv.update(l);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DefaultTableModel model=(DefaultTableModel)Table.getModel();
        model.setRowCount(0);
        AfficherLivre();
        reset();
        }
    }//GEN-LAST:event_BtnModifierActionPerformed
    
    private void BtnNvProvenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNvProvenanceActionPerformed
               AddProvenance p= new AddProvenance();
               setVisible(false);
               p.setVisible(true);
               p.setSize(1200, 500);
    }//GEN-LAST:event_BtnNvProvenanceActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionLivre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AuteurFiled;
    private javax.swing.JLabel AuteurText;
    private javax.swing.JButton BtnAjouter;
    private javax.swing.JButton BtnModifier;
    private javax.swing.JButton BtnNvProvenance;
    private javax.swing.JButton BtnRecherche;
    private javax.swing.JButton BtnSupprimer;
    private javax.swing.JTextField CopieFiled;
    private javax.swing.JTextField IDFiled;
    private javax.swing.JTextField NbrPageFiled;
    private javax.swing.JComboBox<String> PrevanaceItem;
    private javax.swing.JTextField PrixFiled;
    private javax.swing.JTextField RechercheFiled;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TitreFiled;
    private javax.swing.JLabel TitreText;
    private javax.swing.JLabel TitreText1;
    private javax.swing.JButton btnAfficher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton retour;
    // End of variables declaration//GEN-END:variables
}
