/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import service.MasterService;
import service.TransaksiService;
import service.impl.MasterServiceImpl;
import service.impl.TransaksiServiceImpl;
import view.MenuView;

/**
 *
 * @author ASUS
 */
public class App {
    
    public static MenuView menuView;
    
    public static MasterService masterService;
    public static TransaksiService transaksiService;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        masterService = new MasterServiceImpl();
        transaksiService = new TransaksiServiceImpl();
        
        menuView = new MenuView();
        menuView.setVisible(true);

    }
    
}
