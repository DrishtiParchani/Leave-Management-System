/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author vs
 */
public class takeleave extends HttpServlet {

  Connection conn=null; 
         PreparedStatement pst = null;
           PreparedStatement pst1 = null;
         String department=null,id=null,fullname=null,mobile_no=null,email=null,add=null,birthday=null,gender=null,leave=null,joining_date=null;
        int cl=0,sl=0,el=0;
         int pending_cl =0,taken_cl=0;
        boolean isMultipart;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
             
                  try {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    HttpSession session=request.getSession(true);
    
     String uid = (String) session.getAttribute("id");
                      System.out.println("uid==="+uid);
         String passw = (String) session.getAttribute("passw");
         String cat = (String) session.getAttribute("cat");
         session.setAttribute("uid", uid);
         session.setAttribute("cat", cat);
         
          isMultipart = ServletFileUpload.isMultipartContent(request);
               MultipartRequest multipartRequest=new MultipartRequest(request,getServletContext().getRealPath("/")+"datafile1", 1024*1024*1024);
      
         
         String leave_type=multipartRequest.getParameter("leave_type");
         String backup=leave_type+"back";
                      System.out.println("backup table====="+backup);
//         
     String to=multipartRequest.getParameter("todate");
      System.out.println("tovalue==="+to);
     
     DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
     
     Date date = format.parse(to);
    System.out.println("date====="+date);
    Calendar cal = Calendar.getInstance();
cal.setTime(date);
    int month = cal.get(Calendar.MONTH)+1;
    int year = cal.get(Calendar.YEAR);
     int day = cal.get(Calendar.DAY_OF_MONTH);
     String todate=day+"-"+month+"-"+year;
                      System.out.println("todate==="+todate);
                      System.out.println("month==="+month);
                        System.out.println("day==="+day);
                          System.out.println("year==="+year);

       
         String from=multipartRequest.getParameter("from");
         System.out.println("from==="+from);
         Date datefrom = format.parse(from);
                      System.out.println("datefrom====="+datefrom);
       
        Calendar calfrom = Calendar.getInstance();
calfrom.setTime(datefrom);
    int monthfrom = calfrom.get(Calendar.MONTH)+1;
    int yearfrom = calfrom.get(Calendar.YEAR);
     int dayfrom = calfrom.get(Calendar.DAY_OF_MONTH);
     String fromdate=dayfrom+"-"+monthfrom+"-"+yearfrom;
                      System.out.println("fromdate==="+fromdate);
                      System.out.println("monthfrom==="+monthfrom);
                        System.out.println("dayfrom==="+dayfrom);
                          System.out.println("yearfrom==="+yearfrom);

                          
                          long diff = Math.abs(datefrom.getTime() - date.getTime());
                          long diffDays = diff / (24 * 60 * 60 * 1000);
                      System.out.println("diffDays====="+diffDays);
                          
                          
         String des=multipartRequest.getParameter("des");
          
         
                File file1 = multipartRequest.getFile("doc");
                String absolutePath = file1.getAbsolutePath();
                System.out.println("absolutePath:" + absolutePath);
                FileInputStream fi1=new FileInputStream(file1);
                String fname = file1.getName();
                //fname=fname.toLowerCase();
                int index = fname.lastIndexOf(".");
                String ftype = fname.substring(index + 1);
                System.out.println("type:" + ftype);
                //String fullfilename=fname+"."+ftype;
         
         
      
                
                
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
                                        
                                     }
                   
                    
                    
