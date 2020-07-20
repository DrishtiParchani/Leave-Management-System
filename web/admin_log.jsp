<%-- 
    Document   : reg
    Created on : Dec 28, 2017, 7:29:31 PM
    Author     : vs
--%>
<%@include file="header.jsp" %>
<%@include file="flash.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>JSP Page</title>
    </head>
    <style>
               
                  body {
    background-image: url("img/adminlog1.jpg");
    background-repeat: no-repeat;
    background-size:  1367px 800px;
}
#headpro_cust{
                  position:fixed;
                left: 37.5%; 
                 padding-top: 50px;
                font-family: "Lucida Calligraphy";
                color:white;
                font-size: 300%;
            }
</style>
    <body>
   
         
          <h1 id="headpro_cust">Admin Login </h1>
         <div id="pos1_cust" align="right">
         <form action="admin_login"  method="post" name="f1" onsubmit="return validate();">
      
<!--            <input type="text" name="id" placeholder="Student ID" id="use" class="input-block-level validate[required]"><br>-->
            <input type="text" name="username" placeholder="Username" id="use" class="input-block-level validate[required,custom[onlyLetterSp]]"><br><br>
            <input type="password" name="password" placeholder="Password" id="use" class="input-block-level validate[required]"><br><br>
            
            <input type="submit" value="Admin Login" id="sub_cust"/>
          </form><br><br><br>
             
         </div>
        
    </body>
</html>
<%@include file="footer.jsp" %>
