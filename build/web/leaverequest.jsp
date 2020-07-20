<%@include file="header_hod.jsp" %>
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
   
     background-image: url("img/hod1.jpg");
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
        
            String department=null,id=null,leave_type=null,To=null,from=null,email=null,description=null,doc_name=null;
            int days=0,allocated_cl=0,taken_cl=0,pending_cl=0;
                String dep=(String)session.getAttribute("dep");
                System.out.println("dep==="+dep);
                String tablename=request.getParameter("leave");
                System.out.println("tablename===="+tablename);
                session.setAttribute("tablename", tablename);
               try {
            conn = DB.dbcon.connectDB_con();
                        String q="SELECT * FROM `"+tablename+"` WHERE department= ?";
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
                 <th>Email ID</th>
                 <th>Leave Type</th>
                 <th>To</th>
                 <th>From</th>
                 <th>Days</th>
                  <th>Description</th>
                  <th>Doc Name</th>
                  <th>Allocated Leave</th>
                  <th>Taken Leave</th>
                  <th>Pending Leave</th>
                  <th>Accept</th>
                  <th>Reject</th>
                 
                
        </tr>
          <% while (rs.next()) {
                                            id = rs.getString("id");
                                            department = rs.getString("department");
                                          
                                            email = rs.getString("email");
                                            leave_type = rs.getString("leave_type");
                                            To = rs.getString("To");
                                            from = rs.getString("from");
                                            days = rs.getInt("days");
                                            description= rs.getString("description");
                                            doc_name = rs.getString("doc_name");
                                            allocated_cl = rs.getInt("allocated_cl");
                                            taken_cl = rs.getInt("taken_cl");
                                            pending_cl = rs.getInt("pending_cl");
                                
                        %>
           <tr>
               
             <td><%=id%></td>   
             <td><%=department%></td>
             <td><%=email%></td>
             <td><%=leave_type%></td>
             <td><%=To%></td>
             <td><%=from%></td>
             <td><%=days%></td>
             <td><%=description%></td>
             <td><%=doc_name%></td>
             <td><%=allocated_cl%></td>
               <td><%=taken_cl%></td>
             <td><%=pending_cl%></td>
             <td><a href="accept_leave.jsp?id=<%=id%> &email=<%=email%>&department=<%=department%>&leave_type=<%=tablename%> &To=<%=To%>&from=<%=from%>&description=<%=description%> &days=<%=days%>&doc_name=<%=doc_name%>&allocated_cl=<%=allocated_cl%> &taken_cl=<%=taken_cl%>&pending_cl=<%=pending_cl%>">Accept</a></td>
             <td><a href="rejcect_leave.jsp?id=<%=id%> &email=<%=email%>&department=<%=department%>&leave_type=<%=leave_type%> &To=<%=To%>&from=<%=from%>&description=<%=description%> &days=<%=days%>&doc_name=<%=doc_name%>&allocated_cl=<%=allocated_cl%> &taken_cl=<%=taken_cl%>&pending_cl=<%=pending_cl%>">Reject</a></td>
             
            
             
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