<%@include file="header_pri.jsp" %>
<%@include file="flash.jsp" %>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/style.css">

<!DOCTYPE html>
<html>
    <head>
          <style>
              
                               body {
    background-image: url("img/pri2.jpg");
    background-repeat: no-repeat;
    background-size:  1367px 800px;
}
        #bor{
                    margin-left: 20%;
                    border-radius: 25px;
                    border: 3px solid black;
                    padding: 20px; 
                    width: 900px;
                    height: 400px; 
                   
        }
     
       
        td {
            
          color:white;
            font-size:150%;
           
/*            text-align: left;*/
/*            padding: 10px;*/
        }
        h1{
            color: white;
        }
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
       Connection conn=null; 
         PreparedStatement pst = null;
        
            String department=null,id=null,fullname=null,mobile_no=null,email=null,add=null,birthday=null,gender=null,leave=null,joining_date=null;
        int cl=0,sl=0,el=0;
             String uid = (String) session.getAttribute("id");
             String passw = (String) session.getAttribute("passw");
             String cat = (String) session.getAttribute("cat");
             session.setAttribute("uid", uid);
             session.setAttribute("cat", cat);
           
               try {
            conn = DB.dbcon.connectDB_con();
                        String q="SELECT * FROM `"+cat+"` WHERE id = ?";
                        System.out.println(q);
                        pst = conn.prepareStatement(q);
                        pst.setString(1, uid);
                       
                        ResultSet rs = pst.executeQuery();
                        while (rs.next()) {
                                            id = rs.getString("id");
                                            department = rs.getString("department");
                                            fullname = rs.getString("fullname");
                                            mobile_no = rs.getString("mobile_no");
                                            email = rs.getString("email");
                                            add = rs.getString("add");
                                            birthday = rs.getString("birthday");
                                            gender = rs.getString("gender");
                                            cl = rs.getInt("cl");
                                             sl = rs.getInt("sl");
                                              el = rs.getInt("el");
                                            joining_date = rs.getString("joining_date");
                                            
                                       
             
         
         
         %>
  <form method="post">
       
           <center> <h1>Details</h1></center>
      
  <table  id="bor">
     
      
                      <tr>
                            <td height="10"> 
                               <b> User ID : </b>  <%= id%>
                            </td>
                            
                            <td> 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>  Department :</b> <%=department%>
                            </td>
                            
                           
                    </tr>     
                    
                       <tr>
                            <td height="10"> 
                               <b> Name : </b>  <%= fullname%>
                            </td>
                            
                            <td> 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>  Mobile No. :</b> <%=mobile_no%>
                            </td>
                            
                           
                    </tr>     
      
                    
                          </tr>     
                    
                       <tr>
                            <td height="10"> 
                               <b> Email ID : </b>  <%= email%>
                            </td>
                            
                            <td> 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>  Address :</b> <%=add%>
                            </td>
                            
                           
                    </tr>     
      
      <tr>
                            <td height="10"> 
                               <b> Birth Of Date : </b>  <%= birthday%>
                            </td>
                            
                            <td> 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>  Joining Date :</b> <%=joining_date%>
                            </td>
                            
                           
                    </tr>     
                    
                          <tr>
                            <td height="10"> 
                               <b> Gender : </b>  <%= gender%>
                            </td>
                            
                            <td> 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>  Casual Leave :</b> <%=cl%>
                            </td>
                            
                           
                    </tr> 
                    
                     </tr>     
                    
                          <tr>
                            <td height="10"> 
                               <b> Sick Leave : </b>  <%= sl%>
                            </td>
                            
                            <td> 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>  Earned Leave :</b> <%=el%>
                            </td>
                            
                           
                    </tr> 
          
         <%
                   }
            } catch (Exception e) {
                                e.printStackTrace();
                            }
        
%>
         </table>  
       
  </form>
    </body>
</html>
<%@include file="footer.jsp" %>