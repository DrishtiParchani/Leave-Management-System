package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class take_005fleave_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/header_tech_hod.jsp");
    _jspx_dependants.add("/flash.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("   \n");
      out.write("       <li> <a href=\"homepage.jsp\">Logout</a></li>\n");
      out.write("       <li><a href=\"view.jsp\">Chack Leave Status</a></li>\n");
      out.write("       <li><a href=\"take_leave.jsp\">Take Leave</a></li>\n");
      out.write("       <li><a href=\"teacher.jsp\">View Profile</a></li>\n");
      out.write("       <li><a href=\"homepage.jsp\">Home</a></li>\n");
      out.write("       <a href=\"homepage.jsp\"><div id=\"name\"><li><b>VESP</b></li></div></a>\n");
      out.write("    \n");
      out.write("  \n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write('\n');

    //checking if flash message is set
    String flash_message = (String) session.getAttribute("flash_message");
    if (flash_message != null) {
        String flash_type = (String) session.getAttribute("flash_type");
        if (flash_type == null) {
            flash_type = "success";
        }
        session.removeAttribute("flash_message");
        session.removeAttribute("flash_type");

      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"alert alert-");
      out.print(flash_type);
      out.write("\">\n");
      out.write("        <button class=\"close\" data-dismiss=\"alert\"></button>\n");
      out.write("        <strong>");
      out.print(flash_type);
      out.write("!</strong> ");
      out.print(flash_message);
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("     <style>\n");
      out.write("               \n");
      out.write("                  body {\n");
      out.write("/*    background-image: url(\"img/vegetables_addpro.jpg\");\n");
      out.write("    background-repeat: no-repeat;\n");
      out.write("    background-size:  1367px 800px;*/\n");
      out.write("}\n");
      out.write("\n");
      out.write("  #headpro_info_pro{\n");
      out.write("                  position:fixed;\n");
      out.write("                left: 40%; \n");
      out.write("                 padding-top: -50px;\n");
      out.write("                font-family: \"Lucida Calligraphy\";\n");
      out.write("                color:black;\n");
      out.write("                font-size: 200%;\n");
      out.write("            }\n");
      out.write("           #pos1_info_pro{\n");
      out.write("                 position:fixed;\n");
      out.write("                 left : 30%;\n");
      out.write("                 margin: 65px;\n");
      out.write("                 padding-top: 30px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("             #use11{\n");
      out.write("                width: 300px;\n");
      out.write("                height:35px;\n");
      out.write("                background: white; \n");
      out.write("                color: black; \n");
      out.write("                outline: none;\n");
      out.write("                font-size: 15px;\n");
      out.write("                padding: 5px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("                #sub_pro{\n");
      out.write("                background-color: black;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                width:400px;\n");
      out.write("                height:50px;\n");
      out.write("                position: fixed;\n");
      out.write("              \n");
      out.write("                right:36%;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("       ");

             String uid = (String) session.getAttribute("id");
             String passw = (String) session.getAttribute("passw");
             String cat = (String) session.getAttribute("cat");
             session.setAttribute("uid", uid);
             session.setAttribute("cat", cat);




      out.write("\n");
      out.write("\n");
      out.write("<h1 id=\"headpro_info_pro\">Take Leave </h1>\n");
      out.write("         <div id=\"pos1_info_pro\" align=\"left\">\n");
      out.write("        \n");
      out.write("      <form action=\"takeleave\"  method=\"post\"  enctype=\"multipart/form-data\">\n");
      out.write("      \n");
      out.write("               <select name=\"leave_type\"  id=\"use\">\n");
      out.write("                        <option>Select Leave Type</option>\n");
      out.write("                        <option value=\"cl\">Casual Leave</option>\n");
      out.write("                        <option value=\"sl\">Sick Leave</option>\n");
      out.write("                        <option value=\"el\">Earned Leave</option>\n");
      out.write("                       \n");
      out.write("                        \n");
      out.write("                    </select><br><br>\n");
      out.write("                    \n");
      out.write("                    To : <input type=\"date\" name=\"todate\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("             From : <input type=\"date\" name=\"from\"> <br><br>\n");
      out.write("             \n");
      out.write("           <input type=\"text\" name=\"des\" placeholder=\"Description\" id=\"use\" ><br><br>\n");
      out.write("           \n");
      out.write("            Upload Document : <input type=\"file\"   placeholder=\"Browse\" name=\"doc\"  size=\"50\"/><br><br>\n");
      out.write("            \n");
      out.write("                        \n");
      out.write("            <input type=\"submit\" value=\"Submit\" id=\"sub_pro\"/>\n");
      out.write("          </form><br><br><br>\n");
      out.write("             \n");
      out.write("             \n");
      out.write("         </div>\n");
      out.write("         \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"footer\">\n");
      out.write("    <li class=\"fli\"><a href=\"http://www.facebook.com\"><img src=\"img/sf.png\" style=\"\"></a></li>\n");
      out.write("        <li class=\"fli\"><a><img src=\"img/sg.png\" style=\"\"></a></li>\n");
      out.write("\n");
      out.write("     <li class=\"fli\"><a href=\"http://www.instagram.com\"><img src=\"img/si.png\" style=\"width: 30px;height: 30px\"></a></li>\n");
      out.write("    <li class=\"fli\"><a><img src=\"img/su.png\" style=\"width: 30px;height: 30px\"></a></li>\n");
      out.write("    <li class=\"fli\"><a href=\"http://www.twitter.com\"><img src=\"img/st1.png\" style=\"width: 30px;height: 30px\"></a></li>\n");
      out.write("    <a>Copyright@2018 SquaroVention</a>\n");
      out.write("\n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html> \n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
