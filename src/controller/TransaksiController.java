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
import main.App;
import model.Servis;
import view.CariView;
import view.TransaksiView;
import view.ServisView;

/**
 *
 * @author ASUS
 */
public class TransaksiController {

    private final TransaksiView transaksiView;
    private List<Servis> listServis;
    private Servis servis;
    Koneksi k;

    public TransaksiController(TransaksiView transaksiView) {
        this.transaksiView = transaksiView;
        k = new Koneksi();
    }

    public boolean validasiInput() {
        if (transaksiView.getTextNoTransaksi().getText().isEmpty() || transaksiView.getTextNoServis().getText().isEmpty() || transaksiView.getTextHarga().getText().isEmpty()) {
            JOptionPane.showMessageDialog(transaksiView, "Harus diisi Semua !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public void cariServis(String nama){
        CariView cariView= new CariView(App.menuView, true);
        listServis = App.masterService.getAllServis();
        ServisView sv = new ServisView();
        ServisView.ServisTableModel servisTabelModel = sv.new ServisTableModel(listServis);
        cariView.getTabelCari().setModel(servisTabelModel);
        
        ServisController sc = new ServisController(sv);
        cariView.getTabelCari().getSelectionModel().addListSelectionListener((lse) -> {
            if(cariView.getTabelCari().getSelectedRow()>=0){               
                int row = cariView.getTabelCari().getSelectedRow();               
                servis = listServis.get(row);              
                transaksiView.getTextNoServis().setText(servis.getIdServis());
                transaksiView.getTextServisan().setText(servis.getDeskripsi());
                transaksiView.getTextNamaPelanggan().setText(servis.getPelanggan().nama);
                transaksiView.getTextHarga().setText(String.valueOf(servis.getHarga()));
            }
        });
        cariView.setVisible(true);
    }
    
    public boolean validasiKodeTransaksi(String kode) {
        try {
            Statement stmt = k.createStatement();
            String sqlSelect = "SELECT * FROM transaksi WHERE no_transaksi = '" + kode + "'";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "No Transaksi Tersebut sudah ada\nSilakan gunakan No Transaksi yang berbeda.",
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
    
    public boolean validasiKodeServis(String kode) {
        try {
            Statement stmt = k.createStatement();
            String sqlSelect = "SELECT * FROM transaksi WHERE no_servis = '" + kode + "'";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "No Servis tersebut sudah melakukan transaksi\nSilakan gunakan No servis yang lain.",
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
    
    public void clearForm(){
        transaksiView.getTextNoTransaksi().setText(null);
        transaksiView.getTextNoServis().setText(null);
        transaksiView.getTextServisan().setText(null);
        transaksiView.getTextNamaPelanggan().setText(null);
        transaksiView.getTextHarga().setText(null);
    }

}
