/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vs
 */
public class adddetails extends HttpServlet {

  
    Connection conn=null; 
         PreparedStatement pst = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             try {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
           HttpSession session = request.getSession();
           
        String cat=request.getParameter("cat");
         String dep=request.getParameter("dep");
         String fullname=request.getParameter("fullname");
         String mobile=request.getParameter("mob");
         String email=request.getParameter("email");
         String add=request.getParameter("add");
         String month=request.getParameter("month");
         String day=request.getParameter("day");
         String year=request.getParameter("year");
         String gen=request.getParameter("gender");
          int cl=Integer.parseInt(request.getParameter("cl"));
          int sl=Integer.parseInt(request.getParameter("sl"));
          int el=Integer.parseInt(request.getParameter("el"));
        String j_month=request.getParameter("j_month");
         String j_day=request.getParameter("j_day");
         String j_year=request.getParameter("j_year");
         
         int randomvalue=main.calran();
    System.out.println("randomvalue: "+randomvalue);
    String p_id="VESP0004"+randomvalue;
    System.out.println(p_id);
    
    Random rand = new Random(); 
                int pass = (rand.nextInt(9999-1000)+1000);
                System.out.println("pass==="+pass);
                String password="Bkje"+pass+"K"+pass;
                 System.out.println("password===="+password);
    
    String birth=day+"-"+month+"-"+year;
            System.out.println("birthday====="+birth);
            
            String joining=j_day+"-"+j_month+"-"+j_year;
            System.out.println("joining====="+joining);
                 System.out.println("category==="+cat);
           conn = DB.dbcon.connectDB_con();
                pst = conn.prepareStatement("INSERT INTO `"+cat+"`(`id`, `department`, `fullname`, `mobile_no`, `email`, `add`, `birthday`, `gender`, `joining_date`, `password`, `cl`, `sl`, `el`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                //pst.setString(1,id);
                pst.setString(1,p_id);
                 pst.setString(2,dep);
                pst.setString(3,fullname);
                pst.setString(4,mobile);
                 pst.setString(5,email);
                pst.setString(6,add);
                pst.setString(7,birth);
                pst.setString(8,gen);
                pst.setString(9,joining);
                pst.setString(10,password);
                 pst.setInt(11,cl);
                 pst.setInt(12,sl);
                 pst.setInt(13,el);
                int i=0;
                i= pst.executeUpdate();
                
              boolean sendmail=main.sendmail(p_id,password,email);
                 if (!sendmail && i>0) {
                    System.out.println("   data store  :");
                    session.setAttribute("flash_message", "Your data store successfully");
                    session.setAttribute("flash_type", "success");
                    response.sendRedirect("view.jsp");
//                    out.println("<script type=\"text/javascript\">");
//                  
//       out.println("alert('Your are register successfully');");
//       out.println("location='reg.jsp';");
//       out.println("</script>");
                } else {

                    System.out.println("   mail not sent  :");
                   session.setAttribute("flash_message", "Your data is not store successfully, Please try again!");
                    session.setAttribute("flash_type", "failur");
                    response.sendRedirect("add_details.jsp");
                    
                }
                System.out.println("-------------------");

                   } catch (ClassNotFoundException ex) {
            Logger.getLogger(adddetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             System.out.println(""+ex.getMessage());
        }
    
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
