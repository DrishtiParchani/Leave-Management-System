<%@include file="header_admin.jsp" %>
<%@include file="flash.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        body{
              background-image: url("img/combo1.jpg");
    background-repeat: no-repeat;
    background-size:  1367px 800px;
        }
    #sub_cat{
         background-color: black;
                color: white;
                border-radius: 4px;
                width:400px;
                height:50px;
                position: fixed;
                margin-top: 150px;
                left:32%;
                font-size: 20px;
    }     
  
 </style>
 
    <body>
       <form action="viewdata.jsp" method="post">

  
   <div> 
      <select id="combo" name="cat">
           <option>Select Category</option>
                        
                        <option value="principle">Principle</option>
                        <option value="HOD">HOD</option>
                        <option value="teacher">Teacher</option>
                        
    </select><br><br>
    
     <div> 
      <select id="combo1" name="dep">
           <<option>Select Department</option>
                        <option value="all">All</option>
                        <option value="Computer Technology">Computer Technology</option>
                        <option value="Computer Engineering">Computer Engineering</option>
                        <option value="Electronics & Telecommunication">Electronics & Telecommunication</option>
                        <option value="Electrical Engineering">Electrical Engineering</option>
                        
    </select>
        <input type="submit" value="Submit" id="sub_cat"/>
  </div>
 
</div>
 </form>
    </body>
</html>
<%@include file="footer.jsp" %>
