<%-- 
    Document   : htmlcss
    Created on : Apr 16, 2018, 6:22:30 AM
    Author     : Jasmine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.mBook" %>
<%@page import="model.AutoG" %>
<%@page import="config.koneksi" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html lang="en">
     <head>
     <title>Portfolio</title>
     <meta charset="utf-8">
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/touchTouch.css">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/superfish.js"></script>
     <script src="js/touchTouch.jquery.js"></script>
     <script src="js/jquery.equalheights.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script>
      $(function(){
        // Initialize the gallery
        $('.port a.gal').touchTouch();
      });
     </script>
     <!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
         </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <link rel="stylesheet" media="screen" href="css/ie.css">

    <![endif]-->
     </head>
     <body  class="">
<!--==============================header=================================-->
 <header> 
  <div class="container_12">
   <div class="grid_12"> 
    <h1><a href="index.html"><img src="images/logo.png" alt="Boo House"></a> </h1>
    <div class="menu_block">

     <nav  class="" >
      <ul class="sf-menu">
         <li><a href="index.jsp">Home</a></li>
         <li><a href=about.jsp"">about</a></li>
         <li class="current"><a href="ebooks.jsp">Ebooks</a></li>      
       </ul>
    </nav>
    
 <div class="clear"></div>
</div>
<div class="clear"></div>
          </div>
      </div>
</header>

<!--==============================Content=================================-->

<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - September 14, 2013!</div>
  <div class="container_12">
    <div class="grid_12">
      <h3><span>Our Portfolio</span></h3>
    </div>
    <div class="clear"></div>
    <div class="port">
        
        <%
                          String idEbook,judul,deskripsi,foto;
                         
                          idEbook = request.getParameter("id");
                          mBook book = new mBook();
                          ArrayList data = new ArrayList();
                          book.setIdEBook(idEbook);
                          data = book.getRecord();
                          idEbook = (String) data.get(0);
                          judul = (String) data.get(1);
                          deskripsi = (String) data.get(2);
                          foto = "/upload/" + (String) data.get(3);
                      %>
      
        
        <%--
                      <%
                      try{
                        mBook stk = new mBook();
                        ArrayList data = stk.GetData();
                        for(int i = 0;i < data.size()-1;i+=4)
                        {
                            //fac_code, fac_name, fac_email, fac_phone
                                //String idEbook = (String)data.get(i);
                                String judul = (String)data.get(i+1);
                                String deskripsi = (String)data.get(i+2);
                                String foto = "/upload/" + (String) data.get(i+3);      
                                 
                                  out.println("<h1>Judul Ebook</h1><br>");
                                  out.println(judul);
                                  out.println("<br>");
                                  out.println("<h1>Deskripsi</h1><br>");
                                  out.println(deskripsi);
                                  out.println("<br>");
                                  out.println("<h1>Link PDF</h1><br>");
                                  out.println("<a href='upload/html.pdf'> Link Baca </a>");
                        }
                    }
                    catch(Exception ex) {
                        out.println("Data Gagal Ditampilkan" + ex.toString());
                    }


                      %>  --%>                    
                       
       
        
        
    </div>
        <form role="form" action="#" method="POST">
            <div class="form-group">
									<label>ID EBook</label>
                                                                        <input class="form-control" name="id"  value="<%=idEbook%>"  readonly="read read-only" >
                                                                 <div class="form-group">
									<label>Nama</label>
                                                                        <input class="form-control" name="judul" value="<%=judul%>" readonly="read read-only">
								</div>
                                                        
                                                                <div class="form-group">
									<label>Deskripsi</label>
                                                                        <textarea class="form-control" name="alamat" rows="3" required="" readonly="read read-only"> <%=deskripsi%> </textarea>
								</div>
                                                         <div class="form-group">
                                                                    <label>File input</label>
                                                                    <input type="file" id="txt_foto" name="txt_foto" value="<%=foto%>" readonly="read read-only"> 
                                                         </div>
                                                         
                                                         
                      </form>
       
  </div>
                                                         
</div>

<!--==============================footer=================================-->

<footer>    
  <div class="container_12">
    <div class="grid_12">
    <div class="socials">
      <a href="#"></a>
      <a href="#"></a>
      <a href="#"></a>
      <a href="#"></a>
    </div>
      <div class="copy">
      WebDesign (C) 2013 | <a href="#">Privacy Policy</a> | Website Template  designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
      </div>
    </div>
  </div>
</footer>

</body>
</html>
