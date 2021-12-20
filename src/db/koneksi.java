package db;

import com.mysql.jdbc.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import uap.Rekening;

public class koneksi {
    public Connection getKoneksi(){
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
    
    public ObservableList<Rekening> getRekening(){
        ObservableList<Rekening> data = FXCollections.observableArrayList();
        String sql, sqlAccount;
        Connection con = getKoneksi();
        
        try{
            sql = "SELECT * FROM rekening";
            
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while(rs.next()){
                data.add(new Rekening(rs.getString("no_rek"), rs.getString("nama"), rs.getDouble("saldo")));
            }
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
        
        return data;
    }
    
    public void addRekening(Rekening rek){
        try {
            String query = "INSERT INTO rekening(no_rek, nama, saldo) VALUES(?, ?, ?)";
            Connection con = getKoneksi();
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, rek.getNorek());
            ps.setString(2, rek.getNama());
            ps.setDouble(3, rek.getSaldo());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }
}
