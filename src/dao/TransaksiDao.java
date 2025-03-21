/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Transaksi;


/**
 *
 * @author ASUS
 */
public class TransaksiDao {
    
    private Connection connection;
    private PelangganDao pelangganDao;
    private ServisDao servisDao;
    private PreparedStatement simpanStatement;
    
    private final String queryInsert = "INSERT INTO transaksi (no_transaksi, no_servis, tanggal) VALUES (?,?,?)";
    private final String querySelectAll = "SELECT * FROM transaksi";
    private final String queryLikeByName = "SELECT * from transaksi WHERE no_transaksi LIKE ?";
    
    public void setConnection(Connection connection, PelangganDao pelangganDao, ServisDao servisDao) throws SQLException{
        this.connection = connection;
        this.pelangganDao = pelangganDao;
        this.servisDao = servisDao;
        simpanStatement = connection.prepareStatement(queryInsert);
    }
    
    public Transaksi simpan(Transaksi t) throws SQLException{
        simpanStatement.setString(1, t.getNoTransaksi());
        simpanStatement.setString(2, t.getServis().getIdServis());
        simpanStatement.setString(3, t.getTanggal());
        simpanStatement.executeUpdate();
        return t;
    }
    
}
