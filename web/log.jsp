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
</style>
    <body>
   
         
          <h1 id="headpro">Login </h1>
         <div id="pos1_cust" align="right">
             <form action="login"  method="post" name="f1">
                  <select name="cat"  id="use">
                        <option>Select Option</option>
                        <option value="principle">Principle</option>
                        <option value="HOD">HOD</option>
                        <option value="teacher">Teacher</option>
                       
                        
                    </select><br><br>
            <input type="text" name="username" placeholder="Username" id="use" class="input-block-level validate[required,custom[onlyLetterSp]]"><br><br>
            <input type="password" name="password" placeholder="Password" id="use" class="input-block-level validate[required]"><br><br>
            
            <input type="submit" value="Login" id="sub_cust"/>
          </form><br><br><br>
             
         </div>
        
    </body>
</html>
<%@include file="footer.jsp" %>