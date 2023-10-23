/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package0;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class demo {

    public static void main(String[] args) {
        QuanLyDsKhachHang l = new QuanLyDsKhachHang();
        try {
            l.layDuLieu("src/main/resource/DuLieu.txt");
        } catch (Exception ex) {
            Logger.getLogger(demo.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        GiaoDien i = new GiaoDien();
        try {
            i.giaoDienChinh(l);
        } catch (Exception ex) {
            Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
