/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.util.List;
import model.Transaksi;
import model.LihatTransaksi;

/**
 *
 * @author ASUS
 */
public interface TransaksiService {
    
    Transaksi simpanTransaksi(Transaksi t);
    List<LihatTransaksi> getAll();
}
