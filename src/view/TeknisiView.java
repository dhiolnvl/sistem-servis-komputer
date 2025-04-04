/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.TeknisiController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import main.App;
import model.Teknisi;

/**
 *
 * @author ASUS
 */
public class TeknisiView extends javax.swing.JInternalFrame {
    
    private final Teknisi teknisi;
    private List<Teknisi> listTeknisi;
    private final TeknisiController teknisiController;

    /**
     * Creates new form TeknisiView
     */
    public TeknisiView() {
        initComponents();
        
        teknisi = new Teknisi();
        teknisiController = new TeknisiController(this);
        teknisiController.enableForm2(true);
        refreshTable();
        initListener();
        
    }
    
    public JTextField getTextId() {
        return textId;
    }

    public JTextField getTextNama() {
        return textNama;
    }
    
    public JTextField getTextNo() {
        return textNo;
    }
    
    public JComboBox getComboKeahlian() {
        return comboKeahlian;
    }

    public JButton getTombolHapus() {
        return tombolHapus;
    }

    public JButton getTombolSimpan() {
        return tombolSimpan;
    }

    public JButton getTombolUbah() {
        return tombolUbah;
    }

    public JTable getTabelTeknisi() {
        return tabelTeknisi;
    }
    
    private void refreshTable() {
        listTeknisi = App.masterService.getAllTeknisi(); // memanggil interface
        // memasukkan nilai list ke inner class
        tabelTeknisi.setModel(new TeknisiTableModel(listTeknisi));
    }
    
    private void initListener(){ // memindahkan nilai di tabel ke form
        tabelTeknisi.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            teknisiController.loadData(teknisi, listTeknisi);
        });
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboKeahlian = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        tombolSimpan = new javax.swing.JButton();
        tombolReset = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTeknisi = new javax.swing.JTable();

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

        setBackground(new java.awt.Color(0, 102, 255));
        setClosable(true);
        setTitle("Form Input Teknisi");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(127, 140, 141));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 10, 10));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Teknisi");
        jPanel1.add(jLabel1);

        textId.setBackground(new java.awt.Color(255, 255, 255));
        textId.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(textId);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");
        jPanel1.add(jLabel2);

        textNama.setBackground(new java.awt.Color(255, 255, 255));
        textNama.setForeground(new java.awt.Color(0, 0, 0));
        textNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaActionPerformed(evt);
            }
        });
        jPanel1.add(textNama);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No HP");
        jPanel1.add(jLabel3);

        textNo.setBackground(new java.awt.Color(255, 255, 255));
        textNo.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(textNo);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Keahlian");
        jPanel1.add(jLabel4);

        comboKeahlian.setForeground(new java.awt.Color(0, 0, 0));
        comboKeahlian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hardware", "Software", "Keduanya" }));
        comboKeahlian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKeahlianActionPerformed(evt);
            }
        });
        jPanel1.add(comboKeahlian);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(127, 140, 141));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tombolSimpan.setBackground(new java.awt.Color(52, 73, 94));
        tombolSimpan.setForeground(new java.awt.Color(255, 255, 255));
        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(tombolSimpan);

        tombolReset.setBackground(new java.awt.Color(52, 73, 94));
        tombolReset.setForeground(new java.awt.Color(255, 255, 255));
        tombolReset.setText("Reset");
        tombolReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolResetActionPerformed(evt);
            }
        });
        jPanel2.add(tombolReset);

        tombolUbah.setBackground(new java.awt.Color(52, 73, 94));
        tombolUbah.setForeground(new java.awt.Color(255, 255, 255));
        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });
        jPanel2.add(tombolUbah);

        tombolHapus.setBackground(new java.awt.Color(52, 73, 94));
        tombolHapus.setForeground(new java.awt.Color(255, 255, 255));
        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });
        jPanel2.add(tombolHapus);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(127, 140, 141));

        jScrollPane3.setBackground(new java.awt.Color(127, 140, 141));

        tabelTeknisi.setBackground(new java.awt.Color(255, 255, 255));
        tabelTeknisi.setForeground(new java.awt.Color(0, 0, 0));
        tabelTeknisi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelTeknisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTeknisiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelTeknisi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        
            teknisi.setId(textId.getText());
            int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi", JOptionPane.WARNING_MESSAGE);
            if(konfirmasi==0){
                App.masterService.hapusTeknisi(teknisi);
                JOptionPane.showMessageDialog(this, "Data teknisi berhasil dihapus !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
                teknisiController.clearForm();
            }
            
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
            if (!teknisiController.validasiKode(textId.getText())) {
            return;
            }
            if (teknisiController.validasiInput()) {
            teknisi.setId(textId.getText());
            teknisi.setNama(textNama.getText());
            teknisi.setNoHp(textNo.getText());
            String selectedValue = (String) comboKeahlian.getSelectedItem();
            teknisi.setKeahlian(comboKeahlian.getSelectedItem().toString());

            App.masterService.simpanTeknisi(teknisi);
            JOptionPane.showMessageDialog(this, "Data teknisi berhasil disimpan !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
            
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        App.menuView.teknisiView = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        
        if (teknisiController.validasiInput()) {
            teknisi.setId(textId.getText());
            teknisi.setNama(textNama.getText());
            teknisi.setNoHp(textNo.getText());
            String selectedValue = (String) comboKeahlian.getSelectedItem();
            teknisi.setKeahlian(comboKeahlian.getSelectedItem().toString());

            App.masterService.ubahTeknisi(teknisi);
            JOptionPane.showMessageDialog(this, "Data teknisi berhasil diubah !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolResetActionPerformed
        // TODO add your handling code here:
        teknisiController.clearForm();
        teknisiController.enableForm2(true);
        
    }//GEN-LAST:event_tombolResetActionPerformed

    private void comboKeahlianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKeahlianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKeahlianActionPerformed

    private void tabelTeknisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTeknisiMouseClicked
        // TODO add your handling code here:
        teknisiController.enableForm(true);
    }//GEN-LAST:event_tabelTeknisiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboKeahlian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelTeknisi;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNo;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolReset;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables

    public class TeknisiTableModel extends AbstractTableModel {

        private List<Teknisi> listTeknisi = new ArrayList<>();

        private final String HEADER[] = {"ID Teknisi", "Nama", "No HP", "Keahlian"};

        public TeknisiTableModel(List<Teknisi> listTeknisi) {
            this.listTeknisi = listTeknisi;
        }

        @Override
        public int getRowCount() { // jumlah baris
            return listTeknisi.size();
        }

        @Override
        public int getColumnCount() { // jumlah kolom
            return HEADER.length;
        }

        @Override
        public String getColumnName(int i) { // nama kolom
            return HEADER[i];
        }

        @Override
        public Object getValueAt(int i, int i1) { // mengisi data
            Teknisi t = listTeknisi.get(i); // baris
            switch (i1) { // kolom
                case 0:
                    return t.getId();
                case 1:
                    return t.getNama();
                case 2:
                    return t.getNoHp();
                case 3:
                    return t.getKeahlian();
                default:
                    return null;
            }
        }
    }
}
