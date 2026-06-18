/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas13;

/**
 *
 * @author MSI GF63
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/pbo", "root", "");
            System.out.println("Koneksi Sukses!");
            return con;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver tidak ditemukan: " + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.out.println("Koneksi Gagal: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        DBConnection tes = new DBConnection();
        tes.getConnection();
    }
}