                if(leave_type.equalsIgnoreCase("Casual")){
                    
                     String q1="SELECT * FROM `"+backup+"` WHERE id = ?";
                    System.out.println(q);
                    pst = conn.prepareStatement(q1);
                    pst.setString(1, uid);
                   
                    ResultSet rs1 = pst.executeQuery();
                    while (rs1.next()) {
                                        id = rs1.getString("id");
                                        department = rs1.getString("department");
                                        taken_cl = rs1.getInt("taken_cl");
                                         pending_cl = rs1.getInt("pending_cl");
                                        
                                     }
                     if(pending_cl==0){   
                         
               long p_leave= cl-diffDays;
              pst1 = conn.prepareStatement("INSERT INTO `"+leave_type+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1,id);
                 pst1.setString(2,department);
                pst1.setString(3,email);
                pst1.setString(4,leave_type);
                 pst1.setString(5,todate);
                pst1.setString(6,fromdate);
                 pst1.setLong(7,diffDays);
                pst1.setString(8,des);
                pst1.setString(9,fname);
                pst1.setInt(10,cl);
                pst1.setLong(11,diffDays);
                 pst1.setLong(12,p_leave);
                
                int j=0;
                j= pst1.executeUpdate();
              
              
              pst = conn.prepareStatement("INSERT INTO `"+backup+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                
                  pst.setString(1,id);
                 pst.setString(2,department);
                pst.setString(3,email);
                pst.setString(4,leave_type);
                 pst.setString(5,todate);
                pst.setString(6,fromdate);
                 pst.setLong(7,diffDays);
                pst.setString(8,des);
                pst.setString(9,fname);
                pst.setInt(10,cl);
                pst.setLong(11,diffDays);
                 pst.setLong(12,p_leave);
                
                int i=0;
                i= pst.executeUpdate();
                
            
                 if (i>0 && j>0) {
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
                 
                 }else
                 {
                      long p_leave1= pending_cl-diffDays;
                      long tak_leave=taken_cl+diffDays;
//                      String qry="update `"+leave_type+"` set id='"+id+"',department='"+department+"',email='"+email+"',leave_type='"+leave_type+"',To='"+todate+"',from='"+fromdate+"',description='"+des+"',doc_name='"+fname+"',allocated_cl='"+cl+"',taken_cl='"+tak_leave+"',pending_cl='"+p_leave1+"' where id="+id+"";
//                       pst.executeUpdate(qry);
                      
                      
                      pst1 = conn.prepareStatement("INSERT INTO `"+leave_type+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                  
                       pst1.setString(1,id);
                 pst1.setString(2,department);
                pst1.setString(3,email);
                pst1.setString(4,leave_type);
                 pst1.setString(5,todate);
                pst1.setString(6,fromdate);
                 pst1.setLong(7,diffDays);
                pst1.setString(8,des);
                pst1.setString(9,fname);
                pst1.setInt(10,cl);
                pst1.setLong(11,tak_leave);
                 pst1.setLong(12,p_leave1);
                
                int j=0;
                j= pst1.executeUpdate();
                
                      
                      
                pst = conn.prepareStatement("INSERT INTO `"+backup+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                      
                  pst.setString(1,id);
                 pst.setString(2,department);
                pst.setString(3,email);
                pst.setString(4,leave_type);
                 pst.setString(5,todate);
                pst.setString(6,fromdate);
                 pst.setLong(7,diffDays);
                pst.setString(8,des);
                pst.setString(9,fname);
                pst.setInt(10,cl);
                pst.setLong(11,tak_leave);
                 pst.setLong(12,p_leave1);
                
                int i=0;
                i= pst.executeUpdate();
                
            
                 if (i>0 && j>0) {
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
                      
                       System.out.println("===update table====");
                 }
                }  
                 
                 
                 
                 
                 
                 
                 if(leave_type.equalsIgnoreCase("Sick")){
                    String q1="SELECT * FROM `"+backup+"` WHERE id = ?";
                    System.out.println(q);
                    pst = conn.prepareStatement(q1);
                    pst.setString(1, uid);
                   
                    ResultSet rs1 = pst.executeQuery();
                    while (rs1.next()) {
                                        id = rs1.getString("id");
                                        department = rs1.getString("department");
                                        taken_cl = rs1.getInt("taken_cl");
                                         pending_cl = rs1.getInt("pending_cl");
                                        
                                     }
                     if(pending_cl==0){   
                         
               long p_leave= cl-diffDays;
              pst1 = conn.prepareStatement("INSERT INTO `"+leave_type+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                 pst1.setString(1,id);
                 pst1.setString(2,department);
                pst1.setString(3,email);
                pst1.setString(4,leave_type);
                 pst1.setString(5,todate);
                pst1.setString(6,fromdate);
                 pst1.setLong(7,diffDays);
                pst1.setString(8,des);
                pst1.setString(9,fname);
                pst1.setInt(10,cl);
                pst1.setLong(11,diffDays);
                 pst1.setLong(12,p_leave);
                
                int j=0;
                j= pst1.executeUpdate();
                
              
              
              pst = conn.prepareStatement("INSERT INTO `"+backup+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                  pst.setString(1,id);
                 pst.setString(2,department);
                pst.setString(3,email);
                pst.setString(4,leave_type);
                 pst.setString(5,todate);
                pst.setString(6,fromdate);
                 pst.setLong(7,diffDays);
                pst.setString(8,des);
                pst.setString(9,fname);
                pst.setInt(10,cl);
                pst.setLong(11,diffDays);
                 pst.setLong(12,p_leave);
                
                int i=0;
                i= pst.executeUpdate();
                
            
                 if (i>0 && j>0) {
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
                 
                 }else
                 {
                      long p_leave1= pending_cl-diffDays;
                      long tak_leave=taken_cl+diffDays;
//                      String qry="update `"+leave_type+"` set id='"+id+"',department='"+department+"',email='"+email+"',leave_type='"+leave_type+"',To='"+todate+"',from='"+fromdate+"',description='"+des+"',doc_name='"+fname+"',allocated_cl='"+cl+"',taken_cl='"+tak_leave+"',pending_cl='"+p_leave1+"' where id="+id+"";
//                       pst.executeUpdate(qry);
                      
                      pst1 = conn.prepareStatement("INSERT INTO `"+leave_type+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                      
                  pst1.setString(1,id);
                 pst1.setString(2,department);
                pst1.setString(3,email);
                pst1.setString(4,leave_type);
                 pst1.setString(5,todate);
                pst1.setString(6,fromdate);
                 pst1.setLong(7,diffDays);
                pst1.setString(8,des);
                pst1.setString(9,fname);
                pst1.setInt(10,cl);
                pst1.setLong(11,tak_leave);
                 pst1.setLong(12,p_leave1);
                
                int j=0;
                j= pst1.executeUpdate();
                
               
                      
                      
                      pst = conn.prepareStatement("INSERT INTO `"+backup+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                
                      
                  pst.setString(1,id);
                 pst.setString(2,department);
                pst.setString(3,email);
                pst.setString(4,leave_type);
                 pst.setString(5,todate);
                pst.setString(6,fromdate);
                 pst.setLong(7,diffDays);
                pst.setString(8,des);
                pst.setString(9,fname);
                pst.setInt(10,cl);
                pst.setLong(11,tak_leave);
                 pst.setLong(12,p_leave1);
                
                int i=0;
                i= pst.executeUpdate();
                
            
                 if (i>0 && j>0) {
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
                      
                       System.out.println("===update table====");
                 }
                } 
                 
                 
                  if(leave_type.equalsIgnoreCase("Earn")){
                    String q1="SELECT * FROM `"+backup+"` WHERE id = ?";
                    System.out.println(q);
                    pst = conn.prepareStatement(q1);
                    pst.setString(1, uid);
                   
                    ResultSet rs1 = pst.executeQuery();
                    while (rs1.next()) {
                                        id = rs1.getString("id");
                                        department = rs1.getString("department");
                                        taken_cl = rs1.getInt("taken_cl");
                                         pending_cl = rs1.getInt("pending_cl");
                                        
                                     }
                     if(pending_cl==0){   
                         
               long p_leave= cl-diffDays;
              pst1 = conn.prepareStatement("INSERT INTO `"+leave_type+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
              
               pst1.setString(1,id);
                 pst1.setString(2,department);
                pst1.setString(3,email);
                pst1.setString(4,leave_type);
                 pst1.setString(5,todate);
                pst1.setString(6,fromdate);
                 pst1.setLong(7,diffDays);
                pst1.setString(8,des);
                pst1.setString(9,fname);
                pst1.setInt(10,cl);
                pst1.setLong(11,diffDays);
                 pst1.setLong(12,p_leave);
                
                int j=0;
                j= pst1.executeUpdate();
              
              
              pst = conn.prepareStatement("INSERT INTO `"+backup+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                
                  pst.setString(1,id);
                 pst.setString(2,department);
                pst.setString(3,email);
                pst.setString(4,leave_type);
                 pst.setString(5,todate);
                pst.setString(6,fromdate);
                 pst.setLong(7,diffDays);
                pst.setString(8,des);
                pst.setString(9,fname);
                pst.setInt(10,cl);
                pst.setLong(11,diffDays);
                 pst.setLong(12,p_leave);
                
                int i=0;
                i= pst.executeUpdate();
                
            
                 if (i>0 && j>0) {
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
                 
                 }else
                 {
                      long p_leave1= pending_cl-diffDays;
                      long tak_leave=taken_cl+diffDays;
//                      String qry="update `"+leave_type+"` set id='"+id+"',department='"+department+"',email='"+email+"',leave_type='"+leave_type+"',To='"+todate+"',from='"+fromdate+"',description='"+des+"',doc_name='"+fname+"',allocated_cl='"+cl+"',taken_cl='"+tak_leave+"',pending_cl='"+p_leave1+"' where id="+id+"";
//                       pst.executeUpdate(qry);
                      
                      pst1 = conn.prepareStatement("INSERT INTO `"+leave_type+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                  pst1.setString(1,id);
                 pst1.setString(2,department);
                pst1.setString(3,email);
                pst1.setString(4,leave_type);
                 pst1.setString(5,todate);
                pst1.setString(6,fromdate);
                 pst1.setLong(7,diffDays);
                pst1.setString(8,des);
                pst1.setString(9,fname);
                pst1.setInt(10,cl);
                pst1.setLong(11,tak_leave);
                 pst1.setLong(12,p_leave1);
                
                int j=0;
                j= pst1.executeUpdate();
                    
                      
                      
                       pst = conn.prepareStatement("INSERT INTO `"+backup+"`(`id`, `department`, `email`, `leave_type`, `To`, `from`,`days`, `description`, `doc_name`, `allocated_cl`, `taken_cl`, `pending_cl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                
                  pst.setString(1,id);
                 pst.setString(2,department);
                pst.setString(3,email);
                pst.setString(4,leave_type);
                 pst.setString(5,todate);
                pst.setString(6,fromdate);
                 pst.setLong(7,diffDays);
                pst.setString(8,des);
                pst.setString(9,fname);
                pst.setInt(10,cl);
                pst.setLong(11,tak_leave);
                 pst.setLong(12,p_leave1);
                
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
                      
                       System.out.println("===update table====");
                 }
                }  
                
                    
                    session.setAttribute("flash_message", "Your Request Is Sent to HOD!!!!");
                    session.setAttribute("flash_type", "success");
                    response.sendRedirect("take_leave.jsp");
                    
                    
        } catch (Exception e) {
                            System.out.println(""+e.getMessage());
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
