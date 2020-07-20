<%@include file="header_pri.jsp" %>
<%@include file="flash.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
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
       <form action="leaverequest_pri.jsp" method="post">

  
   <div> 
      <select id="combo" name="leave">
           <option>Select Leave Type</option>
                        <option value="casual">Casual Leave</option>
                        <option value="sick">Sick Leave</option>
                        <option value="earn">Earn Leave</option>
                        
    </select><br><br>
    
   
        <input type="submit" value="Submit" id="sub_cat"/>
  </div>
 

 </form>
    </body>
</html>
<%@include file="footer.jsp" %>
