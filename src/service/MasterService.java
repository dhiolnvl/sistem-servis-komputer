/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Teknisi;
import model.Pelanggan;
import model.Servis;

/**
 *
 * @author ASUS
 */
public interface MasterService {
    
    // Teknisi
    Teknisi simpanTeknisi(Teknisi t);
    Teknisi ubahTeknisi(Teknisi t);
    Teknisi hapusTeknisi(Teknisi t);
    List<Teknisi> getAllTeknisi();
    Teknisi getByIdTeknisi(String id);
    Object[] getAllNameTeknisi();
    Teknisi getByNameTeknisi(String name);
     
    // Pelanggan
    Pelanggan simpanPelanggan(Pelanggan p);
    Pelanggan ubahPelanggan(Pelanggan p);
    Pelanggan hapusPelanggan(Pelanggan p);
    List<Pelanggan> getAllPelanggan();
    Pelanggan getByIdPelanggan(String id);
    Pelanggan getByNamePelanggan(String name);
    Object[] getAllNamePelanggan();
    
    // SERVIS
    Servis simpanServis(Servis s);
    Servis ubahServis(Servis s);
    Servis hapusServis(Servis s);
    List<Servis> getAllServis();
    Servis getByIdServis(String id);
    Servis getByNameServis(String name);
    List<Servis> findByNameServis(String nama);
}
