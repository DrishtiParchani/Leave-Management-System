<%@include file="header_admin.jsp" %>
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
          body{
   
     background-image: url("img/view.jpg");
       background-repeat: no-repeat;
       background-size:  1400px 700px;
   
}
          td{
           border: 1px solid black;   
           padding: 5px;
           color: red;
            font-size: 130%;
          }
          table
          {
           background-color: whitesmoke;
           padding: 5px;
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
            String tablename=request.getParameter("cat");
            String dep=request.getParameter("dep");
            System.out.println("viewdata.jsp : : :"+dep+"tablename::::::"+tablename);
           
               try {
            conn = DB.dbcon.connectDB_con();
                        String q="SELECT * FROM `"+tablename+ "` WHERE department = ?";
                        System.out.println(q);
                        pst = conn.prepareStatement(q);
                        pst.setString(1, dep);
                       
                        ResultSet rs = pst.executeQuery();
         
         
         %>
  <form method="post">
       <div class="container">
           <center> <h1>Details</h1></center>
      
  <table align="center" class="" style="border: 5px solid goldenrod">
        <tr>
                 <th>Id</th>
                 <th>department</th>
                 <th>Name</th>
                 <th>Mobile No.</th>
                 <th>Email ID</th>
                 <th>Address</th>
                 <th>DOB</th>
                 <th>Gender</th>
                 <th>Joining Date</th>
                  <th>Casual Leave</th>
                  <th>Sick Leave</th>
                  <th>Earned Leave</th>
                 
                
        </tr>
          <% while (rs.next()) {
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
           <tr>
               
             <td><%=id%></td>   
             <td><%=department%></td>
             <td><%=fullname%></td>
             <td><%=mobile_no%></td>
             <td><%=email%></td>
             <td><%=add%></td>
             <td><%=birthday%></td>
             <td><%=gender%></td>
             <td><%=joining_date%></td>
             <td><%=cl%></td>
             <td><%=sl%></td>
             <td><%=el%></td>
            
             
           </tr>
         <%
                   }
            } catch (Exception e) {
                                e.printStackTrace();
                            }
        
%>
         </table>  
       </div>
  </form>
    </body>
</html>
<%@include file="footer.jsp" %>