<%-- 
    Document   : edit_admin
    Created on : Apr 9, 2018, 10:52:12 AM
    Author     : Jasmine
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="model.mAdmin"%>
<%@page import="model.AutoG" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Tables</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Dashboard</span>Admin</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="Logout"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="">
			
		</form>
		<ul class="nav menu">
			<li class="active"><a href="index.html"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Home</a></li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-1"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span> Admin 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="input_admin.jsp">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Insert
						</a>
					</li>
					<li>
						<a class="" href="tables_admin.jsp">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> View
						</a>
					</li>
				</ul>
			</li>
                        <li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-3"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-right"></use></svg></span> Ebook 
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li>
						<a class="" href="input_book.jsp">
							<svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-right"></use></svg> Insert
						</a>
					</li>
					<li>
						<a class="" href="tables_book.jsp">
							<svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg> View
						</a>
					</li>
				</ul>
			</li>
			
		</ul>
		
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Icons</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Tables</h1>
			</div>
		</div><!--/.row-->
			<%
                          String idadmin,nama_admin,alamat_admin,username,password;
                         
                          idadmin = request.getParameter("id");
                          mAdmin admin = new mAdmin();
                          ArrayList data = new ArrayList();
                          admin.setIdadmin(idadmin);
                          data = admin.getRecord();
                          idadmin = (String) data.get(0);
                          nama_admin = (String) data.get(1);
                          alamat_admin = (String) data.get(2);
                          username = (String)data.get(3);
                          password = (String)data.get(4);
                          
                      %>
               
        <form role="form" action="#" method="POST">
            <div class="form-group">
									<label>ID Admin</label>
                                                                        <input class="form-control" name="id"  value="<%=idadmin%>"  readonly="read read-only" >
                                                                 <div class="form-group">
									<label>Nama</label>
                                                                        <input class="form-control" name="nama" value="<%=nama_admin%>" readonly="read read-only">
								</div>
                                                        
                                                                <div class="form-group">
									<label>Alamat</label>
                                                                        <textarea class="form-control" name="alamat" rows="3" required="" readonly="read read-only"> <%=alamat_admin%> </textarea>
								</div>
                                                        
                                                                <div class="form-group">
									<label>Username</label>
                                                                        <input class="form-control" name="user" required="" readonly="read read-only" value="<%=username%>">
								</div>
																
								<div class="form-group">
									<label>Password</label>
                                                                        <input type="password" class="form-control" name="pass" required="" readonly="read read-only" value="<%=password%>">
								</div>
								
								<!--						
								<div class="form-group">
									<label>File input</label>
									<input type="file">
									 <p class="help-block">Example block-level help text here.</p>
								</div>
								-->
								<button type="submit" class="btn btn-primary">Submit Button</button>
								
							</div>
						</form>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>

