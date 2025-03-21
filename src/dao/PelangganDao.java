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
import model.Pelanggan;

/**
 *
 * @author ASUS
 */
public class PelangganDao {

    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    
    private final String queryInsert = "INSERT INTO pelanggan (id_pelanggan, nama, no_hp, email, alamat) VALUES (?,?,?,?,?)";
    private final String queryUpdate = "UPDATE pelanggan SET nama=?, no_hp=?, email=?, alamat=? WHERE id_pelanggan=?";
    private final String queryDelete = "DELETE FROM pelanggan WHERE id_pelanggan=?";
    private final String querySelectAll = "SELECT * FROM pelanggan";
    private final String querySelectById = "SELECT * from pelanggan WHERE id_pelanggan=?";
    private final String querySelectAllName = "SELECT nama from pelanggan";
    private final String querySelectByName = "SELECT * from pelanggan WHERE nama=?";

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
    }

    public Pelanggan simpan(Pelanggan p) throws SQLException {
        simpanStatement.setString(1, p.getId());
        simpanStatement.setString(2, p.getNama());
        simpanStatement.setString(3, p.getNoHp());
        simpanStatement.setString(4, p.getEmail());
        simpanStatement.setString(5, p.getAlamat());       
        simpanStatement.executeUpdate();
        return p;
    }

    public Pelanggan ubah(Pelanggan p) throws SQLException {
        ubahStatement.setString(1, p.getNama());
        ubahStatement.setString(2, p.getNoHp());
        ubahStatement.setString(3, p.getEmail());
        ubahStatement.setString(4, p.getAlamat());
        ubahStatement.setString(5, p.getId());
        ubahStatement.executeUpdate();
        return p;
    }

    public Pelanggan hapus(Pelanggan p) throws SQLException {
        hapusStatement.setString(1, p.getId());
        hapusStatement.executeUpdate();
        return p;
    }
    
    public List<Pelanggan> getAll() throws SQLException {
        List<Pelanggan> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Pelanggan p = new Pelanggan();
            p.setId(rs.getString("id_pelanggan"));
            p.setNama(rs.getString("nama"));
            p.setNoHp(rs.getString("no_hp"));
            p.setEmail(rs.getString("email"));
            p.setAlamat(rs.getString("alamat"));
            list.add(p);
        }
        return list;
    }

    public Pelanggan getById(String id) throws SQLException {
        Pelanggan p = new Pelanggan();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            p.setId(rs.getString("id_pelanggan"));
            p.setNama(rs.getString("nama"));
            p.setNoHp(rs.getString("no_hp"));
            p.setEmail(rs.getString("email"));
            p.setAlamat(rs.getString("alamat"));
        }
        return p;
    }
    
    public Object[] getAllNamePelanggan() throws SQLException{
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("nama"));
        }
        return newObj.toArray();
    }
    
    public Pelanggan getByNamePelanggan(String name) throws SQLException {
        Pelanggan p = new Pelanggan();     
        getByNameStatement.setString(1, name);
        ResultSet rs = getByNameStatement.executeQuery();
        while (rs.next()) {
            p.setId(rs.getString("id_pelanggan"));
            p.setNama(rs.getString("nama"));
            p.setNoHp(rs.getString("no_hp"));
            p.setEmail(rs.getString("email"));
            p.setAlamat(rs.getString("alamat"));
        }
        return p;
    }
}
