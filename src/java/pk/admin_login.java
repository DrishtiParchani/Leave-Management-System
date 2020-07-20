/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class admin_login extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
           
             String un=request.getParameter("username");
             String pass=request.getParameter("password");
             System.out.println("username==="+un);
              System.out.println("password==="+pass);
                
                Connection conn=null; 
                 PreparedStatement pst = null;
                 String id = null;
              
                 String na = null;
                 String passw = null;
                  
                 HttpSession ht=request.getSession(true);
                  
                   conn = DB.dbcon.connectDB_con();
                  String q="SELECT * FROM admin_data WHERE username = ? and password=?";
                   pst = conn.prepareStatement(q);
                    pst.setString(1, un);
                    pst.setString(2, pass);
                    ResultSet rs = pst.executeQuery();

                                while (rs.next()) {
                                        id = rs.getString("id");
                                        na = rs.getString("username");
                                        passw = rs.getString("password");
                                       
                                   
                                        }
               
                                
                     System.out.println("database value"+na+"===="+passw);
                     if(un.equals(na) && pass.equals(passw))
                 {
                    ht.setAttribute("flash_message", "Your are loging successfully");
                    ht.setAttribute("flash_type", "success");
                     System.out.println("login successfully");
                    response.sendRedirect("admin_panel.jsp");

//                     RequestDispatcher rd=request.getRequestDispatcher("fill_form.jsp");
//                     rd.forward(request, response);
                 }
                
                 else{
                    ht.setAttribute("flash_message", "Username and Password Incorrect");
                    ht.setAttribute("flash_type", "success");
                    response.sendRedirect("admin_log.jsp");
               
               //response.sendRedirect("AdminLogin.jsp");   
                 }
//                     ht.setAttribute("id", id); 
//                     ht.setAttribute("na", na);
//                     ht.setAttribute("passw", passw);
//                   
                     
        } catch (ClassNotFoundException ex) {
           System.out.println(""+ex.getMessage());
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
