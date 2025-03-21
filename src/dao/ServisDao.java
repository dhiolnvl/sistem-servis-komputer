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
import model.Servis;
/**
 *
 * @author ASUS
 */
public class ServisDao {
    private PelangganDao pelangganDao;
    private TeknisiDao teknisiDao;

    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getByNameStatement;
    private PreparedStatement findByNameStatement;

    private final String queryInsert = "INSERT INTO servis (no_servis, jenis_servis, deskripsi_servis, harga, id_pelanggan, id_teknisi) VALUES (?,?,?,?,?,?)";
    private final String queryUpdate = "UPDATE servis SET jenis_servis=?,deskripsi_servis=?,harga=?,id_pelanggan=?,id_teknisi=? WHERE no_servis=?";
    private final String queryDelete = "DELETE FROM servis WHERE no_servis=?";
    private final String querySelectAll = "SELECT * FROM servis";
    private final String querySelectById = "SELECT * from servis WHERE no_servis=?";
    private final String querySelectByName = "SELECT * from servis WHERE deskripsi_servis=?";
    private final String queryLikeByName = "SELECT * from servis WHERE no_servis LIKE ?";

    public void setConnection(Connection connection, PelangganDao pelangganDao, TeknisiDao teknisiDao) throws SQLException {
        this.connection = connection;
        this.pelangganDao = pelangganDao;
        this.teknisiDao = teknisiDao;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getByNameStatement = connection.prepareStatement(querySelectByName);
        findByNameStatement = connection.prepareStatement(queryLikeByName);
    }

    public Servis simpan(Servis s) throws SQLException {
        simpanStatement.setString(1, s.getIdServis());
        simpanStatement.setString(2, s.getJenis());
        simpanStatement.setString(3, s.getDeskripsi());
        simpanStatement.setDouble(4, s.getHarga());
        simpanStatement.setString(5, s.getPelanggan().getId());
        simpanStatement.setString(6, s.getTeknisi().getId());
        simpanStatement.executeUpdate();
        return s;
    }

   public Servis ubah(Servis s) throws SQLException {
        ubahStatement.setString(1, s.getJenis());
        ubahStatement.setString(2, s.getDeskripsi());
        ubahStatement.setDouble(3, s.getHarga());
        ubahStatement.setString(4, s.getPelanggan().getId());
        ubahStatement.setString(5, s.getTeknisi().getId());
        ubahStatement.setString(6, s.getIdServis());
        ubahStatement.executeUpdate();
        return s;
    }

    public Servis hapus(Servis s) throws SQLException {
        hapusStatement.setString(1, s.getIdServis());
        hapusStatement.executeUpdate();
        return s;
    }

    public List<Servis> getAll() throws SQLException {
        List<Servis> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Servis s = new Servis();
            s.setIdServis(rs.getString("no_servis"));
            s.setJenis(rs.getString("jenis_servis"));
            s.setDeskripsi(rs.getString("deskripsi_servis"));
            s.setHarga(rs.getDouble("harga"));
            s.setPelanggan(pelangganDao.getById(rs.getString("id_pelanggan")));
            s.setTeknisi(teknisiDao.getById(rs.getString("id_teknisi")));
            list.add(s);
        }
        return list;
    }

    public Servis getById(String id) throws SQLException {
        Servis s = new Servis();

        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            s.setIdServis(rs.getString("no_servis"));
            s.setJenis(rs.getString("jenis_servis"));
            s.setDeskripsi(rs.getString("deskripsi_servis"));
            s.setHarga(rs.getDouble("harga"));
            s.setPelanggan(pelangganDao.getById(rs.getString("id_pelanggan")));
            s.setTeknisi(teknisiDao.getById(rs.getString("id_teknisi")));
        }
        return s;       
    }
    
    public Servis getByNameServis(String name) throws SQLException {
        Servis s = new Servis();
        getByNameStatement.setString(1, name);
        ResultSet rs = getByNameStatement.executeQuery();
        while (rs.next()) {
            s.setIdServis(rs.getString("no_servis"));
            s.setJenis(rs.getString("jenis_servis"));
            s.setDeskripsi(rs.getString("deskripsi_servis"));
            s.setHarga(rs.getDouble("harga"));
            s.setPelanggan(pelangganDao.getById(rs.getString("id_pelanggan")));
            s.setTeknisi(teknisiDao.getById(rs.getString("id_teknisi")));
        }
        return s;       
    }
    
    public List<Servis> findByNameServis(String nama) throws SQLException{
        List<Servis> list = new ArrayList<Servis>();
        findByNameStatement.setString(1, "%"+ nama +"%");
        ResultSet rs = findByNameStatement.executeQuery();
        while(rs.next()){
            Servis s = new Servis();
            s.setIdServis(rs.getString("no_servis"));
            s.setJenis(rs.getString("jenis_servis"));
            s.setDeskripsi(rs.getString("deskripsi_servis"));
            s.setHarga(rs.getDouble("harga"));
            s.setPelanggan(pelangganDao.getById(rs.getString("id_pelanggan")));
            s.setTeknisi(teknisiDao.getById(rs.getString("id_teknisi")));
            list.add(s);
        }
        return list;
    }
    


}
