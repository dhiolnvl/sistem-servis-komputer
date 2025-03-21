/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import config.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Teknisi;
import view.TeknisiView;

/**
 *
 * @author ASUS
 */
public class TeknisiController {
    
    private final TeknisiView teknisiView;
    Koneksi k;
    
    public TeknisiController(TeknisiView teknisiView) {
        this.teknisiView = teknisiView;
        k = new Koneksi();
    }
    
    public void clearForm(){
        teknisiView.getTextId().setText(null);
        teknisiView.getTextNama().setText(null);
        teknisiView.getTextNo().setText(null);
        teknisiView.getComboKeahlian().setSelectedIndex(0);
        teknisiView.getTabelTeknisi().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        teknisiView.getTextId().setEnabled(!kondisi);
        teknisiView.getTextNama().setEnabled(kondisi);
        teknisiView.getTextNo().setEnabled(kondisi);
        teknisiView.getComboKeahlian().setEnabled(kondisi);
        teknisiView.getTombolSimpan().setEnabled(!kondisi);
        teknisiView.getTombolUbah().setEnabled(kondisi);
        teknisiView.getTombolHapus().setEnabled(kondisi);
    }
    public void enableForm2(boolean kondisi){
        teknisiView.getTextId().setEnabled(kondisi);
        teknisiView.getTextNama().setEnabled(kondisi);
        teknisiView.getTextNo().setEnabled(kondisi);
        teknisiView.getComboKeahlian().setEnabled(kondisi);
        teknisiView.getTombolSimpan().setEnabled(kondisi);
        teknisiView.getTombolUbah().setEnabled(!kondisi);
        teknisiView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        String no = teknisiView.getTextNo().getText();
        if(teknisiView.getTextId().getText().isEmpty() || teknisiView.getTextNama().getText().isEmpty() || teknisiView.getTextNo().getText().isEmpty()){
            JOptionPane.showMessageDialog(teknisiView, "Harus diisi Semua !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!no.matches("\\d{12,13}")) {
            JOptionPane.showMessageDialog(teknisiView, "Nomor hanya boleh angka dan maksimal 13 karakter!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else{
            return true;
            }
        }
    
    public boolean validasiKode(String kode) {
        try {
            Statement stmt = k.createStatement();
            String sqlSelect = "SELECT * FROM teknisi WHERE id_teknisi = '" + kode + "'";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "ID Teknisi Tersebut sudah ada\nSilakan gunakan ID Teknisi yang berbeda.",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    "Terjadi kesalahan saat validasi kode.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    public void loadData(Teknisi teknisi, List<Teknisi> list){
        if(teknisiView.getTabelTeknisi().getSelectedRow() >= 0){
            int row = teknisiView.getTabelTeknisi().getSelectedRow();
            teknisi = list.get(row);
            teknisiView.getTextId().setText(teknisi.getId());
            teknisiView.getTextNama().setText(teknisi.getNama());
            teknisiView.getTextNo().setText(teknisi.getNoHp());
            
            String keahlian = teknisi.getKeahlian();
            if ("Hardware".equals(keahlian)) {
            teknisiView.getComboKeahlian().setSelectedItem("Hardware");
            } else if ("Software".equals(keahlian)) {
            teknisiView.getComboKeahlian().setSelectedItem("Software");
            } else if ("Keduanya".equals(keahlian)) {
            teknisiView.getComboKeahlian().setSelectedItem("Keduanya");
            }
//            enableForm(false);
            teknisiView.getTextNama().setEnabled(true);
        }else{
            
        }
    }
}
