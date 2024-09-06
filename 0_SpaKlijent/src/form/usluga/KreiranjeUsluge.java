/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.usluga;

import controller.ClientController;
import domain.NapomenaZaUslugu;
import domain.TipNapomeneZaUslugu;
import domain.Usluga;
import domain.VrstaUsluge;
import form.napomena.UnosNapomene;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import models.napomena.TableModelNapomene;

/**
 *
 * @author Ivana
 */
public class KreiranjeUsluge extends javax.swing.JFrame {

    /**
     * Creates new form KreiranjeTermina
     */
    List<NapomenaZaUslugu> listaNapomena = new ArrayList<>();

    public KreiranjeUsluge() throws Exception {
        initComponents();
        popuniComboVrstaUsluge();
        TableModelNapomene model = new TableModelNapomene(listaNapomena);
        tblNapomena.setModel(model);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTrajanje = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbVrstaUsluge = new javax.swing.JComboBox();
        btnSacuvajUslugu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNapomena = new javax.swing.JTable();
        btnDodajNapomenu = new javax.swing.JButton();
        btnObrisiNapomenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kreiranje nove usluge");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Naziv:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Cena:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Trajanje:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Vrsta usluge:");

        btnSacuvajUslugu.setBackground(new java.awt.Color(153, 153, 255));
        btnSacuvajUslugu.setForeground(new java.awt.Color(255, 255, 255));
        btnSacuvajUslugu.setText("Kreiraj uslugu");
        btnSacuvajUslugu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajUsluguActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Napomene za uslugu"));

        tblNapomena.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblNapomena);

        btnDodajNapomenu.setBackground(new java.awt.Color(153, 153, 255));
        btnDodajNapomenu.setForeground(new java.awt.Color(255, 255, 255));
        btnDodajNapomenu.setText("Dodaj napomenu za uslugu");
        btnDodajNapomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNapomenuActionPerformed(evt);
            }
        });

        btnObrisiNapomenu.setBackground(new java.awt.Color(255, 102, 102));
        btnObrisiNapomenu.setForeground(new java.awt.Color(255, 255, 255));
        btnObrisiNapomenu.setText("Obriši napomenu za uslugu");
        btnObrisiNapomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiNapomenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDodajNapomenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiNapomenu))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajNapomenu)
                    .addComponent(btnObrisiNapomenu))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbVrstaUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTrajanje)
                                    .addComponent(txtCena)
                                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnSacuvajUslugu)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbVrstaUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvajUslugu)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajNapomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNapomenuActionPerformed
        try {

            UnosNapomene formaNapomena = new UnosNapomene();
            formaNapomena.setVisible(true);

            formaNapomena.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    List<NapomenaZaUslugu> privremeneNapomene = formaNapomena.getPrivremeneNapomene();
                    listaNapomena.addAll(privremeneNapomene);
                    TableModelNapomene model = new TableModelNapomene(listaNapomena);
                    tblNapomena.setModel(model);
                    ((AbstractTableModel) tblNapomena.getModel()).fireTableDataChanged();
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(KreiranjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajNapomenuActionPerformed

    private void btnObrisiNapomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiNapomenuActionPerformed
        int red = tblNapomena.getSelectedRow();
        if (red != -1) {
            NapomenaZaUslugu oznacenaNapomena = listaNapomena.get(red);
            listaNapomena.remove(oznacenaNapomena);
            TableModelNapomene model = new TableModelNapomene(listaNapomena);
            tblNapomena.setModel(model);
            ((AbstractTableModel) tblNapomena.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_btnObrisiNapomenuActionPerformed

    private void btnSacuvajUsluguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajUsluguActionPerformed
        try {
            String naziv = txtNaziv.getText();
            double cena = Double.parseDouble(txtCena.getText());
            int trajanje = Integer.parseInt(txtTrajanje.getText());
            VrstaUsluge vrstaUsluge = (VrstaUsluge) cbVrstaUsluge.getSelectedItem();

            Usluga usluga = new Usluga();
            usluga.setNazivUsluge(naziv);
            usluga.setCenaUsluge(cena);
            usluga.setTrajanjeUsluge(trajanje);
            usluga.setVrstaUsluge(vrstaUsluge);
            usluga.setNapomene(listaNapomena);

            Usluga u = ClientController.getInstance().addUsluga(usluga);

            JOptionPane.showMessageDialog(this, "Sistem je uspešno zapamtio uslugu.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            ocistiPolja();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti uslugu. Pokušajte ponovo!", "Greška", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(KreiranjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajUsluguActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajNapomenu;
    private javax.swing.JButton btnObrisiNapomenu;
    private javax.swing.JButton btnSacuvajUslugu;
    private javax.swing.JComboBox cbVrstaUsluge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNapomena;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTrajanje;
    // End of variables declaration//GEN-END:variables

    private void popuniComboVrstaUsluge() throws Exception {
        cbVrstaUsluge.addItem("Odaberite vrstu usluge");

        List<VrstaUsluge> listaVrstaUsluge = controller.ClientController.getInstance().getListVrstaUsluge();
        for (VrstaUsluge vrstaUsluge : listaVrstaUsluge) {
            cbVrstaUsluge.addItem(vrstaUsluge);
        }
    }

    private void ocistiPolja() {
        cbVrstaUsluge.setSelectedItem(null);
        txtCena.setText("");
        txtTrajanje.setText("");
        cbVrstaUsluge.setSelectedIndex(0);
        listaNapomena.clear();
        TableModelNapomene model = new TableModelNapomene(listaNapomena);
        tblNapomena.setModel(model);
        model.fireTableDataChanged();
    }

}
