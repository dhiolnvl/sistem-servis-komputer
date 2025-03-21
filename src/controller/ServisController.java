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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import main.App;
import model.Servis;
import view.ServisView;

/**
 *
 * @author ASUS
 */
public class ServisController {

    private final ServisView servisView;
    Koneksi k;

    public ServisController(ServisView servisView) {
        this.servisView = servisView;
        k = new Koneksi();
    }

    public void clearForm() {
        servisView.getTextNoServis().setText(null);
        servisView.getComboPelanggan().setSelectedIndex(0);
        servisView.getComboTeknisi().setSelectedIndex(0);
        servisView.getComboJenis().setSelectedIndex(0);
        servisView.getTextDeskripsi().setText(null);
        servisView.getTextHarga().setText(null);
        servisView.getTabelServis().clearSelection();
    }

    public void enableForm(boolean kondisi) {
        servisView.getTextNoServis().setEnabled(kondisi);;
        servisView.getComboPelanggan().setEnabled(kondisi);
        servisView.getComboTeknisi().setEnabled(kondisi);
        servisView.getComboJenis().setEnabled(kondisi);
        servisView.getTextDeskripsi().setEnabled(kondisi);
        servisView.getTextHarga().setEnabled(kondisi);
        servisView.getTombolSimpan().setEnabled(kondisi);
        servisView.getTombolUbah().setEnabled(!kondisi);
        servisView.getTombolHapus().setEnabled(!kondisi);
    }

    public void enableForm2(boolean kondisi) {
        servisView.getTextNoServis().setEnabled(!kondisi);;
        servisView.getComboPelanggan().setEnabled(kondisi);
        servisView.getComboTeknisi().setEnabled(kondisi);
        servisView.getComboJenis().setEnabled(kondisi);
        servisView.getTextDeskripsi().setEnabled(kondisi);
        servisView.getTextHarga().setEnabled(kondisi);
        servisView.getTombolSimpan().setEnabled(!kondisi);
        servisView.getTombolUbah().setEnabled(kondisi);
        servisView.getTombolHapus().setEnabled(kondisi);
    }

    public boolean validasiInput() {
        if (servisView.getTextNoServis().getText().isEmpty() || servisView.getTextDeskripsi().getText().isEmpty() || servisView.getTextHarga().getText().isEmpty()) {
            JOptionPane.showMessageDialog(servisView, "Harus diisi Semua !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }
    
    public boolean validasiKode(String kode) {
        try {
            Statement stmt = k.createStatement();
            String sqlSelect = "SELECT * FROM servis WHERE no_servis = '" + kode + "'";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "No Servis Tersebut sudah ada\nSilakan gunakan No Servis yang berbeda.",
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

    public void loadPelanggan() {
        ComboBoxModel p = new DefaultComboBoxModel(App.masterService.getAllNamePelanggan());
        servisView.getComboPelanggan().setModel(p);
    }

    public void loadTeknisi() {
        ComboBoxModel t = new DefaultComboBoxModel(App.masterService.getAllNameTeknisi());
        servisView.getComboTeknisi().setModel(t);
    }

    public void loadData(Servis servis, List<Servis> list) {
        if (servisView.getTabelServis().getSelectedRow() >= 0) {
            int row = servisView.getTabelServis().getSelectedRow();
            servis = list.get(row);
            servisView.getTextNoServis().setText(servis.getIdServis());
            servisView.getComboPelanggan().setSelectedItem(servis.getPelanggan().getNama());
            servisView.getComboTeknisi().setSelectedItem(servis.getTeknisi().getNama());
            servisView.getTextDeskripsi().setText(servis.getDeskripsi());
            servisView.getTextHarga().setText(String.valueOf(servis.getHarga()));
            servisView.getTextNoServis().setEnabled(false);
            servisView.getTombolUbah().setEnabled(false);
            servisView.getTombolHapus().setEnabled(false);

            String jenis = servis.getJenis();
            if ("Hardware".equals(jenis)) {
                servisView.getComboJenis().setSelectedItem("Hardware");
            } else if ("Software".equals(jenis)) {
                servisView.getComboJenis().setSelectedItem("Software");
            }
        }
    }
}
