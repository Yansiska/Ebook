<%-- 
    Document   : login
    Created on : Apr 12, 2018, 2:24:51 PM
    Author     : Jasmine
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.mAdmin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootsrtap Free Admin Template - SIMINTA | Admin Dashboad Template</title>
    <!-- Core CSS - Include with every page -->
    <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
   <link href="assets/css/style.css" rel="stylesheet" />
      <link href="assets/css/main-style.css" rel="stylesheet" />

</head>

<body class="body-Login-back">

    <div class="container">
       
        <div class="row">
            
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">                  
                    
                    <div class="panel-body">
                        <form role="form" action="Login" method="POST">
                            <%
                                                String result = (String)request.getAttribute("return");
                                                if(result != null){
                                                    session = request.getSession(true);
                                                    out.println(result);
                                                }
                                            %>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <
                                <!-- Change this to a button or input when using this as a form -->
                               <button type="submit" class="btn btn-primary">Login</button>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

     <!-- Core Scripts - Include with every page -->
    <script src="assets/plugins/jquery-1.10.2.js"></script>
    <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>

</body>

</html>

