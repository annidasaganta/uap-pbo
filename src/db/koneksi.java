package db;

import com.mysql.jdbc.*;

import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    public static Connection getKoneksi(){
        String URL = "jdbc:mysql://localhost/koperasi";
        String USER = "root";
        String PASS = "";
        try{
            Connection conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
            
            System.out.println("Success");
            return conn;
        }catch(SQLException ex) {
            System.out.println("Error : " + ex);
            
            return null;
        }
    }
}
