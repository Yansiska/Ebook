/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mBook;
import org.apache.commons.fileupload.FileItem;
import rmn.Upload;

/**
 *
 * @author Jasmine
 */
@WebServlet(urlPatterns = {"/UpdateBook"})
public class UpdateBook extends HttpServlet {
mBook book = new mBook();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             try{
                //mBook book = new mBook();
                String name,value;
            
                Upload obj = new Upload();
                String uploadPath = obj.r_configureUpload(getServletContext().getRealPath(""), "upload");
           
                List<FileItem>formItems = obj.r_upload.parseRequest(request);
         
                if(formItems != null && formItems.size() > 0)
                {
                    for(FileItem item : formItems){
                        if(!item.isFormField()){
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            
                            item.write(storeFile);
                            
                           book.setFoto(fileName);
                        }
                        if(item.isFormField()){
                            name = item.getFieldName();
                            value = item.getString();
                            if(name.equals("id")){
                                book.setIdEBook(value);
                            }
                            if(name.equals("judul")){
                                book.setJudul(value);
                            }
                            if(name.equals("deskripsi")){
                                book.setdeskripsi(value);
                            }
                            
                        }
                    }
                    
                }
            
        }
           catch(Exception e)
           {
               
               
           }
         int i = book.doUpdate();
           if (i > 0)
           {
               response.sendRedirect("tables_book.jsp?infosukses");
           }
           else {
                response.sendRedirect("tables_book.jsp?infogagal");
           }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
