package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("       <li><a href=\"reg.jsp\">Registration</a></li>\n");
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
      out.write("   \n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("<style>\n");
      out.write("               \n");
      out.write("                  body {\n");
      out.write("    background-color: black;\n");
      out.write("  \n");
      out.write("}\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("</head>\n");
      out.write("<body >\n");
      out.write("\n");
      out.write("<div class=\"mySlides fade\">\n");
      out.write("  \n");
      out.write("  <img src=\"img/home1.jpg\" style=\"width:1350px;height:550px;\">\n");
      out.write("  \n");
      out.write("\n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"mySlides fade\">\n");
      out.write("  \n");
      out.write("  <img src=\"img/home2.jpg\" style=\"width:1350px;height:550px;\">\n");
      out.write("  \n");
      out.write("  \n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"mySlides fade\">\n");
      out.write("  \n");
      out.write("  <img src=\"img/home4.jpg\" style=\"width:1350px;height:550px;\">\n");
      out.write(" \n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<div style=\"text-align:center\">\n");
      out.write("  <span class=\"dot\"></span> \n");
      out.write("  <span class=\"dot\"></span> \n");
      out.write("  <span class=\"dot\"></span> \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("var slideIndex = 0;\n");
      out.write("showSlides();\n");
      out.write("\n");
      out.write("function showSlides() {\n");
      out.write("    var i;\n");
      out.write("    var slides = document.getElementsByClassName(\"mySlides\");\n");
      out.write("    var dots = document.getElementsByClassName(\"dot\");\n");
      out.write("    for (i = 0; i < slides.length; i++) {\n");
      out.write("       slides[i].style.display = \"none\";  \n");
      out.write("    }\n");
      out.write("    slideIndex++;\n");
      out.write("    if (slideIndex > slides.length) {slideIndex = 1}    \n");
      out.write("    for (i = 0; i < dots.length; i++) {\n");
      out.write("        dots[i].className = dots[i].className.replace(\" active\", \"\");\n");
      out.write("    }\n");
      out.write("    slides[slideIndex-1].style.display = \"block\";  \n");
      out.write("    dots[slideIndex-1].className += \" active\";\n");
      out.write("    setTimeout(showSlides, 6000); // Change image every 6 seconds\n");
      out.write("}\n");
      out.write("</script>\n");
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
