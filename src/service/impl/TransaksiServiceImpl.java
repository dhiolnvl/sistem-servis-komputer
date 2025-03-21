/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import config.Koneksi;
import dao.PelangganDao;
import dao.ServisDao;
import dao.TeknisiDao;
import dao.TransaksiDao;
import dao.LihatTransaksiDao;
import model.Transaksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LihatTransaksi;
import service.TransaksiService;

/**
 *
 * @author ASUS
 */
public class TransaksiServiceImpl implements TransaksiService{
    private TransaksiDao transaksiDao;
    private PelangganDao pelangganDao;
    private TeknisiDao teknisiDao;
    private ServisDao servisDao;
    private LihatTransaksiDao lihatTransaksiDao;

    private Koneksi koneksi;
    private Connection connection;
    
    public TransaksiServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();
            
            pelangganDao = new PelangganDao();
            pelangganDao.setConnection(connection);
            
            servisDao = new ServisDao();
            servisDao.setConnection(connection,pelangganDao,teknisiDao);
            
            transaksiDao = new TransaksiDao();
            transaksiDao.setConnection(connection,pelangganDao,servisDao);
            
            lihatTransaksiDao = new LihatTransaksiDao();
            lihatTransaksiDao.setConnection(connection);
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Transaksi simpanTransaksi(Transaksi t) {
        try {
            connection.setAutoCommit(false);
            transaksiDao.simpan(t);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TransaksiServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(TransaksiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    @Override
    public List<LihatTransaksi> getAll() {
        try {
            return lihatTransaksiDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
    
    
}
