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
import model.Teknisi;

/**
 *
 * @author ASUS
 */
public class TeknisiDao {
    
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    
    private final String queryInsert = "INSERT INTO teknisi (id_teknisi, nama, no_hp, keahlian) VALUES (?,?,?,?)";
    private final String queryUpdate = "UPDATE teknisi SET nama=?, no_hp=?, keahlian=? WHERE id_teknisi=?";
    private final String queryDelete = "DELETE FROM teknisi WHERE id_teknisi=?";
    private final String querySelectAll = "SELECT * FROM teknisi";
    private final String querySelectById = "SELECT * from teknisi WHERE id_teknisi=?";
    private final String querySelectAllName = "SELECT nama from teknisi";
    private final String querySelectByName = "SELECT * from teknisi WHERE nama=?";

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

    public Teknisi simpan(Teknisi t) throws SQLException {
        simpanStatement.setString(1, t.getId());
        simpanStatement.setString(2, t.getNama());
        simpanStatement.setString(3, t.getNoHp());
        simpanStatement.setString(4, t.getKeahlian());
        simpanStatement.executeUpdate();
        return t;
    }

    public Teknisi ubah(Teknisi t) throws SQLException {
        ubahStatement.setString(1, t.getNama());
        ubahStatement.setString(2, t.getNoHp());
        ubahStatement.setString(3, t.getKeahlian());
        ubahStatement.setString(4, t.getId());
        ubahStatement.executeUpdate();
        return t;
    }

    public Teknisi hapus(Teknisi t) throws SQLException {
        hapusStatement.setString(1, t.getId());
        hapusStatement.executeUpdate();
        return t;
    }
    
    public List<Teknisi> getAll() throws SQLException {
        List<Teknisi> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Teknisi t = new Teknisi();
            t.setId(rs.getString("id_teknisi"));
            t.setNama(rs.getString("nama"));
            t.setNoHp(rs.getString("no_hp"));
            t.setKeahlian(rs.getString("keahlian"));
            list.add(t);
        }
        return list;
    }

    public Teknisi getById(String id) throws SQLException {
        Teknisi t = new Teknisi();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            t.setId(rs.getString("id_teknisi"));
            t.setNama(rs.getString("nama"));
            t.setNoHp(rs.getString("no_hp"));
            t.setKeahlian(rs.getString("keahlian"));
        }
        return t;
    }
    
    public Object[] getAllNameTeknisi() throws SQLException{
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("nama"));
        }
        return newObj.toArray();
    }
    
    public Teknisi getByNameTeknisi(String name) throws SQLException {
        Teknisi t = new Teknisi();
        
        getByNameStatement.setString(1, name);
        ResultSet rs = getByNameStatement.executeQuery();
        while (rs.next()) {
            t.setId(rs.getString("id_teknisi"));
            t.setNama(rs.getString("nama"));
            t.setNoHp(rs.getString("no_hp"));
            t.setKeahlian(rs.getString("keahlian"));
        }
        return t;
    }
    
}
