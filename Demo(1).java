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
public class Demo {
    public static void main(String[] args){
        QuanLyDsKhachHang l = new QuanLyDsKhachHang();
        GiaoDien i = new GiaoDien();
        try {
            i.giaoDienChinh(l);
        } catch (Exception ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
