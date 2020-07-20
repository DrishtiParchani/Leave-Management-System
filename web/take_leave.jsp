<%@include file="header_tech_hod.jsp" %>
<%@include file="flash.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <style>
               
                  body {
    background-image: url("img/teach.jpg");
    background-repeat: no-repeat;
    background-size:  1367px 800px;
}

  #headpro_info_pro{
                  position:fixed;
                left: 40%; 
                 padding-top: -50px;
                font-family: "Lucida Calligraphy";
                color:black;
                font-size: 200%;
            }
           #pos1_info_pro{
                 position:fixed;
                 left : 30%;
                 margin: 65px;
                 padding-top: 30px;
            }
            
             #use11{
                width: 300px;
                height:35px;
                background: white; 
                color: black; 
                outline: none;
                font-size: 15px;
                padding: 5px;

            }
            
                #sub_pro{
                background-color: black;
                color: white;
                border-radius: 4px;
                width:400px;
                height:50px;
                position: fixed;
              
                right:36%;
                font-size: 20px;
            }
</style>

    <body>
       <%
             String uid = (String) session.getAttribute("id");
             String passw = (String) session.getAttribute("passw");
             String cat = (String) session.getAttribute("cat");
             session.setAttribute("uid", uid);
             session.setAttribute("cat", cat);



%>

<h1 id="headpro_info_pro">Take Leave </h1>
         <div id="pos1_info_pro" align="left">
        
      <form action="takeleave"  method="post"  enctype="multipart/form-data">
      
               <select name="leave_type"  id="use">
                        <option>Select Leave Type</option>
                        <option value="casual">Casual Leave</option>
                        <option value="sick">Sick Leave</option>
                        <option value="earn">Earn Leave</option>
                       
                        
                    </select><br><br>
                    
                    To : <input type="date" name="todate"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             From : <input type="date" name="from"> <br><br>
             
           <input type="text" name="des" placeholder="Description" id="use" ><br><br>
           
            Upload Document : <input type="file"   placeholder="Browse" name="doc"  size="50"/><br><br>
            
                        
            <input type="submit" value="Submit" id="sub_pro"/>
          </form><br><br><br>
             
             
         </div>
         

    </body>
</html>
<%@include file="footer.jsp" %>
