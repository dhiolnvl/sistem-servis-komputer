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
import model.Pelanggan;
import view.PelangganView;
/**
 *
 * @author ASUS
 */
public class PelangganController {
    
    private final PelangganView pelangganView;
    Koneksi k;
    
    public PelangganController(PelangganView pelangganView) {
        this.pelangganView = pelangganView;
        k = new Koneksi();
    }
    
    public void clearForm(){
        pelangganView.getTextId().setText(null);
        pelangganView.getTextNama().setText(null);
        pelangganView.getTextNo().setText(null);
        pelangganView.getTextEmail().setText(null);
        pelangganView.getTextAlamat().setText(null);
        pelangganView.getTabelPelanggan().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        pelangganView.getTextId().setEnabled(!kondisi);
        pelangganView.getTextNama().setEnabled(kondisi);
        pelangganView.getTextNo().setEnabled(kondisi);
        pelangganView.getTextEmail().setEnabled(kondisi);
        pelangganView.getTextAlamat().setEnabled(kondisi);
        pelangganView.getTombolSimpan().setEnabled(!kondisi);
        pelangganView.getTombolUbah().setEnabled(kondisi);
        pelangganView.getTombolHapus().setEnabled(kondisi);
    }
    
    public void enableForm2(boolean kondisi){
         pelangganView.getTextId().setEnabled(kondisi);
        pelangganView.getTextNama().setEnabled(kondisi);
        pelangganView.getTextNo().setEnabled(kondisi);
        pelangganView.getTextEmail().setEnabled(kondisi);
        pelangganView.getTextAlamat().setEnabled(kondisi);
        pelangganView.getTombolSimpan().setEnabled(kondisi);
        pelangganView.getTombolUbah().setEnabled(!kondisi);
        pelangganView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        String no = pelangganView.getTextNo().getText();
        if(pelangganView.getTextId().getText().isEmpty() || pelangganView.getTextNama().getText().isEmpty() || pelangganView.getTextNo().getText().isEmpty() || pelangganView.getTextEmail().getText().isEmpty()  || pelangganView.getTextAlamat().getText().isEmpty()){
            JOptionPane.showMessageDialog(pelangganView, "Harus diisi Semua !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }  else if (!no.matches("\\d{12,13}")) {
            JOptionPane.showMessageDialog(pelangganView, "Nomor hanya boleh angka dan maksimal 13 karakter!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else{
            return true;
            }
        }
    public boolean validasiKode(String kode) {
        try {
            Statement stmt = k.createStatement();
            String sqlSelect = "SELECT * FROM pelanggan WHERE id_pelanggan = '" + kode + "'";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "ID Pelanggan Tersebut sudah ada\nSilakan gunakan ID Pelanggan yang berbeda.",
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
    
    public void loadData(Pelanggan pelanggan, List<Pelanggan> list){
        if(pelangganView.getTabelPelanggan().getSelectedRow() >= 0){
            int row = pelangganView.getTabelPelanggan().getSelectedRow();
            pelanggan = list.get(row);
            pelangganView.getTextId().setText(pelanggan.getId());
            pelangganView.getTextNama().setText(pelanggan.getNama());
            pelangganView.getTextNo().setText(pelanggan.getNoHp());
            pelangganView.getTextEmail().setText(pelanggan.getEmail());
            pelangganView.getTextAlamat().setText(pelanggan.getAlamat());
            
            enableForm(false);
            pelangganView.getTextNama().setEnabled(true);
        }else{
            
        }
    }
}
