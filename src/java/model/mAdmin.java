/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import object.iAdmin;

/**
 *
 * @author user
 */
public class mAdmin implements iAdmin {
    private String idadmin,namaadmin,alamatadmin, username, password,foto;
    private koneksi obj_koneksi = new koneksi();

     public mAdmin()
    {
        super();
    }

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
      public String getFoto(){
        return foto;
    }
    
    public void setFoto(String foto){
        this.foto = foto;
    }

    public koneksi getObj_koneksi() {
        return obj_koneksi;
    }

    public void setObj_koneksi(koneksi obj_koneksi) {
        this.obj_koneksi = obj_koneksi;
    }
     public int doInsert()
    {
        int i = 0 ;
        try
        {
            System.out.println("Password: " + password);
            obj_koneksi.OpenConnection();
            String str = "insert into tb_admin (Id_admin,nama_admin, alamat_admin,username,password) values(?,?,?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idadmin);
            pr.setString(2, namaadmin);
            pr.setString(3, alamatadmin);
            pr.setString(4, username);
            pr.setString(5, password);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    public int doUpdate()
    {
        int i = 0;
        try
        {
            obj_koneksi.OpenConnection();
            String str = "UPDATE tb_admin SET nama_admin = ?, alamat_admin = ?, username =  ?, password = ? where id_admin = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, namaadmin);
            pr.setString(2, alamatadmin);
            pr.setString(3, username);
            pr.setString(4, password);
            pr.setString(5, idadmin);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    public int doDelete()
    {
        int i = 0 ;
        try
        {
         obj_koneksi.OpenConnection();
         String str = "delete tb_admin where id_admin= ?";
         PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
         pr.setString(1, idadmin);
         i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    public ArrayList display()
    {
         ArrayList data = new ArrayList();
         try
         {
             obj_koneksi.OpenConnection();
             Statement stmt = obj_koneksi.con.createStatement();
             String str = "select * from tb_admin";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setIdadmin(rs.getString(1));
                this.setnamaadmin(rs.getString(2));
                this.setalamatadmin(rs.getString(3));
                this.setUsername(rs.getString(4));
                 this.setPassword(rs.getString(5));
                 data.add(this.getIdadmin());
                 data.add(this.getnamaadmin());
                 data.add(this.getalamatadmin());
                 data.add(this.getUsername());
                 data.add(this.getPassword());
             }
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
         return data;
    }
    public ArrayList getRecord()
    {
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.OpenConnection();
            String str = "select * from tb_admin where id_admin = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idadmin);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                 this.setIdadmin(rs.getString(1));
                 this.setnamaadmin(rs.getString(2));
                 this.setalamatadmin(rs.getString(3));
                 this.setUsername(rs.getString(4));
                 this.setPassword(rs.getString(5));
               
                 data.add(this.getIdadmin());
                 data.add(this.getnamaadmin());
                 data.add(this.getalamatadmin());
                 data.add(this.getUsername());
                 data.add(this.getPassword());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }
 public int doLogin()
    {
        try 
        {
            obj_koneksi.OpenConnection();
            String sq = "select count(*) as jumlah from tb_admin where username=? and password=?";
            //pake prepare statment karena ada parameter
            PreparedStatement ps = obj_koneksi.con.prepareStatement(sq);
            ps.setString(1, getUsername());
            ps.setString(2, getPassword());
            
            ResultSet r = ps.executeQuery();
            int jumlah = 0;
            if(r.next())
            {
                jumlah = r.getInt("jumlah");
            }
            return jumlah;          
        } 
        catch (Exception e) 
        {
        }
        return 0;
    }
 
 public String caridataAdmin()
    {
        try 
        {
            obj_koneksi.OpenConnection();
            String sq = "select * from tb_admin where id_admin=?";
            PreparedStatement ps = obj_koneksi.con.prepareStatement(sq);
            ps.setString(1, username);
          
            
            ResultSet r = ps.executeQuery();
             String data = null;
            if(r.next())
            {
                data= r.getString("nama_admin");
            }
            else
            {
               data= "kosong";
            }
            return data;        
        } 
        catch (Exception e) 
        {
        }
        return null;
    }


    public String getnamaadmin() {
       return namaadmin;
    }

   
    public void setnamaadmin(String namaadmin) {
        this.namaadmin = namaadmin;
    }

  
    public String getalamatadmin() {
        return alamatadmin;
    }

   
    public void setalamatadmin(String alamatadmin) {
       this.alamatadmin = alamatadmin;
    }

   
}
