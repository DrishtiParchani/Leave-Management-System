<%-- 
    Document   : accept_leave
    Created on : Feb 21, 2018, 12:16:28 AM
    Author     : vs
--%>

<%@page import="pk.main"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        try{
          Connection conn=null; 
         PreparedStatement pst = null;
         
         String id=request.getParameter("id");
         String email=request.getParameter("email");
         String department=request.getParameter("department");
         String leave_type=request.getParameter("leave_type");
         String To=request.getParameter("To");
         String from=request.getParameter("from");
         String description=request.getParameter("description");
         String days=request.getParameter("days");
         String doc_name=request.getParameter("doc_name");
         String allocated_cl=request.getParameter("allocated_cl");
        String taken_cl=request.getParameter("taken_cl");
        String pending_cl=request.getParameter("pending_cl");
         String tablename=(String)session.getAttribute("tablename");
        
        String accept="Accept";
        conn = DB.dbcon.connectDB_con();
         pst = conn.prepareStatement("INSERT INTO `accept_leave_principle`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`,`accept`,`pri_accept`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                  pst.setString(1,id);
                 pst.setString(2,department);
                pst.setString(3,email);
                pst.setString(4,leave_type);
                 pst.setString(5,To);
                pst.setString(6,from);
                 pst.setString(7,days);
                pst.setString(8,description);
                pst.setString(9,doc_name);
                pst.setString(10,allocated_cl);
                pst.setString(11,taken_cl);
                 pst.setString(12,pending_cl);
                 pst.setString(13,accept);
                  pst.setString(14,accept);
                
                int i=0;
                i= pst.executeUpdate();
                
            
                 if (i>0) {
                    System.out.println("   data store  :");
//                    session.setAttribute("flash_message", "Your data store successfully");
//                    session.setAttribute("flash_type", "success");
//                    response.sendRedirect("view.jsp");

                } else {

                    System.out.println(" data not store");
//                   session.setAttribute("flash_message", "Your data is not store successfully, Please try again!");
//                    session.setAttribute("flash_type", "failur");
//                    response.sendRedirect("add_details.jsp");
                    
                }
         

  String sql = "DELETE FROM  `accept_leave_hod` "
                    + "WHERE id = '" + id + "'";
            System.out.println("delete sql " + sql);

            int rs = pst.executeUpdate(sql);
            boolean sendmail=main.sendconfirmationmail(To,from,email);
             if (!sendmail && rs > 0) {
                System.out.println("file is deleted");
                       session.setAttribute("flash_message", "Your Massage Sent to User Mail ID");
                   session.setAttribute("flash_type", "success");
                    response.sendRedirect("leaverequest.jsp");
                              }
               else{
                System.out.println("file is deleted");
       }
              } catch (Exception e) {
                            System.out.println(""+e.getMessage());
                        }
%>
    </body>
</html>
