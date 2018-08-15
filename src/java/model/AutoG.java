/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.koneksi;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.Statement;
import object.iAutoG;

/**
 *
 * @author user
 */
public class AutoG extends UnicastRemoteObject implements iAutoG {
    private koneksi obj_koneksi = new koneksi();
    public AutoG() throws Exception
    {
        super();
    }
    public String autoidEmployee()
    {
        try 
        {
            obj_koneksi.OpenConnection();
            
            String sql =  "select top 1 id_employee from Employee order by id_employee desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idemployee = null;
            String id = null;
               
            if(rs.next())
            {
                idemployee = rs.getString("id_employee");
                String potong = idemployee.substring(1); //untung memotong id
                int subidemployee = Integer.parseInt(potong) + 1;
                 if(subidemployee<10)
                {
                    id = "E000" + Integer.toString(subidemployee);
                }
                else if(subidemployee<100)
                {
                    id = "E00" + Integer.toString(subidemployee);
                }
                else if(subidemployee<1000)
                {
                    id = "E0" + Integer.toString(subidemployee);
                }
                else if(subidemployee<10000)
                {
                    id = "E" + Integer.toString(subidemployee);
                }
                
            }
            else
            {
                id = "E0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String autoidAdmin()
    {
        try 
        {
            obj_koneksi.OpenConnection();
            
            String sql = "select top 1 id_admin from tb_admin order by id_admin desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idamin = null;
            String id = null;
               
            if(rs.next())
            {
                idamin = rs.getString("id_admin");
                String potong = idamin.substring(1); //untung memotong id
                int subidadmin = Integer.parseInt(potong) + 1;
                 if(subidadmin<10)
                {
                    id = "A000" + Integer.toString(subidadmin);
                }
                else if(subidadmin<100)
                {
                    id = "A00" + Integer.toString(subidadmin);
                }
                else if(subidadmin<1000)
                {
                    id = "A0" + Integer.toString(subidadmin);
                }
                else if(subidadmin<10000)
                {
                    id = "A" + Integer.toString(subidadmin);
                }
                
            }
            else
            {
                id = "A0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    
    public String autoidBook()
    {
        try 
        {
            obj_koneksi.OpenConnection();
            
            String sql = "select top 1 idEbook from Book order by idEbook desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idamin = null;
            String id = null;
               
            if(rs.next())
            {
                idamin = rs.getString("idEBook");
                String potong = idamin.substring(1); //untung memotong id
                int subidadmin = Integer.parseInt(potong) + 1;
                 if(subidadmin<10)
                {
                    id = "B000" + Integer.toString(subidadmin);
                }
                else if(subidadmin<100)
                {
                    id = "B00" + Integer.toString(subidadmin);
                }
                else if(subidadmin<1000)
                {
                    id = "B0" + Integer.toString(subidadmin);
                }
                else if(subidadmin<10000)
                {
                    id = "B" + Integer.toString(subidadmin);
                }
                
            }
            else
            {
                id = "B0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    
    public String autoidRbook()
    {
        try 
        {
            obj_koneksi.OpenConnection();
            
            String sql = "select top 1 id_RBook from RBook order by id_RBook desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idamin = null;
            String id = null;
               
            if(rs.next())
            {
                idamin = rs.getString("id_RBook");
                String potong = idamin.substring(1); //untung memotong id
                int subidadmin = Integer.parseInt(potong) + 1;
                 if(subidadmin<10)
                {
                    id = "R000" + Integer.toString(subidadmin);
                }
                else if(subidadmin<100)
                {
                    id = "R00" + Integer.toString(subidadmin);
                }
                else if(subidadmin<1000)
                {
                    id = "R0" + Integer.toString(subidadmin);
                }
                else if(subidadmin<10000)
                {
                    id = "R" + Integer.toString(subidadmin);
                }
                
            }
            else
            {
                id = "R0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
}
