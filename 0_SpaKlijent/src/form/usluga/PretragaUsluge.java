/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.usluga;

import controller.ClientController;
import domain.NapomenaZaUslugu;
import domain.Usluga;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import models.napomena.TableModelNapomene;
import models.usluga.TableModelUsluge;

/**
 *
 * @author Ivana
 */
public class PretragaUsluge extends javax.swing.JFrame {

    List<NapomenaZaUslugu> napomene;

    public PretragaUsluge() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ClientController.getInstance().setPu(this);
        refreshTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsluga2 = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pretraga usluge");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Naziv usluge:");

        btnPretrazi.setBackground(new java.awt.Color(153, 153, 255));
        btnPretrazi.setForeground(new java.awt.Color(255, 255, 255));
        btnPretrazi.setText("Pretrazi ");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        tblUsluga2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblUsluga2);

        btnDetalji.setBackground(new java.awt.Color(153, 153, 255));
        btnDetalji.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalji.setText("Detalji usluge");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPretrazi))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnDetalji)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnDetalji)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String pretragaNaziv = txtNaziv.getText().toLowerCase().trim();

        if (pretragaNaziv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Unesite naziv usluge za pretragu!");
            return;
        }

        try {
            List<Usluga> filtriraneUsluge = ClientController.getInstance().getListUsluga(pretragaNaziv);
            TableModelUsluge tmu = (TableModelUsluge) tblUsluga2.getModel();
            if (filtriraneUsluge.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da nadje uslugе po zadatom kriterijumu.", "Greška", JOptionPane.ERROR_MESSAGE);
                tmu.setUsluge(filtriraneUsluge);
            } else {
                tmu.setUsluge(filtriraneUsluge);
                JOptionPane.showMessageDialog(this, "Sistem je pronašao usluge na osnovu unete vrednosti!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            }
            tmu.fireTableDataChanged();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nadje uslugе po zadatom kriterijumu.", "Greška", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed

        TableModelUsluge tmu = (TableModelUsluge) tblUsluga2.getModel();
        int red = tblUsluga2.getSelectedRow();

        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Molim Vas selektujte red!");
        } else {
            try {
                int modelRed = tblUsluga2.convertRowIndexToModel(red);

                Usluga usluga = tmu.vratiNaOsnovuReda(modelRed);
                JOptionPane.showMessageDialog(this, "Sistem je ucitao uslugu!");

                napomene = controller.ClientController.getInstance().getListNapomenaPoUsluzi(usluga);
                DetaljiUsluge detaljiForma = new DetaljiUsluge(usluga, napomene, this);
                detaljiForma.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(PretragaUsluge.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Sistem ne može da učita uslugu", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

    }//GEN-LAST:event_btnDetaljiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblUsluga2;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    public void refreshTable() {
        try {
            List<Usluga> sveUsluge = ClientController.getInstance().getListUsluga();
            TableModelUsluge tmu = new TableModelUsluge(sveUsluge);
            tblUsluga2.setModel(tmu);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Došlo je do greške prilikom osvežavanja tabele: " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
