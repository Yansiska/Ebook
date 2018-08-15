/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import config.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import object.IBook;
/**
 *
 * @author user
 */
public class mBook implements IBook {
 private String idEBook,judul,deskripsi,foto;

    private koneksi obj_koneksi = new koneksi();
    
    public mBook() {
        super();
    }


    public void setObj_koneksi(koneksi obj_koneksi) {
        this.obj_koneksi = obj_koneksi;
    }
    
   public int doInsert(){
         int i = 0 ;
        try
        {
            obj_koneksi.OpenConnection();
            String str = "insert into Book (idEBook,judul,deskripsi,foto) values(?,?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idEBook);
            pr.setString(2, judul);
            pr.setString(3, deskripsi);
            pr.setString(4, foto);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
   }
   
   public int doUpdate(){
   
        int i = 0;
        try
        {
            obj_koneksi.OpenConnection();
            String str = "UPDATE Book SET judul = ?,deskripsi =?, foto =  ? where idEBook = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idEBook);
            pr.setString(2, judul);
            pr.setString(3, deskripsi);
            pr.setString(4, foto);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
   }
   
   public int doDelete(){
       
        int i = 0 ;
        try
        {
         obj_koneksi.OpenConnection();
         String str = "delete Book where idEBook= ?";
         PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
         pr.setString(1, idEBook);
         i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
   }
   
   public String[] searchBook()
    {
        ArrayList data = new ArrayList();
        try 
        {
            obj_koneksi.OpenConnection();
            String sql = "select judul from Book where idEBook = ? ";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(sql);
            pr.setString(1, idEBook);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
            {
                this.setJudul(rs.getString(1));
                data.add(this.getJudul());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
   
   public ArrayList display(){
        ArrayList data = new ArrayList();
         try
         {
             obj_koneksi.OpenConnection();
             Statement stmt = obj_koneksi.con.createStatement();
             String str = "select * from Book";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setIdEBook(rs.getString(1));
                this.setJudul(rs.getString(2));
                this.setdeskripsi(rs.getString(3));
                this.setFoto(rs.getString(4));
                 data.add(this.getIdEBook());
                 data.add(this.getJudul());
                 data.add(this.getdeskripsi());
                 data.add(this.getFoto());
             }
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
         return data;
   }
   
   public ArrayList GetData(){
        ArrayList data = new ArrayList();
         try
         {
             obj_koneksi.OpenConnection();
             Statement stmt = obj_koneksi.con.createStatement();
             String str = "select * from Book where idEbook = 'B0002'";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setIdEBook(rs.getString(1));
                this.setJudul(rs.getString(2));
                this.setdeskripsi(rs.getString(3));
                this.setFoto(rs.getString(4));
                 data.add(this.getIdEBook());
                 data.add(this.getJudul());
                 data.add(this.getdeskripsi());
                 data.add(this.getFoto());
             }
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
         return data;
   }
   public String getJudulBuku(){
       String yahuu="";
        try
        {
            obj_koneksi.OpenConnection();
            String str = "select * from Book where judul = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, getJudul());
            ResultSet rs = pr.executeQuery();
            if(rs.next())
            {
                yahuu = rs.getString("judul");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return yahuu;
   }
   public ArrayList getRecord(){
   
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.OpenConnection();
            String str = "select * from Book where idEBook = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idEBook);
            ResultSet rs = pr.executeQuery();
            if(rs.next())
            {
                 this.setIdEBook(rs.getString(1));
                this.setJudul(rs.getString(2));
                this.setdeskripsi(rs.getString(3));
                this.setFoto(rs.getString(4));
                 data.add(this.getIdEBook());
                 data.add(this.getJudul());
                 data.add(this.getdeskripsi());
                 data.add(this.getFoto());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
   }
   
   
   public ArrayList cariBook(String search)
    {
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.OpenConnection();
            String str = "select * from Book where judul like ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, "%"+search+"%");
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                this.setIdEBook(rs.getString(1));
                this.setJudul(rs.getString(2));
                this.setdeskripsi(rs.getString(3));
                this.setFoto(rs.getString(4));
                
                data.add(this.getIdEBook());
                data.add(this.getJudul());
                data.add(this.getdeskripsi());
                data.add(this.getFoto());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    
    public String getIdEBook() {
         return idEBook;
    }

    
    public void setIdEBook(String idebook) {
      this.idEBook = idebook;
    }

   
    public String getJudul() {
        return judul;
    }

    
    public void setJudul(String judul) {
        this.judul = judul;
    }

    
    public String getdeskripsi() {
         return deskripsi;
    }

   
    public void setdeskripsi(String deskripsi) {
         this.deskripsi = deskripsi;
    }

  
    public String getFoto() {
       return foto;
    }

   
    public void setFoto(String foto) {
      this.foto = foto;
    }
  
    
 
}
