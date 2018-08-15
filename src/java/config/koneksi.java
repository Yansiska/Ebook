/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jasmine
 */
public class koneksi {
    public Connection con;
    public void OpenConnection (){
        
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=buku;user=sa;password=123jasmine";
            con = DriverManager.getConnection(url);
            System.out.println("berhasil");
            //return con;
        }
        catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
           //return null;
        }
    }
}
