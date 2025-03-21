/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import config.Koneksi;
import dao.TeknisiDao;
import dao.PelangganDao;
import dao.ServisDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teknisi;
import service.MasterService;
import model.Pelanggan;
import model.Servis;

/**
 *
 * @author ASUS
 */
public class MasterServiceImpl implements MasterService{
    
    private TeknisiDao teknisiDao;
    private PelangganDao pelangganDao;
    private ServisDao servisDao;

    private Koneksi koneksi;
    private Connection connection;

    public MasterServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();

            teknisiDao = new TeknisiDao();
            teknisiDao.setConnection(connection);

            pelangganDao = new PelangganDao();
            pelangganDao.setConnection(connection);
            
            servisDao = new ServisDao();
            servisDao.setConnection(connection,pelangganDao,teknisiDao);
            
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Teknisi simpanTeknisi(Teknisi t) {
        try {
            connection.setAutoCommit(false);
            teknisiDao.simpan(t);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    @Override
    public Teknisi ubahTeknisi(Teknisi t) {
        try {
            connection.setAutoCommit(false);
            teknisiDao.ubah(t);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Teknisi hapusTeknisi(Teknisi t) {
        try {
            connection.setAutoCommit(false);
            teknisiDao.hapus(t);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    @Override
    public List<Teknisi> getAllTeknisi() {
        try {
            return teknisiDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    @Override
    public Teknisi getByIdTeknisi(String id) {
        try {
            return teknisiDao.getById(id);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    @Override
    public Object[] getAllNameTeknisi() {
        try {
            return teknisiDao.getAllNameTeknisi();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Teknisi getByNameTeknisi(String name) {
        try {
            return teknisiDao.getByNameTeknisi(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    // Pelanggan
    @Override
    public Pelanggan simpanPelanggan(Pelanggan p) {
        try {
            connection.setAutoCommit(false);
            pelangganDao.simpan(p);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public Pelanggan ubahPelanggan(Pelanggan p) {
        try {
            connection.setAutoCommit(false);
            pelangganDao.ubah(p);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public Pelanggan hapusPelanggan(Pelanggan p) {
        try {
            connection.setAutoCommit(false);
            pelangganDao.hapus(p);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public List<Pelanggan> getAllPelanggan() {
        try {
            return pelangganDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }

    @Override
    public Pelanggan getByIdPelanggan(String id) {
        try {
            return pelangganDao.getById(id);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }
    
    public Pelanggan getByNamePelanggan(String name) {
        try {
            return pelangganDao.getByNamePelanggan(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public Object[] getAllNamePelanggan() {
        try {
            return pelangganDao.getAllNamePelanggan();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    // SERVIS
  @Override
    public Servis simpanServis(Servis s) {
        try {
            connection.setAutoCommit(false);
            servisDao.simpan(s);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    @Override
    public Servis ubahServis(Servis s) {
        try {
            connection.setAutoCommit(false);
            servisDao.ubah(s);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    @Override
    public Servis hapusServis(Servis s) {
        try {
            connection.setAutoCommit(false);
            servisDao.hapus(s);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    @Override
    public List<Servis> getAllServis() {
        try {
            return servisDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }

    @Override
    public Servis getByIdServis(String id) {
        try {
            return servisDao.getById(id);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public Servis getByNameServis(String name) {
        try {
            return servisDao.getByNameServis(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public List<Servis> findByNameServis(String nama) {
        try {
            return servisDao.findByNameServis(nama);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
