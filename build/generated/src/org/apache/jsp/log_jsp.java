package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class log_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/header.jsp");
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

      out.write('\n');
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
      out.write("       <li> <a href=\"admin_log.jsp\">Admin Login</a></li>\n");
      out.write("       <li><a href=\"log.jsp\">Login</a></li>\n");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("               \n");
      out.write("                  body {\n");
      out.write("    background-image: url(\"img/log_img.jpg\");\n");
      out.write("    background-repeat: no-repeat;\n");
      out.write("    background-size:  1367px 800px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    <body>\n");
      out.write("   \n");
      out.write("         \n");
      out.write("          <h1 id=\"headpro\">Login </h1>\n");
      out.write("         <div id=\"pos1_cust\" align=\"right\">\n");
      out.write("             <form action=\"login\"  method=\"post\" name=\"f1\">\n");
      out.write("                  <select name=\"cat\"  id=\"use\">\n");
      out.write("                        <option>Select Option</option>\n");
      out.write("                        <option value=\"principle\">Principle</option>\n");
      out.write("                        <option value=\"HOD\">HOD</option>\n");
      out.write("                        <option value=\"teacher\">Teacher</option>\n");
      out.write("                       \n");
      out.write("                        \n");
      out.write("                    </select><br><br>\n");
      out.write("            <input type=\"text\" name=\"username\" placeholder=\"Username\" id=\"use\" class=\"input-block-level validate[required,custom[onlyLetterSp]]\"><br><br>\n");
      out.write("            <input type=\"password\" name=\"password\" placeholder=\"Password\" id=\"use\" class=\"input-block-level validate[required]\"><br><br>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Login\" id=\"sub_cust\"/>\n");
      out.write("          </form><br><br><br>\n");
      out.write("             \n");
      out.write("         </div>\n");
      out.write("        \n");
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
