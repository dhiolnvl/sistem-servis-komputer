/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.LihatTransaksi;

/**
 *
 * @author ASUS
 */
public class LihatTransaksiDao {
    private Connection connection;
    private PreparedStatement getAllStatement;
    
    private final String querySelectAll = "SELECT * FROM view_transaksi";
    
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;

        getAllStatement = connection.prepareStatement(querySelectAll);
    }
    
    public List<LihatTransaksi> getAll() throws SQLException {
        List<LihatTransaksi> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            LihatTransaksi tv = new LihatTransaksi();
            tv.setNoTransaksi(rs.getString("no_transaksi"));
            tv.setTanggal(rs.getString("tanggal"));
            tv.setNama(rs.getString("nama"));
            tv.setDeskripsi(rs.getString("deskripsi_servis"));
            tv.setHarga(rs.getDouble("harga"));
            list.add(tv);
        }
        return list;
    }
}
